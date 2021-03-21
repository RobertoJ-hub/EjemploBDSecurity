package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Regions;
import com.indra.repository.RegionsRepository;

@Service
public class RegionsServiceimp implements RegionsService {

	@Autowired
	private RegionsRepository repoR;
	
	@Override
	public void findAll() {
		System.out.println("Mostrando los datos de la BD de la tabla REGIONS");
		Iterable<Regions> r = repoR.findAll();
		for(Regions re: r) {
			System.out.println(""+re.toString());
		}
	}

	@Override
	public void findById(Integer id) {
		Optional<Regions> r = repoR.findById(id);
		if(r.isPresent()) {
			System.out.println(""+r.toString());
		}else {
			System.out.println("El registro con id: "+id+" no existe");
		}
	}

	@Override
	public void deletedById(Integer id) {
		Optional<Regions> r = repoR.findById(id);
		if(r.isPresent()) {
			repoR.deleteById(id);
			System.out.println("Registro eliminado con exito");
		}else {
			System.out.println("No se puede eliminar el registro con ID: "+id+" porque no existe");
		}
	}

	@Override
	public void save(Integer REGION_ID, String REGION_NAME) {
		Optional<Regions> r = repoR.findById(REGION_ID);
		
		if(REGION_ID != null) {
			
			if(r.isPresent()) {
				System.out.println("Error. No se puede agregar el registro ya que el id: "+REGION_ID+" ya existe");
			}else {
				Regions re = new Regions();
				re.setREGION_ID(REGION_ID);
				re.setREGION_NAME(REGION_NAME);
				repoR.save(re);
				System.out.println("Registro agregado exitosamente");
			}
		}
		else {
			System.out.println("No se puede guardar el registro ya que REGION_ID no puede estar vacio");
		}

	}

	@Override
	public void update(int id,String NAME_REGION) {
		Optional<Regions> r = repoR.findById(id);
		
		if(r.isPresent()) {
			
			Regions re = r.get();
			
			if(NAME_REGION != null) {
				re.setREGION_NAME(NAME_REGION);
			}
			
			repoR.save(re);
			System.out.println("Registro actualizado exitosamente");
		}
		else {
			System.out.println("No se puede actualizar ya que el ID: "+id+" no existe");
		}
	}

}
