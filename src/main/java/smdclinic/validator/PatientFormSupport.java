package smdclinic.validator;

import java.beans.PropertyEditorSupport;

import javax.annotation.Resource;

import smdclinic.model.Patient;
import smdclinic.service.PatientService;

@Resource
public class PatientFormSupport extends PropertyEditorSupport {

    private PatientService patientService;

    public PatientFormSupport(PatientService patientService){
        this.patientService = patientService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Patient patient = null;
        try {
            long id = Long.parseLong(text);
            patient = this.patientService.findByCode(id);
        } catch (NullPointerException ex) {
            throw new NullPointerException(this.patientService.toString());
        }
        setValue(patient);
    }
}