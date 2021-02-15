package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import command.MemberCommand;
import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class MemberInfoService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(authInfo.getUserId());
		memberDTO = memberRepository.selectMember(memberDTO);
		model.addAttribute("memberCommand", memberDTO);
	}

	public void memberUpdate(MemberCommand memberCommand, Errors errors) {
		MemberDTO memberDTO = new MemberDTO();
		Integer result = null;
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO = memberRepository.selectMember(memberDTO);
		if(memberDTO != null) {
			if(bcryptPasswordEncoder.matches(memberCommand.getUserPw(), memberDTO.getUserPw())) {
				// 비밀번호 맞으면
				memberDTO.setUserId(memberCommand.getUserId());
				memberDTO.setUserAddr(memberCommand.getUserAddr());
				memberDTO.setUserPh1(memberCommand.getUserPh1());
				memberDTO.setUserPh2(memberCommand.getUserPh2());
				String ins = "";
				for(String str : memberCommand.getInterest()) {
					ins += str + "`";
				}
				memberDTO.setInterest(ins);
				result = memberRepository.updateMember(memberDTO);
			} else {
				// 비밀번호 틀리면
				errors.rejectValue("userPw", "notPw");
			}
		}
	}

}
