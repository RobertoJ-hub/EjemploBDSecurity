package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
	
}
