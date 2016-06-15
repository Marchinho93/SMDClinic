package smdclinic.service;

import java.util.List;

import smdclinic.model.Prerequisite;

public interface PrerequisiteService {

	Prerequisite createPrerequisite(String name, String description);

	Prerequisite findByName(String name);

	List<Prerequisite> findAll();

	void removePrerequisite(Prerequisite prerequisite);

}