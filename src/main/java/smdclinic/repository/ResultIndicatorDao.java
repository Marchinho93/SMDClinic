package smdclinic.repository;

import java.util.List;

import smdclinic.model.ResultIndicator;

public interface ResultIndicatorDao {

	public ResultIndicator createResultIndicator(String description);
	
	public ResultIndicator findByDescription(String description);

	public List<ResultIndicator> findAll();

	public void removeResultIndicator(ResultIndicator resultIndicator);


}