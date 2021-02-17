package service.edit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import controller.PageAction;
import model.DTO.MemberDTO;
import model.DTO.StartEndPageDTO;
import repository.member.MemberEditRepository;

public class MemberListService {
	@Autowired
	MemberEditRepository memberEditRepository;

	public void execute(Model model, Integer page) {
		int limit = 10;	// 한 페이지 출력개수
		int limitPage = 10;	// 페이지 바 개수
//		long startRow = ((long)page - 1) * 10 + 1;	// 시작행 ex) 11
//		long endRow = startRow + limit - 1;	// 끝 행 ex) 20
		long start = ((long)page - 1) * 10 + 1;	
		long end = start + limit - 1;
		
		/**
		 * 마이바티스에서는 하나의 파라미터 타입만 받을 수 있으므로
		 * 페이징을 위한 객체를 만들어야 한다.
		 */
//		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow, endRow);
		// StartEndPageDTO를 MemberDTO 객체 안에 넣어주었기 때문에 MemberDTO 객체를 생성해야 사용가능함.
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setStartEndPageDTO(new StartEndPageDTO(start, end));
		
		
		// 리스트 가져오기
		List<MemberDTO> list = memberEditRepository.getMemberList(memberDTO);
		int count = memberEditRepository.getMemberCount();	// 회원수
		model.addAttribute("memberList", list);
		model.addAttribute("memberCount", count);
		
		// 페이지 바
		PageAction pageAction = new PageAction();
		// 저장할 객체, 총 데이터 개수, 한 페이지에 출력할 개수, 현재 페이지 번호, 최대 페이지 바 개수, url
		pageAction.page(model, count, limit, page, limitPage, "memberList?");
	}

}
