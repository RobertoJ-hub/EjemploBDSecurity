package com.indra.service;

import com.indra.model.Departments;

public interface DepartmentsService {
	public Iterable<Departments> findAll();
	public void findById(Integer id);
	public void deletedById(Integer id);
	public void save(String DEPARTMENT_NAME, Integer MANAGER_ID, Integer LOCATION_ID);
	public void update(Integer id, String DEPARTMENT_NAME,Integer MANAGER_ID, Integer LOCATION_ID);
}
