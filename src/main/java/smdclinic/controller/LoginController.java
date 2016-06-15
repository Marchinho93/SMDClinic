package smdclinic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import smdclinic.model.Administrator;
import smdclinic.model.Patient;
import smdclinic.service.AdministratorService;
import smdclinic.service.PatientService;





@Controller
@Scope(value="session")
public class LoginController{

	@Autowired
	private AdministratorService adminService;
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="/index", params="auth", method =	RequestMethod.GET)
	public String getIndexFail(){
		return "index";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String getIndex(){
		return "index";
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/loggedUserInit", method =	RequestMethod.GET)
	public void loggedUserInit(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String username, loginString = "";
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = user.getUsername();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)user.getAuthorities();
		GrantedAuthority admAuth = new SimpleGrantedAuthority("admin");
		GrantedAuthority patAuth = new SimpleGrantedAuthority("patient");

		if(authorities.contains(admAuth)){
			Administrator admin = this.adminService.findByUsername(username);
			loginString = "Hello, " + admin.getName();
			session.setAttribute("admin", admin);
		}
		if(authorities.contains(patAuth)){
			Patient patient = this.patientService.findByUsername(username);
			loginString = "Hello, " + patient.getName();
			session.setAttribute("patient", patient);				
		}
		session.setAttribute("role", authorities.iterator().next().getAuthority());
		session.setAttribute("loginString", loginString);
		
		response.sendRedirect(request.getContextPath()+"/index");
	}
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/logoutDataPurge", method =	RequestMethod.GET)
	public void logoutDataPurge(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException{
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index");
	}

}
