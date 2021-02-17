package service.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import model.DTO.MemberDTO;
import repository.edit.MemberEditRepository;

@Service
public class MemberDetailService {
	@Autowired
	MemberEditRepository memberEditRepository;

	public void init(String userId, Model model) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(userId);
		List<MemberDTO> list = memberEditRepository.getMemberList(memberDTO);
		
		model.addAttribute("memberCommand", list.get(0));
	}

	
}
