package controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.edit.MemberDetailService;
import service.edit.MemberEditDelService;
import service.edit.MemberEditModifyService;
import service.edit.MemberListService;

@Controller
@RequestMapping("edit")
public class MemberEditController {
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberEditModifyService memberEditModifyService;
	@Autowired
	MemberEditDelService memberEditDelService;
	
	@RequestMapping("memberList")
	public String memberList(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		/**
		 * 회원 리스트 출력
		 * 페이징 위해서 페이지 넘버 필요
		 */
		memberListService.execute(page, model);
		return "edit/memberList";
	}
	
	@RequestMapping("memberInfoDetail")
	public String memberInfoDetail(@RequestParam(value = "userId") String userId, Model model) {
		memberDetailService.init(userId, model);
		return "edit/memberInfoDetail";
	}
	
	@RequestMapping("modifyMember/{userId}")
	public String modifyMember(@PathVariable(value = "userId") String userId, Model model) {
		memberDetailService.init(userId, model);
		return "edit/memberModify";
	}
	
	@RequestMapping("modifyMemberPro")
	public String modifyMemberPro(MemberCommand memberCommand) {
		memberEditModifyService.init(memberCommand);
		return "redirect:memberInfoDetail?userId=" + memberCommand.getUserId();
	}
	
	@RequestMapping("deleteMember/{userId}")
	public String deleteMember(@PathVariable(value = "userId") String userId) {
		memberEditDelService.init(userId);
		return "redirect:../memberList";
	}
}
