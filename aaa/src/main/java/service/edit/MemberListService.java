package service.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageService;
import model.DTO.MemberDTO;
import model.DTO.StartEndPageDTO;
import repository.edit.MemberEditRepository;

public class MemberListService {
	@Autowired
	MemberEditRepository memberEditRepository;

	public void execute(int page, Model model) {
		// Pagination
		int dataPerPage = 10; // 한 페이지에 출력할 데이터 개수
		int startDataNum = (page - 1) * dataPerPage + 1; // 시작행 1, 11, 21, 31, 41 ...
		int endDateNum = page * dataPerPage; // 끝행 10, 20, 30 ...

		// 데이터 개수 조절은 여러 페이지에서 활용가능하므로 객체로 생성
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setStartEndPageDTO(new StartEndPageDTO(startDataNum, endDateNum));

		// 리스트
		List<MemberDTO> list = memberEditRepository.getMemberList(memberDTO);
		Integer count = memberEditRepository.getMemberCount();
		model.addAttribute("list", list);
		model.addAttribute("count", count); // 총 회원수 = 총 데이터 개수

		// 페이지바
		PageService pageService = new PageService();
		pageService.init(page, count, dataPerPage, "memberList?", model);

	}

}
