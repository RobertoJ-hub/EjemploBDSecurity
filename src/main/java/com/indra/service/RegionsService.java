package com.indra.service;

public interface RegionsService {
	public void findAll();
	public void findById(Integer id);
	public void deletedById(Integer id);
	public void save(Integer REGION_ID, String REGION_NAME);
	public void update(int id,String REGION_NAME);
}
