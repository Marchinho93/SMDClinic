package smdclinic.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import smdclinic.model.Result;

public class ResultFormValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Result.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exam", "description.required");
	}
}
