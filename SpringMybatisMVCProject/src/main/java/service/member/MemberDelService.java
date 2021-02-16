package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.DTO.MemberDTO;
import repository.member.MemberRepository;

public class MemberDelService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	MemberRepository memberRepository;

	public String execute(String userPw, HttpSession session, Model model) {
		MemberDTO memberDTO = new MemberDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		memberDTO.setUserId(authInfo.getUserId());
		memberDTO = memberRepository.selectByMember(memberDTO);

		if (bCryptPasswordEncoder.matches(userPw, memberDTO.getUserPw())) {
			// 회원 삭제
			Integer result = memberRepository.deleteMember(memberDTO);
			session.invalidate();
			return "redirect:/";

		} else {
			model.addAttribute("err", "비밀번호가 다릅니다.");
			return "member/memberDelForm";
		}
	}

}
