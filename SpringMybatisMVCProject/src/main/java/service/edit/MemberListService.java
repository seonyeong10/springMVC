package service.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.DTO.MemberDTO;
import repository.member.MemberEditRepository;

public class MemberListService {
	@Autowired
	MemberEditRepository memberEditRepository;

	public void execute(Model model) {
		// 리스트 가져오기
		List<MemberDTO> list = memberEditRepository.getMemberList();
		int count = memberEditRepository.getMemberCount();	// 회원수
		model.addAttribute("memberList", list);
		model.addAttribute("memberCount", count);
	}

}
