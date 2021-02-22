package service.lib;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import command.LibCommand;
import model.AuthInfo;
import model.DTO.LibDTO;
import repository.lib.LibRepository;

@Service
public class LibWriteService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	LibRepository libRepository;

	public void init(LibCommand libCommand, HttpServletRequest request) {
		LibDTO libDTO = new LibDTO();
		libDTO.setBoardContent(libCommand.getBoardContent());
		libDTO.setBoardPw(bCryptPasswordEncoder.encode(libCommand.getBoardPw()));
		libDTO.setBoardSubject(libCommand.getBoardSubject());
		libDTO.setBoardWriter(libCommand.getBoardWriter());
		libDTO.setIpAddr(request.getRemoteAddr());
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		libDTO.setUserId(authInfo.getUserId());
		
		// 파일저장
		String path = "WEB-INF/view/lib/upload";
		String filePath = session.getServletContext().getRealPath(path);
		String originalFileNames = "";
		String storeFileNames = "";
		String fileSizes = "";
		
		try {
			for(MultipartFile mf : libCommand.getReport()) {
				String originalFileName = mf.getOriginalFilename();
				String originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
				String fileSize = Long.toString(mf.getSize());
				
				originalFileNames += originalFileName + "`";
				storeFileNames += store + "`";
				fileSizes += fileSize + "`";
				
				File file = new File(filePath + "/" + store);
				mf.transferTo(file);
				
				libDTO.setOriginalFileName(originalFileNames);
				libDTO.setStoreFileName(storeFileNames);
				libDTO.setFileSize(fileSizes);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		libRepository.insertLib(libDTO);
	}

}
