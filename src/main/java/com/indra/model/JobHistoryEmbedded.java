package com.indra.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class JobHistoryEmbedded implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer EMPLOYEE_ID;
	private Date START_DATE;
	
	public JobHistoryEmbedded() {
		
	}

	public JobHistoryEmbedded(Integer eMPLOYEE_ID, Date sTART_DATE) {
		super();
		EMPLOYEE_ID = eMPLOYEE_ID;
		START_DATE = sTART_DATE;
	}

	public Integer getEMPLOYEE_ID() {
		return EMPLOYEE_ID;
	}

	public void setEMPLOYEE_ID(Integer eMPLOYEE_ID) {
		EMPLOYEE_ID = eMPLOYEE_ID;
	}

	public Date getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JobHistoryEmbedded [EMPLOYEE_ID=" + EMPLOYEE_ID + ", START_DATE=" + START_DATE + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(EMPLOYEE_ID, START_DATE);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof JobHistoryEmbedded)) {
			return false;
		}
		JobHistoryEmbedded other = (JobHistoryEmbedded) obj;
		return Objects.equals(EMPLOYEE_ID, other.EMPLOYEE_ID) && Objects.equals(START_DATE, other.START_DATE);
	}

	
	
}
