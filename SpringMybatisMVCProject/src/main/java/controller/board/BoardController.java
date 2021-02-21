package controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.BoardCommand;
import service.board.BoardDeleteService;
import service.board.BoardInfoService;
import service.board.BoardListService;
import service.board.BoardModifyService;
import service.board.BoardWriteService;
import validator.BoardCommandValidator;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	BoardWriteService boardWriteService;
	@Autowired
	BoardListService boardListService;
	@Autowired
	BoardInfoService boardInfoService;
	@Autowired
	BoardModifyService boardModifyService;
	@Autowired
	BoardDeleteService boardDeleteService;
	
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardList(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		boardListService.init(page, model);
		return "board/boardList";
	}
	
	@RequestMapping("boardWrite")
	public String boardWrite(BoardCommand boardCommand) {
		return "board/boardWrite";
	}
	
	@RequestMapping("boardWritePro")
	public String boardWritePro(BoardCommand boardCommand, Errors errors, HttpServletRequest request) {
		// 유효성 검사, 에러 발생하면 되돌아가기
		new BoardCommandValidator().validate(boardCommand, errors);
		if(errors.hasErrors()) {
			return "board/boardWrite";
		}
		// 디비에 저장
		boardWriteService.init(boardCommand, request);
		return "redirect:boardList";
	}
	
	@RequestMapping("boardInfo")
	public String boardInfo(@RequestParam(value = "boardNum") Long boardNum, Model model) {
		boardInfoService.init(boardNum, model);
		return "board/boardInfo";
	}
	
	@RequestMapping("boardModify/{boardNum}")
	public String boardModify(@PathVariable(value = "boardNum") Long boardNum, Model model) {
		boardInfoService.init(boardNum, model);
		return "board/boardModify";
	}
	
	@RequestMapping("boardModifyPro")
	public String boardModifyPro(BoardCommand boardCommand, Errors errors) {
		boardModifyService.init(boardCommand, errors);
		if(errors.hasErrors()) {
			return "redirect:/board/boardModify/" + boardCommand.getBoardNum();
		}
		return "redirect:/board/boardInfo?boardNum=";
	}
	
	@RequestMapping("boardDel/{boardNum}")
	public String boardDel(@PathVariable(value = "boardNum") Long boardNum) {
		boardDeleteService.init(boardNum);
		return "redirect:../boardList";
	}
}
