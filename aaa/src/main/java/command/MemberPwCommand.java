package command;

public class MemberPwCommand {
	String oldPw;
	String newPw;
	String newPwCon;
	
	// 새 비밀번호 확인
	public boolean isEqualNewPw() {
		if(newPw.equals(newPwCon)) {
			return true;
		} else {
			return false;
		}
	}

	public String getOldPw() {
		return oldPw;
	}

	public void setOldPw(String oldPw) {
		this.oldPw = oldPw;
	}

	public String getNewPw() {
		return newPw;
	}

	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}

	public String getNewPwCon() {
		return newPwCon;
	}

	public void setNewPwCon(String newPwCon) {
		this.newPwCon = newPwCon;
	}

}
