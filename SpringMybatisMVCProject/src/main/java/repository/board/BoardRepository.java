package repository.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.DTO.BoardDTO;

public class BoardRepository {
	@Autowired
	private SqlSession sqlSession;

	private final String namespace = "mapper.board.boardMapper";
	private String statement;

	public Integer insertBoard(BoardDTO boardDTO) {
		statement = namespace + ".insertBoard";
		return sqlSession.insert(statement, boardDTO);
	}

	public List<BoardDTO> selectBoard(BoardDTO boardDTO) {
		statement = namespace + ".selectBoard";
		return sqlSession.selectList(statement, boardDTO);
	}

	public Integer selectCount() {
		statement = namespace + ".selectCount";
		return sqlSession.selectOne(statement);
	}

	public Integer updateBoard(BoardDTO boardDTO) {
		statement = namespace + ".updateBoard";
		return sqlSession.update(statement, boardDTO);
	}

	public Integer deleteBoard(Long boardNum) {
		statement = namespace + ".deleteBoard";
		return sqlSession.delete(statement, boardNum);
	}

}
