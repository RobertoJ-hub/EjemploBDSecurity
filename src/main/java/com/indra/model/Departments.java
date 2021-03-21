package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Departments {
	
	@GeneratedValue(generator = "sede")
	@SequenceGenerator(name="sede", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 1)
	
	@Id
	private Integer DEPARTMENT_ID;
	private String DEPARTMENT_NAME;
	private Integer MANAGER_ID;
	private Integer LOCATION_ID;
	
	public Integer getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(Integer dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	public Integer getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(Integer mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	public Integer getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(Integer lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}
	@Override
	public String toString() {
		return "Departments [DEPARTAMENT_ID=" + DEPARTMENT_ID + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME
				+ ", MANAGER_ID=" + MANAGER_ID + ", LOCATION_ID=" + LOCATION_ID + "]";
	}
	
}
