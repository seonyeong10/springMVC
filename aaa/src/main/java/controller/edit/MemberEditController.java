package controller.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.edit.MemberListService;

@Controller
@RequestMapping("edit")
public class MemberEditController {
	@Autowired
	MemberListService memberListService;
	
	@RequestMapping("memberList")
	public String memberList(Model model) {
		/**
		 * 회원 리스트 출력
		 */
		memberListService.execute(model);
		return "edit/memberList";
	}
}
