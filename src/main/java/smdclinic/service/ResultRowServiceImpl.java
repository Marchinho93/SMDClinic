package smdclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Result;
import smdclinic.model.ResultIndicator;
import smdclinic.model.ResultRow;
import smdclinic.repository.ResultRowDao;

@Service
public class ResultRowServiceImpl implements ResultRowService {
	
	@Autowired
	ResultRowDao resultRowDao;
	
	public ResultRow createResultRow(long id, String value, ResultIndicator resultIndicator, Result result){
		return this.resultRowDao.createResultRow(id, value, resultIndicator, result);
	}
	
	public ResultRow findByCode(long code){
		return this.resultRowDao.findByCode(code);
	}
	
	public List<ResultRow> findAll(){
		return this.resultRowDao.findAll();
	}
	
	public void removeResultRow(ResultRow resultRow){
		this.resultRowDao.removeResultRow(resultRow);
	}
}