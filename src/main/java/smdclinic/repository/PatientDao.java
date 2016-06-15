package smdclinic.repository;

import java.util.Date;
import java.util.List;

import smdclinic.model.Patient;

public interface PatientDao {

	public Patient createPatient(String username, String name, String surname, Date dateOfBirth, String address,
			String password);

	public Patient findByCode(long code);

	public List<Patient> findAll();

	public void removePatient(Patient patient);

	public Patient findByUsername(String username);

}