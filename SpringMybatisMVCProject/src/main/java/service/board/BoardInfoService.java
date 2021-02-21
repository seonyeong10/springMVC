package service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.DTO.BoardDTO;
import repository.board.BoardRepository;

public class BoardInfoService {
	@Autowired
	BoardRepository boardRepository;

	public void init(Long boardNum, Model model) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNum(boardNum);
		
		List<BoardDTO> list = boardRepository.selectBoard(boardDTO);
		model.addAttribute("boardCommand", list.get(0));
	}

}
