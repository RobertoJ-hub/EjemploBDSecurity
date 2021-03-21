package com.indra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.indra.model.Employees;

public interface EmployeesRepository2 extends Repository<Employees, Integer> {
	List<Employees> findByFIRSTNAMEAndLASTNAMEAndSALARY(String fIRSTNAME,String lASTNAME,Double SALARY);
	List<Employees> findBySALARYBetween(Double SALARY1, Double SALARY2);
	List<Employees> findByFIRSTNAMELikeAndSALARYBetween(String FIRSTNAME,Double SALARY1, Double SALARY2);
	
	@Query(value="SELECT * FROM Employees WHERE EMAIL like ?", nativeQuery = true)
	List<Employees> findByEMAILLike(String EMAIL);
	
}
