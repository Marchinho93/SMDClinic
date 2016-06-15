package smdclinic.validator;

import java.beans.PropertyEditorSupport;

import smdclinic.model.ExamTypology;
import smdclinic.service.ExamTypologyService;

public class ExamTypologyFormSupport extends PropertyEditorSupport {

    private ExamTypologyService examTypologyService;

    public ExamTypologyFormSupport(ExamTypologyService examTypologyService){
        this.examTypologyService = examTypologyService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ExamTypology examTypology = null;
        try {
            long id = Long.parseLong(text);
            examTypology = this.examTypologyService.findByCode(id);
        } catch (NullPointerException ex) {
            throw new NullPointerException(this.examTypologyService.toString());
        }
        setValue(examTypology);
    }
}
