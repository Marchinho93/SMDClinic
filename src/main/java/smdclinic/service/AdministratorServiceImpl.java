package smdclinic.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smdclinic.model.Administrator;
import smdclinic.repository.AdministratorDao;

@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	@Autowired
	AdministratorDao administratorDao;
	
	public Administrator createAdministrator(String username, String name, String surname, String password){
		return this.administratorDao.createAdministrator(username, name, surname, password);
	}
	
	public Administrator findByUsername(String username) throws SQLException{
		return this.administratorDao.findByUsername(username);
	}
	
	public List<Administrator> findAll(){
		return this.administratorDao.findAll();
	}
	
	public void removeAdministrator(Administrator administrator){
		this.administratorDao.removeAdministrator(administrator);
	}

}
