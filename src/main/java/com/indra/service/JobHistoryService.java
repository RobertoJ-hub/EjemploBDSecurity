package com.indra.service;

import java.util.Date;

import com.indra.model.JobHistoryEmbedded;

public interface JobHistoryService {
	public void findAll();
	public void findById(JobHistoryEmbedded id);
	public void save(JobHistoryEmbedded id, Date END_DATE, String JOB_ID, Integer DEPARTMENT_ID);
	public void deletedById(JobHistoryEmbedded id);
	
	public void update(JobHistoryEmbedded id, Date END_DATE, String JOB_ID, Integer DEPARTMENT_ID);
}
