package command;

public class BoardCommand {
	String boardSubject;
	String boardWriter;
	String boardContent;
	String boardPw;
	Long boardNum;

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

	public Long getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}

}
