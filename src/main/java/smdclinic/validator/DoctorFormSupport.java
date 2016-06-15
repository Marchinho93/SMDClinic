package smdclinic.validator;

import java.beans.PropertyEditorSupport;

import javax.annotation.Resource;

import smdclinic.model.Doctor;
import smdclinic.service.DoctorService;

@Resource
public class DoctorFormSupport extends PropertyEditorSupport {

    private DoctorService doctorService;

    public DoctorFormSupport(DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Doctor doctor = null;
        try {
            long id = Long.parseLong(text);
            doctor = this.doctorService.findByCode(id);
        } catch (NullPointerException ex) {
            throw new NullPointerException(this.doctorService.toString());
        }
        setValue(doctor);
    }
}