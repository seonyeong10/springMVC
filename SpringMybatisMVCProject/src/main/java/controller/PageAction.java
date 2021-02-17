package controller;

import org.springframework.ui.Model;

public class PageAction {
	public void page(Model model, int count, int limit, int page, int limitPage, String pageURL) {
		// 페이지 바
//		long maxPage = (int) Math.ceil((double)count / limit);
		int maxPage = (int)((double)count / limit + 0.95);
		// page : 파라미터로 받아온 변수
		int startPage = (int) (((double)page / limitPage + 0.95) - 1) * limitPage + 1;
		int endPage = startPage + limitPage - 1;
		if(endPage > maxPage) endPage = maxPage;
		model.addAttribute("page", page);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageURL", pageURL);	// 모든 리스트페이지에서 사용하기 위함(페이지를 알아야 한다.)
	}
}
