package smdclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Doctor;
import smdclinic.repository.DoctorDao;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorDao doctorDao;
	
	public Doctor createDoctor(String name, String surname, String fieldOfSpecialization){
		return this.doctorDao.createDoctor(name, surname, fieldOfSpecialization);
	}
	
	public Doctor findByCode(long code){
		return this.doctorDao.findByCode(code);
	}
	
	public List<Doctor> findAll(){
		return this.doctorDao.findAll();
	}
	
	public void removeDoctor(Doctor doctor){
		this.doctorDao.removeDoctor(doctor);
	}
}

