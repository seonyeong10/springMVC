package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import command.MemberCommand;

public class MemberInfoValidator implements Validator{
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberCommand memberCommand = (MemberCommand) target;
		
		// 빈칸검사
		ValidationUtils.rejectIfEmpty(errors, "userPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh1", "required");
		ValidationUtils.rejectIfEmpty(errors, "userAddr", "required");
		ValidationUtils.rejectIfEmpty(errors, "userEmail", "required");
		ValidationUtils.rejectIfEmpty(errors, "interest", "required");
	}
	
}
