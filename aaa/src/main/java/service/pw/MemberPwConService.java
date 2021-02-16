package service.pw;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class MemberPwConService {
	// 비밀번호 확인
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public String execute(String userPw, HttpSession session, Model model) {
		MemberDTO memberDTO = new MemberDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		memberDTO.setUserId(authInfo.getUserId());
		memberDTO = memberRepository.selectMember(memberDTO);
		
		if(!bCryptPasswordEncoder.matches(userPw, memberDTO.getUserPw())) {
			model.addAttribute("err", "비밀번호가 다릅니다.");
			return "member/pwForm";
		} else {
			return "member/pwModify";
		}
	}

}
