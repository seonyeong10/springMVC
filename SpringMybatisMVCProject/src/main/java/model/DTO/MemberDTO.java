package model.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// setter,getter
@AllArgsConstructor	// All the Constructors
@NoArgsConstructor	// Default Constructor	
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
	
	// checkok
	String chkOk;	
}
