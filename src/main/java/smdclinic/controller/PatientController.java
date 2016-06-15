package smdclinic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import smdclinic.model.Patient;
import smdclinic.service.ExamService;
import smdclinic.service.ExamTypologyService;

@Controller
public class PatientController {
	
	@Autowired
	private ExamTypologyService examTypologyService;
	@Autowired
	private ExamService examService;
	
	@PreAuthorize("hasAnyRole('patient')")
	@RequestMapping(value = "/patientArea", method = RequestMethod.GET)
	public String patientArea(){
		return "patientArea";
	}
	
	@PreAuthorize("hasAnyRole('patient')")
	@RequestMapping(value = "/listExamTypologies", method =  RequestMethod.GET)
	public String getExamTypologies(Model model){
		model.addAttribute("examTypologiesList", this.examTypologyService.findAll());
		return "showExamTypologies";
	}
	
	@PreAuthorize("hasAnyRole('patient')")
	@RequestMapping(value = "/listResults", method = RequestMethod.GET)
	public String getResults(Model model, HttpSession session, HttpServletRequest req){
		Patient patient = (Patient) session.getAttribute("patient");
		model.addAttribute("examList", this.examService.findByPatient(patient));
		return "myResults";
	}
}
