package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "boardPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardContent", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardSubject", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardWriter", "required");
	}

}
