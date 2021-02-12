package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberCommand;

public class MemberCommandValidator implements Validator {
	/**
	 * 유효성 검사를 시행할 객체(class) 
	 * validator 라는 인터페이스를 상속하여 사용한다.
	 * 메서드를 오버라이드 하지 않으면 class 명 뒤에 빨간줄이 그어지며 오류 발생
	 */
	
	private static final String emailRegExp = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private Pattern pattern;
	public MemberCommandValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {	// 이거 안씀
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		/**
		 * 유효성 검사에 사용할 메서드!
		 * jsp페이지를 통해 입력된 데이터를 검사하므로 taget으로 MemberCommand 지정
		 * 1) 빈 공간이 있는지 검사
		 * 2) 비밀번호 일치 확인
		 * 3) 이메일 형식 확인
		 */
		MemberCommand regReq = (MemberCommand) target;
		if(!regReq.getUserPw().isEmpty()) {
			// 비어있지 않다면
			if(!regReq.isUserPwEqualsUserPwCon()) {
				errors.rejectValue("userPwCon", "nomatch");
			}
		}
		if(!regReq.getUserEmail().trim().isEmpty()) {
			Matcher matcher = pattern.matcher(regReq.getUserEmail());
			if(!matcher.matches()) {
				errors.rejectValue("userEmail", "bad");
			}
		} else {
			errors.rejectValue("userEmail", "required");
		}
		// rejectIfEmptyOrWhitespace : 공백문자를 허용하지 않겠다.
		// 에러, 검사할 파라미터 name(변수이름), 에러 유형
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		// rejectIfEmpty : 공백문자를 허용한다.
		ValidationUtils.rejectIfEmpty(errors, "userPwCon", "required");
		ValidationUtils.rejectIfEmpty(errors, "userName", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh1", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh2", "required");
		ValidationUtils.rejectIfEmpty(errors, "userAddr", "required");
		ValidationUtils.rejectIfEmpty(errors, "userEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "interest", "required");
		ValidationUtils.rejectIfEmpty(errors, "userBirth", "required");
	}
}
