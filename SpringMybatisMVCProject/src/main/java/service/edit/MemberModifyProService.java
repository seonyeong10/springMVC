package service.edit;

import org.springframework.beans.factory.annotation.Autowired;

import command.MemberCommand;
import model.DTO.MemberDTO;
import repository.member.MemberEditRepository;
import repository.member.MemberRepository;

public class MemberModifyProService {
	@Autowired
	MemberRepository memberRepository;

	public void execute(MemberCommand memberCommand) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		
		Integer result = memberRepository.updateMember(memberDTO);
	}

}
