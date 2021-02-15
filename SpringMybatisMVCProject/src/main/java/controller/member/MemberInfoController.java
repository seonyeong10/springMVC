package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import command.MemberCommand;
import service.member.MemberInfoService;
import validator.MemberCommandValidator;

@Controller
@RequestMapping("mem")
public class MemberInfoController {
	@Autowired
	MemberInfoService memberInfoService;
	
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
}
