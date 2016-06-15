package smdclinic.repository;

import java.util.List;

import smdclinic.model.Doctor;

public interface DoctorDao {	
	
	public Doctor createDoctor(String name, String surname, String fieldOfSpecialization);
	
	public Doctor findByCode(long code);
	
	public List<Doctor> findAll();
	
	public void removeDoctor(Doctor doctor);
}
