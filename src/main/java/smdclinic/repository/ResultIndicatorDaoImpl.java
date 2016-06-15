package smdclinic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.ResultIndicator;

@Repository
public class ResultIndicatorDaoImpl implements ResultIndicatorDao{

	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;

	@Transactional
	public ResultIndicator createResultIndicator(String description){
		ResultIndicator resultIndicator = new ResultIndicator(description);
		em.persist(resultIndicator);
		return resultIndicator;
	}

	public ResultIndicator findByDescription(String description){
		return em.find(ResultIndicator.class, description);
	}

	public List<ResultIndicator> findAll(){
		return em.createNamedQuery("ResultIndicator.findAll", ResultIndicator.class).getResultList();
	}
	@Transactional
	public void removeResultIndicator(ResultIndicator resultIndicator){
		em.remove(resultIndicator);
	}


}
