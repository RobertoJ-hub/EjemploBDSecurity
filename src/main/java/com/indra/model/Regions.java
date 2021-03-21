package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Regions {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int REGION_ID;
	private String REGION_NAME;
	
	public int getREGION_ID() {
		return REGION_ID;
	}
	public void setREGION_ID(int rEGION_ID) {
		REGION_ID = rEGION_ID;
	}
	public String getREGION_NAME() {
		return REGION_NAME;
	}
	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}
	@Override
	public String toString() {
		return "Regions [REGION_ID=" + REGION_ID + ", REGION_NAME=" + REGION_NAME + "]";
	}
	
}
