package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import command.MemberPwCommand;
import model.AuthInfo;
import service.member.MemberInfoService;
import service.pw.MemberDelService;
import service.pw.MemberOldPwConService;
import service.pw.MemberPwConService;
import validator.MemberInfoValidator;
import validator.MemberPwValidator;

@Controller
@RequestMapping("mem")
public class MemberInfoController {
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberPwConService memberPwConService;
	@Autowired
	MemberOldPwConService memberOldPwConService;
	@Autowired
	MemberDelService memberDelService;
	
	@RequestMapping("memberInfo")
	public String memberInfo(HttpSession session, Model model) {
		// 세션으로부터 로그인한 사용자 정보 가져오기 + 모델 객체에 저장해 jsp페이지로 반환
		memberInfoService.execute(session, model);
		return "member/memberInfo";
	}
	
	@RequestMapping("memberModify")
	public String memberModify(HttpSession session, Model model) {
		memberInfoService.execute(session, model);
		return "member/memberModify";
	}
	
	@RequestMapping("memberModifyAct")
	public String memberModifyAct(MemberCommand memberCommand, Errors errors, Model model) {
		// 유효성 검사
		new MemberInfoValidator().validate(memberCommand, errors);
		memberInfoService.memberUpdate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberModify";
		}
		return "redirect:memberInfo";
	}
	
	@RequestMapping("pwForm")
	public String pwForm() {
		return "member/pwForm";
	}
	
	@RequestMapping("pwModify")
	public String pwModify(@RequestParam(value = "userPw") String userPw, HttpSession session, Model model) {
		// form 비밀번호가 일치하면 페이지 열고 아니면 redirect
		String path = memberPwConService.execute(userPw, session, model);
		return path;
	}
	
	@RequestMapping("pwModifyAct")
	public String pwModifyAct(MemberPwCommand memberPwCommand, Errors errors, HttpSession session) {
		/**
		 * 현재 비밀번호 일치 확인
		 * 새 비밀번호와 비밀번호 일치 확인
		 * 변경
		 */
		new MemberPwValidator().validate(memberPwCommand, errors);
		if(errors.hasErrors()) {
			return "member/pwModify";
		} else {
			memberOldPwConService.execute(memberPwCommand, errors, session);
			return "redirect:memberInfo";
		}
	}
	
	@RequestMapping("memberDel")
	public String memberDel() {
		return "member/memberDelForm";
	}
	
	@RequestMapping("memberDelAct")
	public String memberDelAct(@RequestParam(value = "userPw") String userPw, Model model, HttpSession session) {
		/**
		 * 회원삭제 후 세션만료
		 */
		String path = memberDelService.execute(userPw, model, session);
		return path;
	}
}
