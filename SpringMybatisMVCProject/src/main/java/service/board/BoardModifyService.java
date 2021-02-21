package service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;

import command.BoardCommand;
import model.DTO.BoardDTO;
import repository.board.BoardRepository;

public class BoardModifyService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	BoardRepository boardRepository;

	public void init(BoardCommand boardCommand, Errors errors) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNum(boardCommand.getBoardNum());
		
		List<BoardDTO> list = boardRepository.selectBoard(boardDTO);
		
		if(bCryptPasswordEncoder.matches(boardCommand.getBoardPw(), list.get(0).getBoardPw())) {
			boardDTO.setBoardContent(boardCommand.getBoardContent());
			boardDTO.setBoardSubject(boardCommand.getBoardSubject());
			boardRepository.updateBoard(boardDTO);
		} else {
			errors.rejectValue("boardPw", "nomatch");
		}
		
	}

}
