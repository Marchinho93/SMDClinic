package smdclinic.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Administrator;

@Repository
public class AdministratorDaoImpl implements AdministratorDao{
	
	@Autowired
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	@Transactional
	public Administrator createAdministrator(String username, String name, String surname, String password){
		Administrator administrator = new Administrator(username, name, surname, password);
		em.persist(administrator);
		return administrator;
	}
	
	public Administrator findByUsername(String username) throws SQLException{
		TypedQuery<Administrator> query = em.createNamedQuery("Administrator.findByUsername", Administrator.class); 
		query.setParameter("username", username);
		List<Administrator> result = query.getResultList();
		if(result.isEmpty()) return null;
		if(result.size()==1) return result.get(0);
		else
			throw new NonUniqueResultException();
		
	}
	
	public List<Administrator> findAll(){
		return em.createNamedQuery("Administrator.findAll", Administrator.class).getResultList();
	}
	
	@Transactional
	public void removeAdministrator(Administrator administrator){
		em.remove(administrator);
	}

}
