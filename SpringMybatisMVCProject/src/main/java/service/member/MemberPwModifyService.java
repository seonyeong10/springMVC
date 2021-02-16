package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.MemberPwCommand;
import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class MemberPwModifyService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void execute(MemberPwCommand memberPwCommand, HttpSession session, Errors errors) {
		MemberDTO memberDTO = new MemberDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		memberDTO.setUserId(authInfo.getUserId());
		memberDTO = memberRepository.selectByMember(memberDTO);	// 회원 정보 가져옴
		if(!bCryptPasswordEncoder.matches(memberPwCommand.getOldPw(), memberDTO.getUserPw())) {
			errors.rejectValue("oldPw", "wrong");
		} else {
			String pw = bCryptPasswordEncoder.encode(memberPwCommand.getNewPw());
			memberDTO.setUserPw(pw);
			Integer result = memberRepository.pwUpdate(memberDTO);
		}
	}
}
