package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Countries;
import com.indra.model.Locations;
import com.indra.model.Regions;
import com.indra.repository.CountriesRepository;
import com.indra.repository.LocationsRepository;
import com.indra.repository.RegionsRepository;

@Service
public class CountriesServiceimp implements CountriesService {

	@Autowired
	private CountriesRepository repoC;
	@Autowired
	private RegionsRepository repoR;
	@Autowired
	private LocationsRepository repoL;
	
	@Override
	public void findAll() {
		System.out.println("Mostrando datos de la BD en la tabla COUNTRIES");
		Iterable<Countries> c = repoC.findAll();
		for(Countries co: c) {
			System.out.println(""+co.toString());
		}
	}

	@Override
	public void findById(String id) {
		Optional<Countries> c = repoC.findById(id);
		if(c.isPresent()) {
			System.out.println(""+c.toString());
		}else {
			System.out.println("El registro con ID: "+id+" no existe");
		}
	}

	@Override
	public void deletedById(String id) {
		Optional<Countries> c = repoC.findById(id);
		if(c.isPresent()) {
			repoC.deleteById(id);
			System.out.println("Registro eliminado con éxito");
		}
		else {
			System.out.println("No se puede eliminar el registro con ID: "+id+" ya que el registro no existe");
		}
	}

	@Override
	public void save(String COUNTRY_ID, String COUNTRY_NAME,int REGION_ID) {
		
		Optional<Countries> c = repoC.findById(COUNTRY_ID);
		
		Optional<Regions> r = repoR.findById(REGION_ID);
		
		if(c.isPresent()) { 
				System.out.println("No se puede guardar el registro con ID: "+COUNTRY_ID+" porque ya existe un registro con ese ID");
		}
		else {
			if(r.isPresent()){
				Countries co = new Countries();
				co.setCOUNTRY_ID(COUNTRY_ID);
				co.setCOUNTRY_NAME(COUNTRY_NAME);
				co.setREGION_ID(REGION_ID);
				repoC.save(co);
				System.out.println("Registro guardado con exito");
			}
			else {
				System.out.println("No se puede guardar el registro ya que no existe ningun ID: "+REGION_ID+" en la tabla REGIONS");
			}
		}
		
	}

	@Override
	public void update(String id, String COUNTRY_ID, String COUNTRY_NAME,Integer REGION_ID) {
		
		if(id != null) {	
			
			boolean comprobacion = false;
			
			Optional<Countries> c = repoC.findById(id);
			
			
			if(c.isPresent()) {
					Countries co = c.get();
					if(COUNTRY_ID != null) {
						co.setCOUNTRY_ID(COUNTRY_ID);
					}
					if(COUNTRY_NAME != null) {
						co.setCOUNTRY_NAME(COUNTRY_NAME);
					}
					if(REGION_ID != null) {
						Optional<Regions> r = repoR.findById(REGION_ID);
						if(r.isPresent()) {
							co.setREGION_ID(REGION_ID);
						}else {
							System.out.println("No existe el ID: "+REGION_ID+" en la tabla REGIONS por lo cual no se actualizara ese campo");
						}	
					}
					repoC.save(co);
					System.out.println("Registro actualizado con exito");
			}else {
				System.out.println("El registro con ID: "+id+" no existe");
			}
			
		}
		else {
			System.out.println("No se puede actualizar si es campo id es null");
		}
		
	}

}
