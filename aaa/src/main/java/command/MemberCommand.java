package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberCommand {
	/**
	 * 웹브라우저로부터 전송된 데이터 처리 jsp 페이지에서 넘어온 데이터를 받음
	 */
	String userId;
	String userPw;
	String userPwCon;
	String userName;
	String userGender;
	// date 값을 받아오기 위해 필요(없으면 에러)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date userBirth;
	String userPh1;
	String userPh2;
	String userAddr;
	String[] interest; // 배열
	String userEmail;
	
	// 비밀번호와 확인을 비교하는 메서드, true/false 반환
	public boolean isUserPwEqualsUserPwCon() {
		if(userPw.equals(userPwCon)) {
			// 일치하면 true 반환
			return true;
		} else {
			// 일치하지 않으면 false 반환
			return false;
		}
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

	public String getUserPwCon() {
		return userPwCon;
	}

	public void setUserPwCon(String userPwCon) {
		this.userPwCon = userPwCon;
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

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
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

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
