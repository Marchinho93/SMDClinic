package smdclinic.service;

import java.util.List;

import smdclinic.model.Doctor;

public interface DoctorService {

	public Doctor createDoctor(String name, String surname, String fieldOfSpecialization);
	
	public Doctor findByCode(long code);
	
	public List<Doctor> findAll();
	
	public void removeDoctor(Doctor doctor);
}
