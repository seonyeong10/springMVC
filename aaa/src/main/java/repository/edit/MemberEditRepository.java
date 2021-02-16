package repository.edit;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.DTO.MemberDTO;

public class MemberEditRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "mapper.member.memberEditMapper";
	private String statement;
	
	public List<MemberDTO> getMemberList() {
		statement = namespace + ".getMemberList";
		return sqlSession.selectList(statement);
	}

	public Integer getMemberCount() {
		statement = namespace + ".getMemberCount";
		return sqlSession.selectOne(statement);
	}
	
	
}
