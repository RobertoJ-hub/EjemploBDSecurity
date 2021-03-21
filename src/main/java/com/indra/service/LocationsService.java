package com.indra.service;

public interface LocationsService {
	public void findAll();
	public void findById(Integer id);
	public void deletedById(Integer id);
	public void save(String STREET_ADDRESS,String POSTAL_CODE, String CITY, String STATE_PROVINCE, String COUNTRY_ID);
	
	public void update(Integer id, String STREET_ADDRESS,String POSTAL_CODE, String CITY, String STATE_PROVINCE, String COUNTRY_ID);
	
}
