package smdclinic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.ExamTypology;
import smdclinic.model.Prerequisite;
import smdclinic.model.ResultIndicator;

@Repository
public class ExamTypologyDaoImpl implements ExamTypologyDao {
	
	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public ExamTypology createExamTypology(String name, String description,String price, List<ResultIndicator> resultIndicators, List<Prerequisite> prerequisites){
		ExamTypology examTypology = new ExamTypology(name, description, price, resultIndicators, prerequisites);
		em.persist(examTypology);
		return examTypology;
	}

	@Transactional
	public ExamTypology findByCode(long code){
		ExamTypology examTypology = em.find(ExamTypology.class, code);
		return examTypology;
	}
	
	public List<ExamTypology> findAll(){
		return em.createNamedQuery("ExamTypology.findAll", ExamTypology.class).getResultList();
	}
}
