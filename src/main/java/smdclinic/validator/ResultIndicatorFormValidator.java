package smdclinic.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import smdclinic.model.ResultIndicator;

public class ResultIndicatorFormValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return ResultIndicator.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
	}
}
