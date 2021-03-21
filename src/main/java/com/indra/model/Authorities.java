package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORITIES")
public class Authorities {
	
	@Id
	private String USERNAME;
	private String AUTHORITY;
	
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getAUTHORITY() {
		return AUTHORITY;
	}
	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}
	@Override
	public String toString() {
		return "Authorities [USERNAME=" + USERNAME + ", AUTHORITY=" + AUTHORITY + "]";
	}
	
	
}
