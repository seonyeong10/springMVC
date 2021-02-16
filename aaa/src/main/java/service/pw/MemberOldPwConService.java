package service.pw;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.MemberPwCommand;
import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class MemberOldPwConService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void execute(MemberPwCommand memberPwCommand, Errors errors, HttpSession session) {
		MemberDTO memberDTO = new MemberDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		memberDTO.setUserId(authInfo.getUserId());
		memberDTO = memberRepository.selectMember(memberDTO);
		
		if(bCryptPasswordEncoder.matches(memberPwCommand.getOldPw(), memberDTO.getUserPw())) {
			//업데이트
			String password = bCryptPasswordEncoder.encode(memberPwCommand.getNewPw());
			memberDTO.setUserPw(password);
			Integer result = memberRepository.updatePassword(memberDTO);
		} else {
			errors.rejectValue("oldPw", "nomatch");
		}
	}
	
}
