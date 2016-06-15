package smdclinic.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "ResultRow.findAll", query = "SELECT rr FROM ResultRow rr")
})
public class ResultRow implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ResultRowPK pk;
	@Column(nullable=false)
	private String value;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "resultIndicator")
	private ResultIndicator description;

	public ResultRow(long id, String value, ResultIndicator description, Result result) {
		this.pk = new ResultRowPK(id, result);
		this.value = value;
		this.description = description;
	}

	public ResultRow(){
	}
	
	public ResultRow(long id, Result result, ResultIndicator description) {
		this.pk = new ResultRowPK(id, result);
		this.description = description;
	}

	public long getId() {
		return this.pk.getId();
	}

	public void setId(long id) {
		this.pk.setId(id);
	}
	
	public Result getResult() {
		return this.pk.getResult();
	}

	public void setResult(Result result) {
		this.pk.setResult(result);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ResultIndicator getDescription() {
		return description;
	}

	public void setDescription(ResultIndicator description) {
		this.description = description;
	}
}