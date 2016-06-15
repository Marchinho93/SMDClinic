package smdclinic.repository;

import java.util.List;

import smdclinic.model.Result;
import smdclinic.model.ResultIndicator;
import smdclinic.model.ResultRow;

public interface ResultRowDao {

	public ResultRow createResultRow(long id, String value, ResultIndicator resultIndicator, Result result);

	public ResultRow findByCode(long code);

	public List<ResultRow> findAll();

	public void removeResultRow(ResultRow resultRow);

}