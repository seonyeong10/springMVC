package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberPwCommand;

public class MemberPwValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberPwCommand memberPwCommand = (MemberPwCommand) target;
		// 공백 검사
		ValidationUtils.rejectIfEmpty(errors, "oldPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPwCon", "required");
		
		// 새 비밀번호 검사
		if(memberPwCommand.getNewPw() != null) {
			if(!memberPwCommand.isEqualNewPw()) {
				// 비밀번호와 확인이 다르면
				errors.rejectValue("newPwCon", "nomatch");
			}
		}
	}

}
