package smdclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Doctor;
import smdclinic.model.Exam;
import smdclinic.model.ExamTypology;
import smdclinic.model.Patient;
import smdclinic.repository.ExamDao;

@Service
public class ExamServiceImpl implements ExamService {
	
		@Autowired
		ExamDao examDao;

		public Exam createExam(Date examDate, Patient patient, Doctor doctor, ExamTypology examTypology){
			return this.examDao.createExam(examDate, patient, doctor, examTypology);
		}
		
		public Exam createExam(Exam exam){
			return this.examDao.createExam(exam.getExamDate(), exam.getPatient(), exam.getDoctor(), exam.getExamTypology());
		}
		
		public Exam findByCode(long code){
			return this.examDao.findByCode(code);
		}
		
		public List<Exam> findByPatient(Patient patient){
			return this.examDao.findByPatient(patient);
		}
		
		public List<Exam> findByDoctor(Doctor doctor){
			return this.examDao.findByDoctor(doctor);
		}
		
		public void removeExam(Exam exam){
			this.examDao.removeExam(exam);
		}

		public List<Exam> findAll() {
			return this.examDao.findAll();
		}
		
		public List<Exam> findExamsWOResult(){
			return this.examDao.findExamsWOResult();
		}
		
		public void updateResult(Exam exam){
			this.examDao.updateResult(exam);
		}

}
