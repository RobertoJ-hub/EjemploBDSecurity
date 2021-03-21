package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRIES")
public class Countries {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name="Secuencia", sequenceName="",allocationSize=1)
	private String COUNTRY_ID;
	private String COUNTRY_NAME;
	private int REGION_ID;
	
	public String getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(String cOUNTRY_ID) {
		COUNTRY_ID = cOUNTRY_ID;
	}
	public String getCOUNTRY_NAME() {
		return COUNTRY_NAME;
	}
	public void setCOUNTRY_NAME(String cOUNTRY_NAME) {
		COUNTRY_NAME = cOUNTRY_NAME;
	}
	public int getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	@Override
	public String toString() {
		return "Countries [COUNTRY_ID=" + COUNTRY_ID + ", COUNTRY_NAME=" + COUNTRY_NAME + ", REGION_ID=" + REGION_ID
				+ "]";
	}
	
	
}
