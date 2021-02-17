package model.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MemberDTO {
	/**
	 * 컴파일 할 때 세터게터가 자동으로 만들어짐
	 * 코딩할 때 적지 않아도 된다!(없어도 된다X)
	 */
	String userId;
	String userPw;
	String userName;
	String userGender;
	Timestamp userBirth; // QueryString으로 전송되어도 자동 형변환
	String userPh1;
	String userPh2;
	String userAddr;
	String interest; // 배열
	Timestamp userRegist;
	String userEmail;
	String chkOk; // checkok
	
	// 페이징하기 위해 dto에 객체를 추가, 자동생성 삭제(문제소지 있기때문)
	StartEndPageDTO startEndPageDTO;
	
	public MemberDTO() {
		
	}

	// StartEndPageDTO를 제외한 생성자를 만듦
	public MemberDTO(String userId, String userPw, String userName, String userGender, Timestamp userBirth,
			String userPh1, String userPh2, String userAddr, String interest, Timestamp userRegist, String userEmail,
			String chkOk) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userGender = userGender;
		this.userBirth = userBirth;
		this.userPh1 = userPh1;
		this.userPh2 = userPh2;
		this.userAddr = userAddr;
		this.interest = interest;
		this.userRegist = userRegist;
		this.userEmail = userEmail;
		this.chkOk = chkOk;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Timestamp getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Timestamp userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPh1() {
		return userPh1;
	}

	public void setUserPh1(String userPh1) {
		this.userPh1 = userPh1;
	}

	public String getUserPh2() {
		return userPh2;
	}

	public void setUserPh2(String userPh2) {
		this.userPh2 = userPh2;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Timestamp getUserRegist() {
		return userRegist;
	}

	public void setUserRegist(Timestamp userRegist) {
		this.userRegist = userRegist;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getChkOk() {
		return chkOk;
	}

	public void setChkOk(String chkOk) {
		this.chkOk = chkOk;
	}

	public StartEndPageDTO getStartEndPageDTO() {
		return startEndPageDTO;
	}

	public void setStartEndPageDTO(StartEndPageDTO startEndPageDTO) {
		this.startEndPageDTO = startEndPageDTO;
	}
	
}
