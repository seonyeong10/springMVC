package controller.lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.FileInfo;
import command.LibCommand;
import service.lib.FileDeleteService;
import service.lib.LibDeleteService;
import service.lib.LibInfoService;
import service.lib.LibListService;
import service.lib.LibModifyService;
import service.lib.LibWriteService;
import validator.BoardCommandValidator;

@Controller
@RequestMapping("lib")
public class LibController {
	@Autowired
	LibWriteService libWriteService;
	@Autowired
	LibListService libListService;
	@Autowired
	LibInfoService libInfoService;
	@Autowired
	LibModifyService libModifyService;
	@Autowired
	LibDeleteService libDeleteService;
	@Autowired
	FileDeleteService fileDeleteService;
	
	@RequestMapping("libList")
	public String libList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
		libListService.init(page, model);
		return "lib/libList";
	}
	
	@RequestMapping("libWrite")
	public String libWrite(LibCommand libCommand) {
		return "lib/libWrite";
	}
	
	@RequestMapping("libWritePro")
	public String libWritePro(LibCommand libCommand, Errors errors, HttpServletRequest request) {
		new BoardCommandValidator().validate(libCommand, errors);
		if(errors.hasErrors()) {
			return "lib/libWrite";
		}
		libWriteService.init(libCommand, request);
		return "redirect:libList";
	}
	
	@RequestMapping("libInfo")
	public String libInfo(@RequestParam(value = "boardNum") Long boardNum, Model model) {
		libInfoService.init(boardNum, model);
		return "lib/libInfo";
	}
	
	@RequestMapping("libModify/{boardNum}")
	public String libModify(@PathVariable(value = "boardNum") Long boardNum, Model model) {
		libInfoService.init(boardNum, model);
		return "lib/libModify";
	}
	
	@RequestMapping("libmodifyPro")
	public String libmodifyPro(LibCommand libCommand, Model model) {
		String path =  libModifyService.init(libCommand, model);
		return path;
	}
	
	
	@RequestMapping("libDelete/{boardNum}")
	public String libDelete(@PathVariable(value = "boardNum") Long boardNum) {
		libDeleteService.init(boardNum);
		return "redirect:../libList";
	}
	
	@RequestMapping("fileDel")
	public String fileDel(FileInfo fileInfo, HttpSession session, Model model) {
		fileDeleteService.init(fileInfo, session, model);
		return "lib/fileDel";
	}

}
