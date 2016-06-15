package smdclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(sequenceName = "examTypologySeq", name = "examTypologySeq", initialValue = 50000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "ExamTypology.findAll", query = "SELECT e FROM ExamTypology e")
})
public class ExamTypology {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "examTypologySeq")
	private long code;
	@Column(nullable =false)
	private String name;
	private String description;
	private String price;
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@Fetch(FetchMode.SELECT)
	private List<ResultIndicator> resultIndicators;
	@OneToMany(fetch = FetchType.EAGER,mappedBy="examTypology", cascade = CascadeType.MERGE)
	private List<Exam> exams;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Prerequisite> prerequisites;
	
	public ExamTypology(String name, String description, String price, List<ResultIndicator> resultIndicators, List<Prerequisite> prerequisites) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.resultIndicators = resultIndicators;
		this.prerequisites = prerequisites;
	}
	
	public ExamTypology() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<ResultIndicator> getResultIndicators() {
		return resultIndicators;
	}
	public void setResultIndicators(List<ResultIndicator> resultIndicators) {
		this.resultIndicators = resultIndicators;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams2) {
		this.exams = exams2;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}

	public List<Prerequisite> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Prerequisite> prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	
}
