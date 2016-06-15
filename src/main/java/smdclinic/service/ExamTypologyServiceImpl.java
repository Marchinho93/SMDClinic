package smdclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.ExamTypology;
import smdclinic.model.Prerequisite;
import smdclinic.model.ResultIndicator;
import smdclinic.repository.ExamTypologyDao;

@Service
public class ExamTypologyServiceImpl implements ExamTypologyService {
	
	@Autowired
	ExamTypologyDao examTypologyDao;
	
	public ExamTypology createExamTypology(String name, String description,String price, List<ResultIndicator> resultIndicators, List<Prerequisite> prerequisites){
		return this.examTypologyDao.createExamTypology(name, description, price, resultIndicators, prerequisites);
	}

	public ExamTypology findByCode(long code){
		return this.examTypologyDao.findByCode(code);
	}
	
	public List<ExamTypology> findAll(){
		return this.examTypologyDao.findAll();
	}
}
