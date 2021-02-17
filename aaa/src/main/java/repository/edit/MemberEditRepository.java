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
	
	public List<MemberDTO> getMemberList(MemberDTO memberDTO) {
		statement = namespace + ".getMemberList";
		return sqlSession.selectList(statement, memberDTO);
	}

	public Integer getMemberCount() {
		statement = namespace + ".getMemberCount";
		return sqlSession.selectOne(statement);
	}

	public void deleteMember(String userId) {
		statement = namespace + ".deleteMember";
		sqlSession.delete(statement, userId);
	}

}
