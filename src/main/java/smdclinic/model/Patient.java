package smdclinic.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(sequenceName = "patientSeq", name = "patientSeq", initialValue = 30000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
	@NamedQuery(name = "Patient.findByUsername", query = "SELECT p FROM Patient p WHERE username=:username"),
})

public class Patient implements Serializable{

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="patientSeq")
	@Id
	private long code;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = true)
	private String password;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(nullable = false)
	private String address;
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Exam> exams;
	
	public Patient(String username, String name, String surname, Date dateOfBirth, String address, String password) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.password = password;
	}
	
	public Patient() {
	}

	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams2) {
		this.exams = exams2;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
