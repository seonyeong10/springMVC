package service.lib;

import org.springframework.beans.factory.annotation.Autowired;

import repository.lib.LibRepository;

public class LibDeleteService {
	@Autowired
	LibRepository libRepository;

	public void init(Long boardNum) {
		libRepository.deleteLib(boardNum);
	}

}
