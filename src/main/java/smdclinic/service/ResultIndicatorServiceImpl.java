package smdclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.ResultIndicator;
import smdclinic.repository.ResultIndicatorDao;

@Service
public class ResultIndicatorServiceImpl implements ResultIndicatorService {
	
	@Autowired
	ResultIndicatorDao resultIndicatorDao;
	
	@Override
	public ResultIndicator createResultIndicator(String description){
		return this.resultIndicatorDao.createResultIndicator(description);
	}
	
	@Override
	public ResultIndicator findByDescription(String description){
		return this.resultIndicatorDao.findByDescription(description);
	}

	@Override
	public List<ResultIndicator> findAll(){
		return this.resultIndicatorDao.findAll();
	}

	@Override
	public void removeResultIndicator(ResultIndicator resultIndicator){
		this.resultIndicatorDao.removeResultIndicator(resultIndicator);
	}
}
