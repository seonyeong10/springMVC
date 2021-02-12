package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberJoinService;
import validator.MemberCommandValidator;

@Controller
@RequestMapping("/register")
public class MemberController {
	// memberJoinService 생성되어야 함.
	@Autowired
	MemberJoinService memberJoinService;	// 여기서 memberCommand에 데이터 저장
	
	@RequestMapping(value = "agree")
	public String agree() {
		return "member/agree";
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String regist(Model model) {
		model.addAttribute("memberCommand", new MemberCommand());
		return "member/memberForm";
	}
	
	// 유효성 검사
	@RequestMapping(value = "memberJoin")
	public String memberJoin(MemberCommand memberCommand, Errors errors, Model model) {
		// jsp페이지에서 데이터를 받아올 객체, 에러 발생시 보여줄 메세지, 처리된 데이터를 담을 객체
		/**
		 * 유효성 검사를 위해서는 Error 객체가 필요
		 * Error는 커맨드 객체 다음에 선언되어야 한다.
		 */
		// 유효성검사를 시행할 객체 필요
		// 이 객체는 MemberCommand와 Errors를 매개변수로 받는다.
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			// 에러가 있다면 멤버 폼으로 돌아가라
			return "member/memberForm";
		}
		memberJoinService.execute(memberCommand);
		return "member/memberWelcome";
	}
	
	// 메일 확인
	@RequestMapping("memberMail")
	public String memberMail(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "receiver") String receiver,
			@RequestParam(value = "userId") String userId
			) {
		Integer i = memberJoinService.numUpdate(num, receiver, userId);	// chkOk 업데이트
		if(i>0) {
			return "member/success";
		} else {
			return "member/fail";
		}
		
	}
}
