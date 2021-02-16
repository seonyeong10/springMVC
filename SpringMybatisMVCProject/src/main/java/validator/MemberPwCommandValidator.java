package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberPwCommand;

public class MemberPwCommandValidator implements Validator{
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberPwCommand memberPwCommand = (MemberPwCommand) target;
		ValidationUtils.rejectIfEmpty(errors, "oldPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPwCon", "required");
		if(!memberPwCommand.getNewPw().isEmpty()) {
			if(!memberPwCommand.isNewPwEqualsNewPwCon()) {
				errors.rejectValue("newPwCon", "nomatch");
			}
		}
	}

}
