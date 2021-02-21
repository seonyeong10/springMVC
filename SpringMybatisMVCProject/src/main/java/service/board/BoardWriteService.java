package service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.BoardCommand;
import model.AuthInfo;
import model.DTO.BoardDTO;
import repository.board.BoardRepository;

public class BoardWriteService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	BoardRepository boardRepository;

	public void init(BoardCommand boardCommand, HttpServletRequest request) {
		BoardDTO boardDTO = new BoardDTO();
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		boardDTO.setBoardContent(boardCommand.getBoardContent());
		boardDTO.setBoardPw(
				bCryptPasswordEncoder.encode(boardCommand.getBoardPw()));
		boardDTO.setBoardSubject(boardCommand.getBoardSubject());
		boardDTO.setBoardWriter(boardCommand.getBoardWriter());
		boardDTO.setUserId(authInfo.getUserId());
		boardDTO.setIpAddr(request.getRemoteAddr());
		
		boardRepository.insertBoard(boardDTO);
	}

}
