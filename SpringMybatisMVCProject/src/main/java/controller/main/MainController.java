package controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;

@Controller
public class MainController {
	// doget, dopost 따로 사용
	// method = RequestMethod.GET 없으면 두가지 모두 가능
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	// 톰켓에게 jsp파일명 반환
	/*
	public String main(Model model) { 
		model.addAttribute("loginCommand",new LoginCommand());
		return "main";
	}
	*/
	/*
	public String main(LoginCommand loginCommand) { 
		return "main";
	}
	*/
	public String main(@ModelAttribute("loginCommand") LoginCommand loginCommand) { 
		return "main";
	}
}
