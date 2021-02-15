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
	MemberRepository memberRepository;	// selectByMember 를 이용해 데이터 가져오기 위함
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public void execute(HttpSession session, Model model) {
		/**
		 * session 정보는 authInfo에 저장되어있다.
		 * 내 정보를 가져오려면 어떤 쿼리문 필요? -> 회원 하나만 select한 쿼리문 필요 -> 이미 존재하는가? -> selectByMember
		 * Mapper.xml에 가서 조건절 확인 -> 조건에 맞는 데이터 만들기  -> 쿼리문 사용
		 */
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");	// 로그인 정보
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(authInfo.getUserId());	// 유저 아이디를 dto에 전달
		// select * from member where user_id = userId
		memberDTO = memberRepository.selectByMember(memberDTO);
		model.addAttribute("memberCommand", memberDTO);	// setAttribute
	}

	public void memberUpdate(MemberCommand memberCommand, Errors errors) {
		MemberDTO memberDTO = new MemberDTO();
		Integer result = null;
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO = memberRepository.selectByMember(memberDTO);
		if(memberDTO != null) {
			if(bcryptPasswordEncoder.matches(memberCommand.getUserPw(), memberDTO.getUserPw())) {
				// 업데이트
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
				// 비밀번호 틀림
				errors.rejectValue("userPw", "wrong");
			}
		}
	}
}
