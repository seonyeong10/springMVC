package service.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.DTO.LibDTO;
import repository.lib.LibRepository;

public class LibInfoService {
	@Autowired
	LibRepository libRepository;

	public void init(Long boardNum, Model model) {
		LibDTO libDTO = new LibDTO();
		libDTO.setBoardNum(boardNum);
		
		List<LibDTO> list = libRepository.selectLib(libDTO);
		model.addAttribute("list", list.get(0));
		
	}

}
