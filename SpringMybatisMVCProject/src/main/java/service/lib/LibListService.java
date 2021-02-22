package service.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import controller.PageAction;
import model.DTO.LibDTO;
import model.DTO.StartEndPageDTO;
import repository.lib.LibRepository;

@Service
public class LibListService {
	@Autowired
	LibRepository libRepository;

	public void init(Integer page, Model model) {
		int limit = 10;
		int limitPage = 10;
		Long startRow = ((long)page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		
		LibDTO libDTO = new LibDTO();
		libDTO.setStartEndPageDTO(new StartEndPageDTO(startRow, endRow));
		
		List<LibDTO> list = libRepository.selectLib(libDTO);
		Integer count = libRepository.selectCount();
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		PageAction action = new PageAction();
		action.page(model, count, limit, page, limitPage, "libList?");
	}

}
