package smdclinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "ResultIndicator.findAll", query = "SELECT r FROM ResultIndicator r")
})
public class ResultIndicator {
	@Id
	private String description;

	public ResultIndicator(String description){
		this.description = description;
	}
	
	public ResultIndicator() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
