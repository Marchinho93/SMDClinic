package smdclinic.repository;

import java.util.List;

import smdclinic.model.ExamTypology;
import smdclinic.model.Prerequisite;
import smdclinic.model.ResultIndicator;

public interface ExamTypologyDao {

	public ExamTypology createExamTypology(String name, String description, String price,
			List<ResultIndicator> resultIndicators, List<Prerequisite> prerequisites);

	public ExamTypology findByCode(long code);

	public List<ExamTypology> findAll();

}