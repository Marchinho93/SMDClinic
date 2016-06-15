package smdclinic.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import smdclinic.model.Doctor;
import smdclinic.model.Exam;
import smdclinic.model.ExamTypology;
import smdclinic.model.Patient;
import smdclinic.model.Prerequisite;
import smdclinic.model.Result;
import smdclinic.model.ResultIndicator;
import smdclinic.model.ResultRow;
import smdclinic.service.DoctorService;
import smdclinic.service.ExamService;
import smdclinic.service.ExamTypologyService;
import smdclinic.service.PatientService;
import smdclinic.service.PrerequisiteService;
import smdclinic.service.ResultIndicatorService;
import smdclinic.service.ResultService;
import smdclinic.validator.DoctorFormSupport;
import smdclinic.validator.ExamTypologyFormSupport;
import smdclinic.validator.PatientFormSupport;
import smdclinic.validator.PrerequisiteFormSupport;

@Controller
@Scope(value="session")
public class AdminController {
	@Autowired
	private ResultIndicatorService resultIndicatorService;
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamTypologyService examTypologyService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PrerequisiteService prerequisiteService;
	@Autowired
	private ResultService resultService;
	
	@Autowired
	@Qualifier("examValidator")
	private Validator examValidator;
	
	@Autowired
	@Qualifier("prerequisiteValidator")
	private Validator prerequisiteValidator;
	
	@Autowired
	@Qualifier("resultIndicatorValidator")
	private Validator resultIndicatorValidator;
	
	@Autowired
	@Qualifier("examTypologyValidator")
	private Validator examTypologyValidator;
	
	@Autowired
	@Qualifier("doctorValidator")
	private Validator doctorValidator;
	
	@Autowired
	@Qualifier("resultValidator")
	private Validator resultValidator;
	
	private List<Exam> examWOResult;
	
	private List<ResultRow> resultRow;
	private Exam exam;
	private Result result;
	private List<ResultIndicator> resultIndicatorList;
	

	@InitBinder("exam")
	public void initExamBinder(WebDataBinder binder) {
		binder.setValidator(examValidator);
		binder.registerCustomEditor(Doctor.class, new DoctorFormSupport(this.doctorService));
		binder.registerCustomEditor(Patient.class, new PatientFormSupport(this.patientService));
		binder.registerCustomEditor(ExamTypology.class, new ExamTypologyFormSupport(this.examTypologyService));
	}
	
	@InitBinder("examTypology")
	public void InitExamTypologyBinder(WebDataBinder binder){
		binder.setValidator(examTypologyValidator);
		binder.registerCustomEditor(Prerequisite.class, new PrerequisiteFormSupport(this.prerequisiteService));
	}
	
	@InitBinder("prerequisite")
	public void initPrerequisiteBinder(WebDataBinder binder) {
		binder.setValidator(prerequisiteValidator);
	}
	
	@InitBinder("resultIndicator")
	public void initResultIndicatorBinder(WebDataBinder binder) {
		binder.setValidator(resultIndicatorValidator);
	}
	
	@InitBinder("doctor")
	public void initDoctorBinder(WebDataBinder binder) {
		binder.setValidator(doctorValidator);
	}
	
