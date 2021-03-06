package model.DTO;

import java.sql.Timestamp;

public class BoardDTO {
	Long boardNum;
	String userId;
	String boardWriter;
	String boardSubject;
	String boardContent;
	String boardPw;
	Long boardCount;
	String ipAddr;
	Timestamp boardRegist;

	StartEndPageDTO startEndPageDTO;

	public StartEndPageDTO getStartEndPageDTO() {
		return startEndPageDTO;
	}

	public void setStartEndPageDTO(StartEndPageDTO startEndPageDTO) {
		this.startEndPageDTO = startEndPageDTO;
	}

	public BoardDTO() {
	}

	public BoardDTO(Long boardNum, String userId, String boardWriter, String boardSubject, String boardContent,
			String boardPw, Long boardCount, String ipAddr, Timestamp boardRegist) {
		super();
		this.boardNum = boardNum;
		this.userId = userId;
		this.boardWriter = boardWriter;
		this.boardSubject = boardSubject;
		this.boardContent = boardContent;
		this.boardPw = boardPw;
		this.boardCount = boardCount;
		this.ipAddr = ipAddr;
		this.boardRegist = boardRegist;
	}

	public Long getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardSubject() {
		return boardSubject;
	}

	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
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

	public Long getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(Long boardCount) {
		this.boardCount = boardCount;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Timestamp getBoardRegist() {
		return boardRegist;
	}

	public void setBoardRegist(Timestamp boardRegist) {
		this.boardRegist = boardRegist;
	}

}
