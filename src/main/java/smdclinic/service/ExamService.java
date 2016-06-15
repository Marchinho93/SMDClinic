package smdclinic.service;

import java.util.Date;
import java.util.List;

import smdclinic.model.Doctor;
import smdclinic.model.Exam;
import smdclinic.model.ExamTypology;
import smdclinic.model.Patient;

public interface ExamService {

	public Exam createExam(Date examDate, Patient patient, Doctor doctor, ExamTypology examTypology);
	
	public Exam createExam(Exam exam);

	public Exam findByCode(long code);

	public List<Exam> findByPatient(Patient patient);

	public List<Exam> findByDoctor(Doctor doctor);

	public void removeExam(Exam exam);

	public List<Exam> findAll();

	public List<Exam> findExamsWOResult();

	public void updateResult(Exam exam);

	

}