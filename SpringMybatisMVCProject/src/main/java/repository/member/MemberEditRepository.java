package repository.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.DTO.MemberDTO;
import model.DTO.StartEndPageDTO;

public class MemberEditRepository {
	@Autowired
	private SqlSession sqlSession;	// jdbc에서 받아옴
	private final String namespace = "mapper.edit.memberEditMapper";
	private String statement = "";
	
	public List<MemberDTO> getMemberList(MemberDTO memberDTO){
		statement = namespace + ".selectMember";
		return sqlSession.selectList(statement);
	}
	
	public int getMemberCount() {
		statement = namespace + ".selectCount";
		return sqlSession.selectOne(statement);
	}

	public Integer deleteMember(String userId) {
		statement = namespace + ".deleteMember";
		return sqlSession.update(statement, userId);
	}

}
