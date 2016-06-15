package smdclinic.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import smdclinic.model.Exam;

public class ExamFormValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Exam.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "examTypology", "examTypology.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doctor", "doctor.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patient", "patient.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "examDate", "examDate.required");
	}
}
