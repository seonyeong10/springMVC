package model.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
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
	String chkOk;

}
