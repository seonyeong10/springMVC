package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.MemberCommand;
import service.member.MemberInfoService;
import validator.MemberInfoValidator;

@Controller
@RequestMapping("mem")
public class MemberInfoController {
	@Autowired
	MemberInfoService memberInfoService;
	
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
}
