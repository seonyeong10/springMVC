package service.auth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.LoginCommand;
import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class AuthService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	private AuthInfo authInfo;
	public void authenticate(LoginCommand loginCommand, Errors errors, HttpSession session) {
		// db에 있으면 저장, 없으면 에러 반환
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(loginCommand.getLoginId());
		memberDTO = memberRepository.selectMember(memberDTO);
		if(memberDTO == null) {
			errors.reject("loginId", "notId");
		} else {
			if(memberDTO.getChkOk() == null) {
				errors.rejectValue("loginId", "notChk");
			} else {
				if(bcryptPasswordEncoder.matches(loginCommand.getLoginPw(), memberDTO.getUserPw())) {
					authInfo = new AuthInfo(memberDTO.getUserId(), memberDTO.getUserEmail(), memberDTO.getUserName());
					session.setAttribute("authInfo", authInfo);
				}
			}
		}
	}
	
}
