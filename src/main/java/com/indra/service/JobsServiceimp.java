package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Jobs;
import com.indra.repository.JobsRepository;

@Service
public class JobsServiceimp implements JobsService {

	@Autowired
	private JobsRepository repoJ;
	
	@Override
	public Iterable<Jobs> findAll() {
		System.out.println("Mostrando datos de la BD de la tabla JOBS");
		Iterable<Jobs> j = repoJ.findAll();
		for(Jobs jo: j) {
			System.out.println(""+jo.toString());
		}
		return j;
	}

	@Override
	public void findById(String id) {
		if(id != null) {
			Optional<Jobs> j = repoJ.findById(id);
			if(j.isPresent()) {
				System.out.println(""+j.toString());
			}
			else {
				System.out.println("El registro con id: "+id+" no existe");
			}
		}else {
			System.out.println("No se puede buscar un registro si el id es null");
		}
	}

	@Override
	public void deletedById(String id) {
		Optional<Jobs> j = repoJ.findById(id);
		if(j.isPresent()) {
			repoJ.deleteById(id);
			System.out.println("Registro eliminado exitosamente");
		}else {
			System.out.println("ERROR. No se puede eliminar el registro con ID: "+id+" porque no existe");
		}

	}

	@Override
	public void save(String JOB_ID, String JOB_TITLE, int MIN_SALARY, int MAX_SALARY) {
		if(JOB_ID != null) {
			Optional<Jobs> j = repoJ.findById(JOB_ID);
			if(j.isPresent()) {
				System.out.println("No se puede agregar un registro con ID: "+JOB_ID+" porque ya existe");
			}else {
				Jobs jo = new Jobs();
				jo.setJOB_ID(JOB_ID);
				jo.setJOB_TITLE(JOB_TITLE);
				jo.setMAX_SALARY(MAX_SALARY);
				jo.setMIN_SALARY(MIN_SALARY);
				repoJ.save(jo);
				System.out.println("Registro guardado exitosamente");
			}
		}else {
			System.out.println("El campo JOB_ID no puede ir como null");
		}
		
	}

	@Override
	public void update(String JOB_ID, String JOB_TITLE, Integer MIN_SALARY, Integer MAX_SALARY) {
		
		if(JOB_ID != null) {
			Optional<Jobs> j = repoJ.findById(JOB_ID);
			
			if(j.isPresent()) {
				Jobs jo = j.get();
				
				if(JOB_ID != null) {
					jo.setJOB_ID(JOB_ID);
				}
				if(JOB_TITLE != null) {
					jo.setJOB_TITLE(JOB_TITLE);
				}
				if(MIN_SALARY != null) {
					jo.setMIN_SALARY(MIN_SALARY);
				}
				if(MAX_SALARY != null) {
					jo.setMAX_SALARY(MAX_SALARY);
				}
				
				repoJ.save(jo);
				System.out.println("Registro actualizado exitosamente");
			}
			else {
				System.out.println("ERROR. No se puede actualizar el registro con ID: "+JOB_ID+" porque no existe");
			}

		}else {
			System.out.println("No se puede actualizar el registro si el campo JOB_ID es null");
		}
		
	}

}
