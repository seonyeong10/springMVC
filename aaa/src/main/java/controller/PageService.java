package controller;

import org.springframework.ui.Model;

public class PageService {

	public void init(int page, Integer count, int dataPerPage, String pageURL, Model model) {
		int maxPageBar = (int) Math.ceil((double)count / dataPerPage);
		int startBarNum = (page - 1) * dataPerPage + 1;	// 페이지바 시작 번호
		int endBarNum = page * dataPerPage;	// 페이지바 끝번호
		if(endBarNum > maxPageBar) endBarNum = maxPageBar;
		
		model.addAttribute("page", page);
		model.addAttribute("maxPageBar", maxPageBar);	// 페이지바 최대 개수
		model.addAttribute("startBarNum", startBarNum);	// 시작 페이지바 번호
		model.addAttribute("endBarNum", endBarNum);		// 마지막 페이지바 번호
		model.addAttribute("pageURL", pageURL);		// 마지막 페이지바 번호
	}
}
