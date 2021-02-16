package service.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.DTO.MemberDTO;
import repository.edit.MemberEditRepository;

public class MemberListService {
	@Autowired
	MemberEditRepository memberEditRepository;

	public void execute(Model model) {
		List<MemberDTO> list = memberEditRepository.getMemberList();
		Integer count = memberEditRepository.getMemberCount();
		model.addAttribute("list", list);
		model.addAttribute("count", count);
	}


}
