package com.indra.service;

public interface CountriesService {
	public void findAll();
	public void findById(String id);
	public void deletedById(String id);
	public void save(String COUNTRY_ID, String COUNTRY_NAME,int REGION_ID);
	
	
	public void update(String id, String COUNTRY_ID, String COUNTRY_NAME,Integer REGION_ID);
	
}
