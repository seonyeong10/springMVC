package service.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.DTO.MemberDTO;
import repository.member.MemberEditRepository;

public class MemberDetailService {
	@Autowired
	MemberEditRepository editRepository;

	public void execute(String userId, Model model) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(userId);
		List<MemberDTO> list = editRepository.getMemberList(memberDTO);
		
		model.addAttribute("memberCommand", list.get(0));
	}

}
