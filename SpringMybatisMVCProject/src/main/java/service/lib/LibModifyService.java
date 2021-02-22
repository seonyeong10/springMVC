package service.lib;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import command.LibCommand;
import model.DTO.LibDTO;
import repository.lib.LibRepository;

@Service
public class LibModifyService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	LibRepository libRepository;

	public String init(LibCommand libCommand, Model model) {
		LibDTO libDTO = new LibDTO();
		libDTO.setBoardNum(Long.parseLong(libCommand.getBoardNum()));
		
		List<LibDTO> list = libRepository.selectLib(libDTO);
		
		if(bCryptPasswordEncoder.matches(libCommand.getBoardPw(), list.get(0).getBoardPw())) {
			libDTO.setBoardSubject(libCommand.getBoardSubject());
			libDTO.setBoardContent(libCommand.getBoardContent());
			
			libRepository.updateLib(libDTO);
			return "redirect:libInfo?boardNum=" + libCommand.getBoardNum();
			
		} else {
//			model.addAttribute("err", "비밀번호가 일치하지 않습니다.");
			return "redirect:libModify/" + libCommand.getBoardNum();
		}
	}

}
