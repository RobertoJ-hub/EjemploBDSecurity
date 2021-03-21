package com.indra.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory {
	@EmbeddedId
	private JobHistoryEmbedded id;
	
	private Date END_DATE;
	private String JOB_ID;
	private Integer DEPARTMENT_ID;
	
	public JobHistoryEmbedded getId() {
		return id;
	}
	public void setId(JobHistoryEmbedded id) {
		this.id = id;
	}
	public Date getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
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
	public void setDEPARTMENT_ID(Integer dEPARTAMENT_ID) {
		DEPARTMENT_ID = dEPARTAMENT_ID;
	}
	@Override
	public String toString() {
		return "JobHistory [id=" + id + ", END_DATE=" + END_DATE + ", JOB_ID=" + JOB_ID + ", DEPARTMENT_ID="
				+ DEPARTMENT_ID + "]";
	}
	
}
