package service.pw;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class MemberDelService {
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public String execute(String userPw, Model model, HttpSession session) {
		MemberDTO memberDTO = new MemberDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		memberDTO.setUserId(authInfo.getUserId());
		memberDTO = memberRepository.selectMember(memberDTO);
		
		if(bCryptPasswordEncoder.matches(userPw, memberDTO.getUserPw())) {
			Integer result = memberRepository.deleteMember(memberDTO);
			session.invalidate();
			return "redirect:/";
		} else {
			model.addAttribute("err", "비밀번호가 일치하지 않습니다.");
			return "member/memberDelForm";
		}
	}
	
}
