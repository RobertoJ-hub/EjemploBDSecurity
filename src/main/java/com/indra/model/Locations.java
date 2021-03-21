package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Locations {
	
	@GeneratedValue(generator = "seLo")
	@SequenceGenerator(name="seLo", sequenceName = "LOCATIONS_SEQ", allocationSize = 1)
	@Id
	private Integer LOCATION_ID;
	
	private String STREET_ADDRESS;
	private String POSTAL_CODE;
	private String CITY;
	private String STATE_PROVINCE;
	private String COUNTRY_ID;
	
	public Integer getLOCATION_ID() {
		return LOCATION_ID;
	}
	public void setLOCATION_ID(Integer lOCATION_ID) {
		LOCATION_ID = lOCATION_ID;
	}
	public String getSTREET_ADDRESS() {
		return STREET_ADDRESS;
	}
	public void setSTREET_ADDRESS(String sTREET_ADDRESS) {
		STREET_ADDRESS = sTREET_ADDRESS;
	}
	public String getPOSTAL_CODE() {
		return POSTAL_CODE;
	}
	public void setPOSTAL_CODE(String pOSTAL_CODE) {
		POSTAL_CODE = pOSTAL_CODE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	public String getSTATE_PROVINCE() {
		return STATE_PROVINCE;
	}
	public void setSTATE_PROVINCE(String sTATE_PROVINCE) {
		STATE_PROVINCE = sTATE_PROVINCE;
	}
	public String getCOUNTRY_ID() {
		return COUNTRY_ID;
	}
	public void setCOUNTRY_ID(String cOUNTRY_ID) {
		COUNTRY_ID = cOUNTRY_ID;
	}
	@Override
	public String toString() {
		return "Locations [LOCATION_ID=" + LOCATION_ID + ", STREET_ADDRESS=" + STREET_ADDRESS + ", POSTAL_CODE="
				+ POSTAL_CODE + ", CITY=" + CITY + ", STATE_PROVINCE=" + STATE_PROVINCE + ", COUNTRY_ID=" + COUNTRY_ID
				+ "]";
	}
	
	
}
