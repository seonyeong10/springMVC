package service.board;

import org.springframework.beans.factory.annotation.Autowired;

import repository.board.BoardRepository;

public class BoardDeleteService {
	@Autowired
	BoardRepository boardRepository;

	public void init(Long boardNum) {
		boardRepository.deleteBoard(boardNum);
	}

}
