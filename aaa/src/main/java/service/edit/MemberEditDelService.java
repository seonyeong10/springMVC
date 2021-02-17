package service.edit;

import org.springframework.beans.factory.annotation.Autowired;

import repository.edit.MemberEditRepository;

public class MemberEditDelService {
	@Autowired
	MemberEditRepository editRepository;

	public void init(String userId) {
		editRepository.deleteMember(userId);
	}

}
