package service.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.member.MemberEditRepository;

@Service
public class MemberDeleteProService {
	@Autowired
	MemberEditRepository memberEditRepository;

	public void execute(String userId) {
		Integer result = memberEditRepository.deleteMember(userId);
		System.out.println(result + "개가 삭제되었습니다.");
	}

}