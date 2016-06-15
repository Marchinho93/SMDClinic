package smdclinic.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import smdclinic.model.ExamTypology;

public class ExamTypologyFormValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return ExamTypology.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resultIndicators", "resultIndicators.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prerequisites", "prerequisites.required");
	}
}
