package smdclinic.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Doctor;
import smdclinic.model.Exam;
import smdclinic.model.ExamTypology;
import smdclinic.model.Patient;

@Repository
public class ExamDaoImpl implements ExamDao {
	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public Exam createExam(Date examDate, Patient patient, Doctor doctor, ExamTypology examTypology){
		Exam exam = new Exam(examDate, patient, doctor, examTypology);
		em.persist(exam);
		return exam;
	}
	
	public Exam findByCode(long code){
		Exam exam = em.find(Exam.class, code);
		return exam;
	}
	
	public List<Exam> findByPatient(Patient patient){
		return em.createNamedQuery("Exam.findByPatient", Exam.class).setParameter("patient_code", patient.getCode()).getResultList();
	}
	
	public List<Exam> findByDoctor(Doctor doctor){
		return em.createNamedQuery("Exam.findByDoctor", Exam.class).setParameter("doctor_code", doctor.getCode()).getResultList();
	}
	
	@Transactional
	public void removeExam(Exam exam){
		em.remove(exam);
	}

	@Override
	public List<Exam> findAll() {
		return em.createNamedQuery("Exam.findAll", Exam.class).getResultList();
	}
	
	public List<Exam> findExamsWOResult(){
		return em.createNamedQuery("Exam.findExamsWOResult", Exam.class).getResultList();
	}
	
	@Transactional
	public void updateResult(Exam exam){
		em.merge(exam);
	}
}
