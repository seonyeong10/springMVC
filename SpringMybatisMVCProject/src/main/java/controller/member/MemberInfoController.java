package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import command.MemberPwCommand;
import service.member.MemberDelService;
import service.member.MemberInfoService;
import service.member.MemberPwModifyService;
import validator.MemberCommandValidator;
import validator.MemberPwCommandValidator;

@Controller
@RequestMapping("mem")
public class MemberInfoController {
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberPwModifyService memberPwModifyService;
	@Autowired
	MemberDelService memberDelService;
	
	@RequestMapping("memberDetail")
	public String memberDetail(HttpSession session, Model model) {
		/**
		 * 세션에서 사용자 정보 가져옴(session)
		 * 받아온 정보를 담은(Model)
		 */
		memberInfoService.execute(session, model);
		return "member/memberDetail";	// jsp페이지 이름
	}
	
	@RequestMapping("memberModify")
	public String memberModify(HttpSession session, Model model) {
		memberInfoService.execute(session, model);
		return "member/memberModify";
	}
	
	@RequestMapping("memberModifyPro")
	public String memberModifyPro(MemberCommand memberCommand, Errors errors) {
		new MemberCommandValidator().validate(memberCommand, errors);
		memberInfoService.memberUpdate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberModify";
		}
		return "redirect:memberDetail";	// 수정하고 디테일페이지로 돌아감(새로열지 않음)
	}
	
	// 비밀번호 변경
	@RequestMapping("memberPwForm")
	public String memberPwForm() {
		return "member/memberPwForm";
	}
	
	@RequestMapping("memberPwModify")
	public String memberPwModify(@RequestParam(value = "userPw") String userPw, HttpSession session, Model model) {
		/**
		 * 맞으면 이동 틀리면 에러메세지 출력
		 * 모델로 에러처리 가능함
		 */
		String path = memberInfoService.pwUpdate(userPw, session, model);
		return path;
	}
	
	@RequestMapping("memberPwModifyPro")
	public String memberPwModifyPro(MemberPwCommand memberPwCommand, Errors errors, HttpSession session) {
		new MemberPwCommandValidator().validate(memberPwCommand, errors);	// 새 비밀번호 유효성 검사
		memberPwModifyService.execute(memberPwCommand, session, errors);		// 기존 비밀번호 일치 검사 + 업데이트
		if(errors.hasErrors()) {
			return "member/memberPwModify";
//			return "redirect:memberPwModify";
		}
		// jsp 페이지를 열지 않고 주소를 이동할 땐 redirect
		return "redirect:memberDetail";
	}
	
	@RequestMapping("memberDel")
	public String memberDel() {
		return "member/memberDelForm";
	}
	
	@RequestMapping("memberDelPro")
	public String memberDelPro(@RequestParam(value = "userPw") String userPw, HttpSession session, Model model) {
		// 회원탈퇴
		String path = memberDelService.execute(userPw, session, model);
		return path;
	}
}
