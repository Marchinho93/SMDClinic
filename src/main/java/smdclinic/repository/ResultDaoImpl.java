package smdclinic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Exam;
import smdclinic.model.Result;

@Repository
public class ResultDaoImpl implements ResultDao {

	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public Result createResult(Exam exam){
		Result result = new Result(exam);
		em.persist(result);
		return result;
	}
	@Transactional
	public Result createResult(Result result){
		em.persist(result);
		return result;
	}
	
	public Result findByCode(long code){
		Result result = em.find(Result.class, code);
		return result;
	}
	
	public List<Result> findAll(){
		return em.createNamedQuery("Result.findAll", Result.class).getResultList();
	}
	
	@Transactional
	public void removeResult(Result result){
		em.remove(result);
	}
}
