package smdclinic.repository;

import java.util.List;

import smdclinic.model.Exam;
import smdclinic.model.Result;

public interface ResultDao {

	public Result createResult(Exam exam);
	
	public Result createResult(Result result);

	public Result findByCode(long code);

	public List<Result> findAll();

	public void removeResult(Result result);

}