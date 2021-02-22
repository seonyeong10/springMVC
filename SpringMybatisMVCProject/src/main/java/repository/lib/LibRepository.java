package repository.lib;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.DTO.LibDTO;

public class LibRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "mapper.lib.libMapper";
	private String statement;

	public Integer insertLib(LibDTO libDTO) {
		statement = namespace + ".insertLib";
		return sqlSession.update(statement, libDTO);
	}

	public List<LibDTO> selectLib(LibDTO libDTO) {
		statement = namespace + ".selectLib";
		return sqlSession.selectList(statement, libDTO);
	}

	public Integer selectCount() {
		statement = namespace + ".selectCount";
		return sqlSession.selectOne(statement);
	}

	public Integer updateLib(LibDTO libDTO) {
		statement = namespace + ".updateLib";
		return sqlSession.update(statement, libDTO);
	}

	public Integer deleteLib(Long boardNum) {
		statement = namespace + ".deleteLib";
		return sqlSession.delete(statement, boardNum);
	}

}
