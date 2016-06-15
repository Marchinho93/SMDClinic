package smdclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(sequenceName = "doctorSeq", name = "doctorSeq", initialValue = 20000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Doctor.findAll", query = "SELECT a FROM Doctor a"),
	@NamedQuery(name = "Doctor.findByCode", query = "SELECT a FROM Doctor a WHERE code=:code")
})
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctorSeq")
	private long code;
	@Column(nullable=false, length = 20)
	private String name;
	@Column(nullable=false, length = 20)
	private String surname;
	private String fieldOfSpecialization;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "doctor", cascade = CascadeType.MERGE)
	@Fetch(FetchMode.SUBSELECT)
	private List<Exam> exams;

	public Doctor(String name, String surname, String fieldOfSpecialization) {
		this.name = name;
		this.surname = surname;
		this.fieldOfSpecialization = fieldOfSpecialization;
	}

	public Doctor() {
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFieldOfSpecialization() {
		return fieldOfSpecialization;
	}

	public void setFieldOfSpecialization(String fieldOfSpecialization) {
		this.fieldOfSpecialization = fieldOfSpecialization;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
}
