package smdclinic.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(sequenceName = "examSeq", name = "examSeq", initialValue=40000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
	@NamedQuery(name = "Exam.findExamsWOResult", query = "SELECT e FROM Exam e WHERE result_code is null"),
	@NamedQuery(name = "Exam.findByPatient", query = "SELECT e FROM Exam e WHERE e.patient.code = :patient_code"),
	@NamedQuery(name = "Exam.findByDoctor", query = "SELECT e FROM Exam e WHERE e.doctor.code = :doctor_code")
})
public class Exam {
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date examDate;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "examSeq")
	private long code;
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "patient_code", referencedColumnName = "code")
	private Patient patient;
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private Result result;
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	private Doctor doctor;
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	private ExamTypology examTypology;
	
	public Exam(Date examDate, Patient patient, Doctor doctor, ExamTypology examTypology) {
		this.bookingDate = new Date();
		this.examDate = examDate;
		this.patient = patient;
		this.doctor = doctor;
		this.examTypology = examTypology;
	}

	public Exam() {
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public ExamTypology getExamTypology() {
		return examTypology;
	}

	public void setExamTypology(ExamTypology examTypology) {
		this.examTypology = examTypology;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
		this.result.setExam(this);
	}
	
	
}
