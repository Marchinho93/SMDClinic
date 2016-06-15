package smdclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Patient;
import smdclinic.repository.PatientDao;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDao patientDao;
	
	public Patient createPatient(String username, String name, String surname, Date dateOfBirth, String address, String password){
		return this.patientDao.createPatient(username, name, surname, dateOfBirth, address, password);
	}
	
	public Patient findByCode(long code){
		return this.patientDao.findByCode(code);
	}
	
	public List<Patient> findAll(){
		return this.patientDao.findAll();
	}
	
	public void removePatient(Patient patient){
		this.patientDao.removePatient(patient);
	}

	public Patient findByUsername(String username){
		return this.patientDao.findByUsername(username);
	}
}
