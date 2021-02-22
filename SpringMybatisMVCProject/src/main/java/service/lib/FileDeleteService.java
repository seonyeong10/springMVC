package service.lib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import command.FileInfo;

@Service
public class FileDeleteService {

	public void init(FileInfo fileInfo, HttpSession session, Model model) {
		List<FileInfo> list = (List<FileInfo>) session.getAttribute("fileList");
		
		if(list == null) {
			list = new ArrayList<FileInfo>();
		}
		
		Integer num = 0;	// 리스트에 추가되면 1, 제거되면 0
		Boolean newFile = true;	// 트루면 파일 추가
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getOriginalFileName().equals(fileInfo.getOriginalFileName())) {
				list.remove(list.get(i));
				newFile = false;
				num = 0;
			}
		}
		
		if(newFile) {
			list.add(fileInfo);
			num = 1;
		}
		
		model.addAttribute("val", num);
		session.setAttribute("fileList", list);
	}

}
