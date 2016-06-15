package smdclinic.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import smdclinic.model.Prerequisite;

@Repository
public class PrerequisiteDaoImpl implements PrerequisiteDao {
	
		@Autowired
		@PersistenceContext(unitName = "models-unit")
		EntityManager em;
		
		@Override
		@Transactional
		public Prerequisite createPrerequisite(String name, String description){
			Prerequisite prerequisite = new Prerequisite(name, description);
			em.persist(prerequisite);
			return prerequisite;
		}
		
		@Override
		public Prerequisite findByName(String name){
			Prerequisite prerequisite = em.find(Prerequisite.class, name);
			return prerequisite;
		}
		
		@Override
		public List<Prerequisite> findAll(){
			return em.createNamedQuery("Prerequisite.findAll", Prerequisite.class).getResultList();
		}
		
		@Override
		@Transactional
		public void removePrerequisite(Prerequisite prerequisite){
			em.remove(prerequisite);
		}
}

