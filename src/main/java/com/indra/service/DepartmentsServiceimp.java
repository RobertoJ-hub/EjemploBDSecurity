package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Departments;
import com.indra.model.Employees;
import com.indra.model.Locations;
import com.indra.repository.DepartmentsRepository;
import com.indra.repository.EmployeesRepository;
import com.indra.repository.LocationsRepository;

@Service
public class DepartmentsServiceimp implements DepartmentsService {

	@Autowired
	private DepartmentsRepository repoD;
	@Autowired
	private LocationsRepository repoL;
	@Autowired
	private EmployeesRepository repoE;
	
	@Override
	public Iterable<Departments> findAll() {
		System.out.println("Mostrando datos de la BD de la tabla DEPARTMENTS");
		Iterable<Departments> d = repoD.findAll();
		for(Departments de: d) {
			System.out.println(""+de.toString());
		}
		return d;
	}

	@Override
	public void findById(Integer id) {
		Optional<Departments> d = repoD.findById(id);
		if(d.isPresent()) {
			System.out.println(""+d.toString());
		}
		else {
			System.out.println("El registro con ID: "+id+" no existe");
		}
	}

	@Override
	public void deletedById(Integer id) {
		Optional<Departments> d = repoD.findById(id);
		if(d.isPresent()) {
			repoD.deleteById(id);
			System.out.println("Registro eliminado exitosamente");
		}else {
			System.out.println("No se puede eliminar el registro con ID: "+id+" ya que el registro no existe");
		}
	}

	@Override
	public void save(String DEPARTMENT_NAME, Integer MANAGER_ID, Integer LOCATION_ID) {
		
		if(LOCATION_ID != null) {
			
			Optional<Locations> l = repoL.findById(LOCATION_ID);
			Iterable<Employees> e = repoE.findAll();
			
			boolean comprobacion = false;
			
			if(l.isPresent()) {
				
				for(Employees em: e) {
					if(em.getMANAGER_ID() == MANAGER_ID) {
						comprobacion = true;
					}
				}
				
				if(comprobacion == true) {
					
					Departments d = new Departments();
					
					d.setDEPARTMENT_NAME(DEPARTMENT_NAME);
					d.setMANAGER_ID(MANAGER_ID);
					d.setLOCATION_ID(LOCATION_ID);
					
					repoD.save(d);
					System.out.println("Registro guardado con exito");
				
				}else {
					System.out.println("No se puede guardar el registro ya que valor del campo MANAGER_ID:"+MANAGER_ID+" no se encuentra en la tabla EMPLOYEES");
				}
				
				
			}else {
				System.out.println("No se puede agregar el registro ya que el ID: "+LOCATION_ID+" no se encuentra registrado en la tabla LOCATIONS");
			}
		}else {
			System.out.println("ERROR, el campo LOCATION_ID no puede ser de tipo null");
		}
		
		
	}

	@Override
	public void update(Integer id,String DEPARTMENT_NAME,Integer MANAGER_ID, Integer LOCATION_ID) {
		if(id != null) {
			Optional<Departments> d = repoD.findById(id);
			Iterable<Employees> e = repoE.findAll();
			boolean comprobacion = false;
			Optional<Locations> l = repoL.findById(LOCATION_ID);
			if(d.isPresent()) {
				Departments de = d.get();
				if(DEPARTMENT_NAME != null) {
					de.setDEPARTMENT_NAME(DEPARTMENT_NAME);
				}
				if(MANAGER_ID != null) {
					for(Employees em: e) {
						if(em.getMANAGER_ID() == MANAGER_ID) {
							comprobacion = true;
						}
					}
					if(comprobacion == true) {
						de.setMANAGER_ID(MANAGER_ID);
					}
					else {
						System.out.println("No se puede actualizar el campo Manager_ID: "+MANAGER_ID+" ya que no existe en la tabla EMPLOYEES");
					}
				}
				if(l.isPresent()) {
					de.setLOCATION_ID(LOCATION_ID);
				}
				else {
					System.out.println("No se puede actualizar el campo LOCATION_ID: "+LOCATION_ID+" ya que no existe en la tabla Locations");
				}
				
				repoD.save(de);
				System.out.println("Registro actualizado con exito");
			}else {
				System.out.println("No existe ningun registro con ID: "+id);
			}
		}else {
			System.out.println("No se puede actualizar los registros si el id es null");
		}
	}

}
