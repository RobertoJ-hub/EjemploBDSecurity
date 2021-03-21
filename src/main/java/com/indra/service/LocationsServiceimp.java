package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Countries;
import com.indra.model.Departments;
import com.indra.model.Locations;
import com.indra.repository.CountriesRepository;
import com.indra.repository.DepartmentsRepository;
import com.indra.repository.LocationsRepository;

@Service
public class LocationsServiceimp implements LocationsService {

	@Autowired
	private LocationsRepository repoL;
	@Autowired
	private DepartmentsRepository repoD;
	@Autowired
	private CountriesRepository repoC;
	
	@Override
	public void findAll() {
		System.out.println("Mostrando los datos de l BD en la tabla LOCATIONS");
		Iterable<Locations> l = repoL.findAll();
		for(Locations lo: l) {
			System.out.println(""+lo.toString());
		}

	}

	@Override
	public void findById(Integer id) {
		
		if(id != null) {
			Optional<Locations> l = repoL.findById(id);
			if(l.isPresent()) {
				System.out.println(""+l.toString());
			}else {
				System.out.println("El registro con ID: "+id+" no existe");
			}
		}else {
			System.out.println("No se puede encontrar el registro si el compo es null");
		}
		
	}

	@Override
	public void deletedById(Integer id) {
		if(id != null) {
			Optional<Locations> l = repoL.findById(id);
			Iterable<Departments>  d= repoD.findAll();
			boolean verificar = false;
			
			if(l.isPresent()) {
				for(Departments de: d) {
					if(de.getLOCATION_ID() == id) {
						verificar = true;
					}
				}
				if(verificar == true) {
					System.out.println("No se puede eliminar el registro con ID: "+id+" ya que otro registro de la tabla DEPARTMENTS depende de el");
				}else {
					repoL.deleteById(id);
					System.out.println("Registro eliminado con exito");
				}
			}else {
				System.out.println("El registro con ID: "+id+" no existe");
			}
		}else {
			System.out.println("No se puede eliminar el registro si el ID es null");
		}
	}

	@Override
	public void save(String STREET_ADDRESS,String POSTAL_CODE, String CITY, String STATE_PROVINCE, String COUNTRY_ID) {
		if(CITY != null && COUNTRY_ID !=null) {
			
			Optional<Countries> c = repoC.findById(COUNTRY_ID);
			if(c.isPresent()) {
				Locations lo = new Locations();
				//lo.setLOCATION_ID(LOCATION_ID);
				lo.setSTREET_ADDRESS(STREET_ADDRESS);
				lo.setPOSTAL_CODE(POSTAL_CODE);
				lo.setCITY(CITY);
				lo.setSTATE_PROVINCE(STATE_PROVINCE);
				lo.setCOUNTRY_ID(COUNTRY_ID);
					
				repoL.save(lo);
				System.out.println("Registro creado exitosamente");
			}
			else {
				System.out.println("No se puede crear el registro con COUNTRY_ID: "+COUNTRY_ID+" porque el COUNTRY_ID no existe dentro de la tabla COUNTRIES");
			}
		}
		
		else {
			System.out.println("ERROR, se pueden guardar los datos si LOCATION_ID , CITY o COUNTRY_ID son null");
		}
		

	}

	@Override
	public void update(Integer id, String STREET_ADDRESS,String POSTAL_CODE, String CITY, String STATE_PROVINCE, String COUNTRY_ID) {
		if(id != null) {
			Optional<Locations> l = repoL.findById(id);
			Optional<Countries> c = repoC.findById(COUNTRY_ID);
			
			if(l.isPresent()) {
				Locations lo = l.get();
				if(STREET_ADDRESS != null) {
					lo.setSTREET_ADDRESS(STREET_ADDRESS);
				}
				if(POSTAL_CODE != null) {
					lo.setPOSTAL_CODE(POSTAL_CODE);
				}
				if(CITY != null) {
					lo.setCITY(CITY);
				}
				if(STATE_PROVINCE != null) {
					lo.setSTATE_PROVINCE(STATE_PROVINCE);
				}
				if(COUNTRY_ID != null) {
					if(c.isPresent()) {
						lo.setCOUNTRY_ID(COUNTRY_ID);
					}
					else {
						System.out.println("Error. EL COUNTRY_ID "+COUNTRY_ID+" no existe en la tabla COUNTRIES y por eso no será actualizado");
					}
				}
				repoL.save(lo);
				System.out.println("Registro actualizado con exito");
			}else {
				System.out.println("No existe registro con id: "+id);
			}
		}else {
			System.out.println("Error. No se puede actualizar un dato si el campo id es null");
		}

	}

}
