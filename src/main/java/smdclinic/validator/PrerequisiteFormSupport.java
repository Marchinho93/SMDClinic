package smdclinic.validator;

import java.beans.PropertyEditorSupport;

import smdclinic.model.Prerequisite;
import smdclinic.service.PrerequisiteService;

public class PrerequisiteFormSupport extends PropertyEditorSupport {
	
	 private PrerequisiteService prerequisiteService;
	 
	 	

	 public PrerequisiteFormSupport(PrerequisiteService prerequisiteService) {
		this.prerequisiteService = prerequisiteService;
	 }
	 
	 @Override
	 public void setAsText(String text) throws IllegalArgumentException {
		 Prerequisite prerequisite = null;
		 try{
			 prerequisite = this.prerequisiteService.findByName(text);
		 }catch (NullPointerException ex){
			 throw new NullPointerException("Fail Fetching From DB");
		 }
		 setValue(prerequisite);
	 }
}
