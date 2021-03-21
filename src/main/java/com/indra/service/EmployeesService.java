package com.indra.service;

import java.util.Date;
import java.util.List;

import com.indra.model.Employees;

public interface EmployeesService {
	
	public Iterable<Employees> findAll();
	public Employees findById(Integer id);
	public void deletedById(Integer id);
	public Employees save(String FIRSTNAME,String LASTNAME,String EMAIL, String PHONE_NUMBER,Date HIREDATE,String JOB_ID,Double SALARY,Integer MANAGER_ID,Integer DEPARTMENT_ID);
	public void update(Integer id,Employees e);
	public void update(Integer id,String FIRSTNAME,String LASTNAME,String EMAIL, String PHONE_NUMBER,Date HIREDATE,String JOB_ID,Double SALARY,Integer MANAGER_ID,Integer DEPARTMENT_ID );
	
	
	public List<Employees> findByFIRSTNAMEAndLASTNAMEAndSALARY(String FIRSTNAME, String LASTNAME,Double SALARY);
	public List<Employees> findBySALARYBetween(Double SALARY1, Double SALARY2);
	public List<Employees> findByFIRSTNAMELikeAndSALARYBetween(String FIRSTNAME, Double SALARY1, Double SALARY2);
	public List<Employees> findByEmailLike(String Email);
}
