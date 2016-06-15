package smdclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Exam;
import smdclinic.model.Result;
import smdclinic.repository.ResultDao;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	ResultDao resultDao;
	
	public Result createResult(Exam exam){
		return this.resultDao.createResult(exam);
	}
	
	public Result createResult(Result result){
		return this.resultDao.createResult(result);
	}
	
	public Result findByCode(long code){
		return this.resultDao.findByCode(code);
	}
	
	public List<Result> findAll(){
		return this.resultDao.findAll();
	}
	
	public void removeResult(Result result){
		this.resultDao.removeResult(result);
	}
}