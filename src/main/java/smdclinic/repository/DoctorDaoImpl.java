package smdclinic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public Doctor createDoctor(String name, String surname, String fieldOfSpecialization){
		Doctor doctor = new Doctor(name, surname, fieldOfSpecialization);
		em.persist(doctor);
		return doctor;
	}

	
	public Doctor findByCode(long code){
		Doctor doctor = em.find(Doctor.class, code);
		return doctor;
	}
	
	public List<Doctor> findAll(){
		return em.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
	}
	
	@Transactional
	public void removeDoctor(Doctor doctor){
		em.remove(doctor);
	}
}
