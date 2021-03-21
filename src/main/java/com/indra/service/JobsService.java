package com.indra.service;

import com.indra.model.Jobs;

public interface JobsService {
	public Iterable<Jobs> findAll();
	public void findById(String id);
	public void deletedById(String id);
	public void save(String JOB_ID, String JOB_TITLE, int MIN_SALARY, int MAX_SALARY);
	public void update(String JOB_ID, String JOB_TITLE, Integer MIN_SALARY, Integer MAX_SALARY);
}