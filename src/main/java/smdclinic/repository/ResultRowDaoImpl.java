package smdclinic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Result;
import smdclinic.model.ResultIndicator;
import smdclinic.model.ResultRow;

@Repository
public class ResultRowDaoImpl implements ResultRowDao {
	
	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public ResultRow createResultRow(long id, String value, ResultIndicator resultIndicator, Result result){
		ResultRow resultRow = new ResultRow(id, value, resultIndicator, result);
		em.persist(resultRow);
		return resultRow;
	}
	
	public ResultRow findByCode(long code){
		ResultRow resultRow = em.find(ResultRow.class, code);
		return resultRow;
	}
	
	public List<ResultRow> findAll(){
		return em.createNamedQuery("ResultRow.findAll", ResultRow.class).getResultList();
	}
	
	@Transactional
	public void removeResultRow(ResultRow resultRow){
		em.remove(resultRow);
	}
}