package smdclinic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator (sequenceName = "resultSeq", name = "resultSeq", initialValue = 60000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
})
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultSeq")
	private long code;
	@OneToMany(mappedBy = "pk.result", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ResultRow> resultsRows;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Exam exam;
	
	public Result(List<ResultRow> resultsRows, Exam exam) {
		this.resultsRows = resultsRows;
		this.exam = exam;
	}
	
	public Result(Exam exam) {
		this.exam = exam;
	}
	
	public Result(){
	}

	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public List<ResultRow> getResultsRows() {
		return resultsRows;
	}
	public void setResultsRows(List<ResultRow> resultsRows) {
		this.resultsRows = resultsRows;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
}