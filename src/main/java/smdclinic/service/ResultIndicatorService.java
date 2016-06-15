package smdclinic.service;

import java.util.List;

import smdclinic.model.ResultIndicator;

public interface ResultIndicatorService {

	ResultIndicator createResultIndicator(String description);

	ResultIndicator findByDescription(String description);

	List<ResultIndicator> findAll();

	void removeResultIndicator(ResultIndicator resultIndicator);

}