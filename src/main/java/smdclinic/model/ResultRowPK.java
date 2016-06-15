package smdclinic.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ResultRowPK implements Serializable{
	private static final long serialVersionUID = 1L;

	public long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "result_code")
	public Result result;
	
	public ResultRowPK(long id, Result result){
		this.id = id;
		this.result = result;
	}
	
	public ResultRowPK(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
