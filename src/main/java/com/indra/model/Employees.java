package com.indra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name="EMPLOYEES")
public class Employees {
	
	@GeneratedValue(generator = "se")
	@SequenceGenerator(name="se", sequenceName = "EMPLOYEES_SEQ", allocationSize = 1)
	@Id
	private Integer EMPLOYEE_ID;
	
	@Column(name="FIRST_NAME")
	private String FIRSTNAME;
	
	@Column(name="LAST_NAME")
	private String LASTNAME;
	
	private String EMAIL;
	private String PHONE_NUMBER;
	@Temporal(TemporalType.DATE)
	private Date HIRE_DATE;
	@ManyToOne 
	@JoinColumn( name = "JOB_ID", nullable = false, updatable = false, insertable = false)
	private Jobs job;
	private String JOB_ID;
	private Double SALARY;
	private Double COMMISSION_PCT;
	private Integer MANAGER_ID;
	@ManyToOne
	@JoinColumn( name = "DEPARTMENT_ID", nullable = false, updatable = false, insertable = false)
	private Departments departments;
	private Integer DEPARTMENT_ID;
	
	
	
	public Employees() {
		
	}
	public Employees(Integer eMPLOYEE_ID, String fIRSTNAME, String lASTNAME, String eMAIL, String pHONE_NUMBER,
			Date hIRE_DATE, Jobs job, String jOB_ID, Double sALARY, Integer mANAGER_ID,
			Departments departments, Integer dEPARTMENT_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
		FIRSTNAME = fIRSTNAME;
		LASTNAME = lASTNAME;
		EMAIL = eMAIL;
		PHONE_NUMBER = pHONE_NUMBER;
		HIRE_DATE = hIRE_DATE;
		this.job = job;
		JOB_ID = jOB_ID;
		SALARY = sALARY;
		MANAGER_ID = mANAGER_ID;
		this.departments = departments;
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}

	public Integer getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(Integer dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public Integer getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}
	public void setEMPLOYEE_ID(Integer eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}
	public String getFIRSTNAME() {
		return FIRSTNAME;
	}
	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}
	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}
	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}
	public Date getHIRE_DATE() {
		return HIRE_DATE;
	}
	public void setHIRE_DATE(Date hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}
	
	public Jobs getJob() {
		return job;
	}
	public void setJob(Jobs job) {
		this.job = job;
	}
	/*public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}*/
	public Double getSALARY() {
		return SALARY;
	}
	public void setSALARY(Double sALARY) {
		SALARY = sALARY;
	}
	public Double getCOMMISSION_PCT() {
		return COMMISSION_PCT;
	}
	public void setCOMMISSION_PCT(Double cOMISSION_PCT) {
		COMMISSION_PCT = cOMISSION_PCT;
	}
	public Integer getMANAGER_ID() {
		return MANAGER_ID;
	}
	public void setMANAGER_ID(Integer mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}
	
	
	//public Integer getDEPARTMENT_ID() {
	//	return DEPARTMENT_ID;
	//}
	//public void setDEPARTMENT_ID(Integer dEPARTAMENT_ID) {
	//	DEPARTMENT_ID = dEPARTAMENT_ID;
	//}
	
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	
	@Override
	public String toString() {
		return "Employees [EMPLOYEE_ID=" + EMPLOYEE_ID + ", FIRSTNAME=" + FIRSTNAME + ", LASTNAME=" + LASTNAME
				+ ", EMAIL=" + EMAIL + ", PHONE_NUMBER=" + PHONE_NUMBER + ", HIRE_DATE=" + HIRE_DATE + ", job=" + job
				+ ", SALARY=" + SALARY + ", COMMISSION_PCT=" + COMMISSION_PCT + ", MANAGER_ID=" + MANAGER_ID
				+ ", departments=" + departments + "]";
	}
	
	/*@Override
	public String toString() {
		return "Employees [EMPLOYEE_ID=" + EMPLOYEE_ID + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ ", EMAIL=" + EMAIL + ", PHONE_NUMBER=" + PHONE_NUMBER + ", HIRE_DATE=" + HIRE_DATE + ", JOB_ID="
				+ JOB_ID + ", SALARY=" + SALARY + ", COMMISSION_PCT=" + COMMISSION_PCT + ", MANAGER_ID=" + MANAGER_ID
				+ ", DEPARTMENT_ID=" + DEPARTMENT_ID + "]";
	}*/
	
	
}
