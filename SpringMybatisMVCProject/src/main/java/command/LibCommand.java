package command;

import org.springframework.web.multipart.MultipartFile;

public class LibCommand {
	String boardSubject;
	String boardWriter;
	String boardContent;
	String boardPw;
	String boardNum;
	
	MultipartFile[] report;
	
	public MultipartFile[] getReport() {
		return report;
	}

	public void setReport(MultipartFile[] report) {
		this.report = report;
	}

	public String getBoardSubject() {
		return boardSubject;
	}

	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardPw() {
		return boardPw;
	}

	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}

	public String getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}

}