	@InitBinder("result")
	public void initResultBinder(WebDataBinder binder) {
		binder.setValidator(resultValidator);
	}

	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/adminArea", method =	RequestMethod.GET)
	public String getAdminHome(){
		return "adminArea";
	}
	//exam
	@ModelAttribute("exam")
	public Exam createExam(){
		return new Exam();
	}
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/addExam", method = RequestMethod.GET)
	public String addExam(Model model,  HttpServletResponse response){
		model.addAttribute("examTypologiesList", this.examTypologyService.findAll());
		model.addAttribute("doctorsList", this.doctorService.findAll());
		model.addAttribute("patientsList", this.patientService.findAll());
		return "addExam";
	}
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/updateExam", method = RequestMethod.POST)
	public String updateExam(@ModelAttribute("exam") @Validated Exam exam,	BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("examTypologiesList", this.examTypologyService.findAll());
			model.addAttribute("doctorsList", this.doctorService.findAll());
			model.addAttribute("patientsList", this.patientService.findAll());
			return "addExam";
		}
		model.addAttribute("exam", this.examService.createExam(exam));
		model.addAttribute("examsList", this.examService.findAll());
		return "addedExam";
}
	//exam typology
	@ModelAttribute("examTypology")
	public ExamTypology createExamTypology(){
		return new ExamTypology();
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value ="/addExamTypology", method = RequestMethod.GET)
	public String addExamTypology(Model model){
		model.addAttribute("resultIndicatorsList", this.resultIndicatorService.findAll());
		model.addAttribute("prerequisitesList", this.prerequisiteService.findAll());
		return "addExamTypology";
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value ="/updateExamTypology", method = RequestMethod.POST)
	public String updateExamTypology(@ModelAttribute("examTypology") @Validated ExamTypology examTypology, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("resultIndicatorsList", this.resultIndicatorService.findAll());
			model.addAttribute("prerequisitesList", this.prerequisiteService.findAll());
			return "addExamTypology";
		}
		model.addAttribute("examTypology", this.examTypologyService.createExamTypology(examTypology.getName(), examTypology.getDescription(),examTypology.getPrice(), examTypology.getResultIndicators(), examTypology.getPrerequisites()));
		model.addAttribute("examTypologyList", this.examTypologyService.findAll());
		return "addedExamTypology";
	}
	
	//prerequisite
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/addPrerequisite", method = RequestMethod.GET)
	public String addPrerequisite(Model model,  HttpServletResponse response){
		return "addPrerequisite";
	}
	
	@ModelAttribute("prerequisite")
	public Prerequisite createPrerequisite(){
		return new Prerequisite();
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/updatePrerequisite", method = RequestMethod.POST)
	public String updatePrerequisite(@ModelAttribute("prerequisite") @Validated Prerequisite prerequisite,	BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			model.addAttribute("resultIndicatorsList", this.resultIndicatorService.findAll());
			model.addAttribute("prerequisitesList", this.prerequisiteService.findAll());
			model.addAttribute("prerequisiteError", "Prerequisite adding not completed.");
			return "addExamTypology";
		}
		model.addAttribute("prerequisite", this.prerequisiteService.createPrerequisite(prerequisite.getName(), prerequisite.getDescription()));
		model.addAttribute("prerequisitesList", this.prerequisiteService.findAll());
		return "addExamTypology";
}
	//resultIndicator
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/addResultIndicator", method = RequestMethod.GET)
	public String addResultIndicator(Model model,  HttpServletResponse response){
		return "addResultIndicator";
	}
	
	@ModelAttribute("resultIndicator")
	public ResultIndicator createResultIndicator(){
		return new ResultIndicator();
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/updateResultIndicator", method = RequestMethod.POST)
	public String updateResultIndicator(@ModelAttribute("resultIndicator") @Validated ResultIndicator resultIndicator,	BindingResult bindingResult, Model model){

		if(bindingResult.hasErrors()){
			model.addAttribute("prerequisitesList", this.prerequisiteService.findAll());
			model.addAttribute("resultIndicatorsList", this.resultIndicatorService.findAll());
			model.addAttribute("resultIndicatorError", "ResultIndicator adding not completed.");
			return "addExamTypology";
		}
		model.addAttribute("resultIndicator", this.resultIndicatorService.createResultIndicator(resultIndicator.getDescription()));
		model.addAttribute("prerequisitesList", this.prerequisiteService.findAll());
		model.addAttribute("resultIndicatorsList", this.resultIndicatorService.findAll());
		return "addExamTypology";
}
	
	//Exams by Doctor
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/examsByDoctor", method = RequestMethod.GET)
	public String examsByDoctor(Model model){
		return "examsByDoctor";
	}
	
	@ModelAttribute("doctor")
	public Doctor createDoctor(){
		return new Doctor();
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/getExamsByDoctor", method = RequestMethod.POST)
	public String getExamsByDoctor(@ModelAttribute("doctor") @Validated Doctor doctor, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors())
		return "adminArea";
		doctor = this.doctorService.findByCode(doctor.getCode());
		model.addAttribute("doctor", doctor);
		return "examsByDoctor";
	}
	
	//result
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/addResult", method = RequestMethod.GET)
	public String addResult(Model model,  HttpServletResponse response){
		this.result=new Result();
		this.resultRow = new ArrayList<ResultRow>();
		this.resultIndicatorList = new ArrayList<ResultIndicator>();
		this.resultIndicatorList = this.examTypologyService.findByCode(this.exam.getExamTypology().getCode()).getResultIndicators();
		Cookie cook = new Cookie("exm",this.exam.getExamTypology().getCode()+this.resultIndicatorList.get(0).getDescription());
		response.addCookie(cook);
		for(int i=0;i<this.resultIndicatorList.size();i++){
			System.out.println(this.resultIndicatorList.get(i));
			this.resultRow.add(new ResultRow(((long)i), this.result, this.resultIndicatorList.get(i)));
		}
		model.addAttribute("resultRowList", this.resultRow);
		return "addResult";
	}
	
	@ModelAttribute("result")
	public Result createResult(){
		return new Result();
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/updateResult", method = RequestMethod.POST)
	public String updateResult(@ModelAttribute("result") Result result, Model model){
		this.result.setExam(this.exam);

		for(int i = 0; i<this.resultRow.size();i++){
			
			this.resultRow.get(i).setValue(result.getResultsRows().get(i).getValue());
			this.resultRow.get(i).setResult(this.result);
			this.resultRow.get(i).setId(i);
		}
		this.result.setResultsRows(this.resultRow);
		this.exam.setResult(this.result);

		System.out.println(this.exam.getResult().getResultsRows().get(0).getValue()
				+this.exam.getDoctor().getName());
		this.resultService.createResult(this.result);
		this.examService.updateResult(this.exam);
		model.addAttribute("result" ,this.result);

		return "addedResult";
}
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value = "/newResult", method = RequestMethod.GET)
	public String newResult(Model model){
		this.examWOResult = new ArrayList<Exam>();
		this.examWOResult.addAll(this.examService.findExamsWOResult());
		model.addAttribute("examsWOResult", this.examWOResult);
		return "selectExam";
	}
	
	@PreAuthorize("hasAnyRole('admin')")
	@RequestMapping(value= "/selectExam", method = RequestMethod.POST)
	public void selectExam(@RequestParam("code") String code, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		this.exam = new Exam();
		this.exam = this.examService.findByCode(Long.parseLong(code));
		response.sendRedirect(request.getContextPath()+"/addResult");
	}
}
