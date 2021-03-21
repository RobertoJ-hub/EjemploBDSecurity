package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Jobs {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String JOB_ID;
	private String JOB_TITLE;
	private Integer MIN_SALARY;
	private Integer MAX_SALARY;
	public String getJOB_ID() {
		return JOB_ID;
	}
	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}
	public String getJOB_TITLE() {
		return JOB_TITLE;
	}
	public void setJOB_TITLE(String jOB_TITLE) {
		JOB_TITLE = jOB_TITLE;
	}
	public Integer getMIN_SALARY() {
		return MIN_SALARY;
	}
	public void setMIN_SALARY(Integer mIN_SALARY) {
		MIN_SALARY = mIN_SALARY;
	}
	public Integer getMAX_SALARY() {
		return MAX_SALARY;
	}
	public void setMAX_SALARY(Integer mAX_SALARY) {
		MAX_SALARY = mAX_SALARY;
	}
	@Override
	public String toString() {
		return "Jobs [JOB_ID=" + JOB_ID + ", JOB_TITLE=" + JOB_TITLE + ", MIN_SALARY=" + MIN_SALARY + ", MAX_SALARY="
				+ MAX_SALARY + "]";
	}
	
	
}
