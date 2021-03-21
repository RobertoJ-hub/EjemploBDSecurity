package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	private String USERNAME;
	private String PASSWORD;
	private Integer ENABLED;
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Integer getENABLED() {
		return ENABLED;
	}
	public void setENABLED(Integer eNABLED) {
		ENABLED = eNABLED;
	}
	@Override
	public String toString() {
		return "Users [USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", ENABLED=" + ENABLED + "]";
	}
	
}
