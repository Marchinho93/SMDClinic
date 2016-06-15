package smdclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Prerequisite;
import smdclinic.repository.PrerequisiteDao;

@Service
public class PrerequisiteServiceImpl implements PrerequisiteService{
	
	@Autowired
	PrerequisiteDao prerequisiteDao;
	
	public Prerequisite createPrerequisite(String name, String description){
		return this.prerequisiteDao.createPrerequisite(name, description);
	}
	
	public Prerequisite findByName(String name){
		return this.prerequisiteDao.findByName(name);
	}
	
	public List<Prerequisite> findAll(){
		return this.prerequisiteDao.findAll();
	}
	
	public void removePrerequisite(Prerequisite prerequisite){
		this.prerequisiteDao.removePrerequisite(prerequisite);
	}
}
