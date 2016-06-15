package smdclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "administratorSeq", name = "administratorSeq", initialValue=10000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Administrator.findByUsername", query = "SELECT a FROM Administrator a WHERE username=:username"),
	@NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a")
})
public class Administrator {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="administratorSeq")
	private long code;
	@Id
	String username;
	@Column(nullable = false)
	String password;
	@Column(nullable=false, length=20)
	private String name;
	@Column(nullable=false, length=20)
	private String surname;
	
	public Administrator(String username, String name, String surname, String password) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
	}
	
	public Administrator(){
	}
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
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
}
