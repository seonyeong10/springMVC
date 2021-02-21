package service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.DTO.BoardDTO;
import model.DTO.StartEndPageDTO;
import repository.board.BoardRepository;

public class BoardListService {
	@Autowired
	BoardRepository boardRepository;

	public void init(int page, Model model) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setStartEndPageDTO(new StartEndPageDTO(startRow, endRow));
		
		List<BoardDTO> list = boardRepository.selectBoard(boardDTO);
		Integer count = boardRepository.selectCount();
		System.out.println(count);
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, page, limitPage, "boardList?");
	}

}
