package smdclinic.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public Patient createPatient(String username, String name, String surname, Date dateOfBirth, String address, String password){
		Patient patient = new Patient(username, name, surname, dateOfBirth, address, password);
		em.persist(patient);
		return patient;
	}
	
	public Patient findByCode(long code){
		return em.find(Patient.class, code);
	}
	
	public List<Patient> findAll(){
		return em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
	}
	
	@Transactional
	public void removePatient(Patient patient){
		em.remove(patient);
	}

	public Patient findByUsername(String username){
		TypedQuery<Patient> query = em.createNamedQuery("Patient.findByUsername", Patient.class); 
		query.setParameter("username", username);
		List<Patient> result = query.getResultList();
		if(result.isEmpty()) return null;
		if(result.size()==1) return result.get(0);
		else
			throw new NonUniqueResultException();
	}
}
