package repository.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.DTO.MemberDTO;

@Repository
public class MemberRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "mapper.member.memberMapper";
	private String statement;
	public Integer insertMember(MemberDTO memberDTO) {
		statement = namespace + ".memberInsert";
		return sqlSession.insert(statement, memberDTO);
	}
	public MemberDTO selectMember(MemberDTO memberDTO) {
		statement = namespace + ".selectMember";
		return sqlSession.selectOne(statement, memberDTO);
	}
	public Integer joinOkUpdate(MemberDTO memberDTO) {
		statement = namespace + ".joinOkUpdate";
		return sqlSession.update(statement, memberDTO);
	}
	public Integer updateMember(MemberDTO memberDTO) {
		statement = namespace + ".updateMember";
		return sqlSession.update(statement, memberDTO);
	}
	public Integer updatePassword(MemberDTO memberDTO) {
		statement = namespace + ".updatePassword";
		return sqlSession.update(statement, memberDTO);
	}
	public Integer deleteMember(MemberDTO memberDTO) {
		statement = namespace + ".deleteMember";
		return sqlSession.update(statement, memberDTO);
	}
}
