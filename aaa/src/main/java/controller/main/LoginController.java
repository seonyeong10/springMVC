package controller.main;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;
import service.auth.AuthService;
import validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	AuthService authService;
	
	// 주소를 입력해서 들어올 수 없음
	@RequestMapping(method = RequestMethod.GET)
	public String main() {
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session) {
		// 로그인 유효성 검사
		new LoginCommandValidator().validate(loginCommand, errors);
		authService.authenticate(loginCommand, errors, session);
		if(errors.hasErrors()) {
			return "main";
		}
		return "redirect:/";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
