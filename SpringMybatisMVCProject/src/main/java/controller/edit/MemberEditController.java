package controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.edit.MemberDeleteProService;
import service.edit.MemberDetailService;
import service.edit.MemberListService;
import service.edit.MemberModifyProService;

@Controller
@RequestMapping("/edit")
public class MemberEditController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyProService memberModifyProService;
	@Autowired
	MemberDeleteProService memberDeleteProService;
	
	@RequestMapping("memberList")
	public String memberList(@RequestParam(value = "page", defaultValue = "1") Integer page ,Model model) {
		// 페이지 값이 넘어와야 한다.
		// 처음 눌렀을 땐 페이지 값이 없음.
		memberListService.execute(model, page);
		return "edit/memberList";
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo(@RequestParam(value = "userId") String userId, Model model) {
		memberDetailService.execute(userId, model);
		return "edit/memberInfo";
	}
	
	// {변수} 주소가 아니고 변수임을 알림
	@RequestMapping("memberModify/{userId}")
	public String memberModify(@PathVariable(value = "userId") String userId, Model model) {
		// 쿼리스트링으로 받아오면 requestParam
		// 주소로 받아오면 pathVariable (주소가 변함)
		memberDetailService.execute(userId, model);
		return "edit/memberModify";
	}
	
	@RequestMapping("memberModifyPro")
	public String memberModifyPro(MemberCommand memberCommand) {
		memberModifyProService.execute(memberCommand);
		return "redirect:memberInfo?userId=" + memberCommand.getUserId();
	}

	@RequestMapping("memberDelete/{userId}")
	public String memberDelete(@PathVariable(value = "userId") String userId) {
		memberDeleteProService.execute(userId);
		return "redirect:../memberList";
	}
}
