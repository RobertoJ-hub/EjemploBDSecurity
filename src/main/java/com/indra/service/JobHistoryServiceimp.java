package com.indra.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Departments;
import com.indra.model.Employees;
import com.indra.model.JobHistory;
import com.indra.model.JobHistoryEmbedded;
import com.indra.model.Jobs;
import com.indra.repository.DepartmentsRepository;
import com.indra.repository.EmployeesRepository;
import com.indra.repository.JobHistoryRepository;
import com.indra.repository.JobsRepository;

@Service
public class JobHistoryServiceimp implements JobHistoryService {

	@Autowired
	private JobHistoryRepository repoJH;
	@Autowired
	private EmployeesRepository repoE;
	@Autowired
	private JobsRepository repoJ;
	@Autowired
	private DepartmentsRepository repoD;
	
	@Override
	public void findAll() {
		System.out.println("Mostrando datos de la BD");
		Iterable<JobHistory> jh = repoJH.findAll();
		for(JobHistory jhi: jh) {
			System.out.println(""+jhi.toString());
		}
	}

	@Override
	public void findById(JobHistoryEmbedded id) {
		
		Optional<JobHistory> jh = repoJH.findById(id);
		if(jh.isPresent()) {
			System.out.println(""+jh.toString());
		}else {
			System.out.println("No hay ningun registro con ID: "+id);
		}
	}

	@Override
	public void deletedById(JobHistoryEmbedded id) {
		
		Optional<JobHistory> jh = repoJH.findById(id);
		
		if(jh.isPresent()) {
			repoJH.deleteById(id);
			System.out.println("Registro eliminado correctamente");
		}
		else {
			System.out.println("ERROR, el registro no se puede eliminar porque no existe");
		}
		
	}

	@Override
	public void save(JobHistoryEmbedded id, Date END_DATE, String JOB_ID, Integer DEPARTMENT_ID) {
		
		Optional<JobHistory> jh = repoJH.findById(id);
		Optional<Jobs> j = repoJ.findById(JOB_ID);
		Optional<Departments> d = repoD.findById(DEPARTMENT_ID);
		
		if(jh.isPresent()) {
			System.out.println("No se puede ingresar un registro con ID: "+id+" porque ya existe");
		}else {
			if(j.isPresent()) {
				if(d.isPresent()) {
					JobHistory jhi = new JobHistory();
					jhi.setId(id);
					jhi.setEND_DATE(END_DATE);
					jhi.setJOB_ID(JOB_ID);
					jhi.setDEPARTMENT_ID(DEPARTMENT_ID);
					repoJH.save(jhi);
					System.out.println("Registro guardado con exito");
				}else {
					System.out.println("No se puede registrar el campo DEPARTMENT_ID"+id+" porque no existe en la tabla Departments");
				}
			}
			else {
				System.out.println("No se puede ingresar el campo JOB_ID: "+JOB_ID+" ya que no existe en la tabla Jobs");
			}
		}
	}
	
	@Override
	public void update(JobHistoryEmbedded id, Date END_DATE, String JOB_ID, Integer DEPARTMENT_ID) {
		Optional<JobHistory> j = repoJH.findById(id);
		Optional<Jobs> jo = repoJ.findById(JOB_ID);
		Optional<Departments> d = repoD.findById(DEPARTMENT_ID);
		if(j.isPresent()) {
			JobHistory  jhistory= j.get();
			if(JOB_ID != null) {
				if(jo.isPresent()) {
					jhistory.setJOB_ID(JOB_ID);
				}else {
					System.out.println("No se puede actualizar el campo Job_ID: "+JOB_ID+" ya que no existe en la tabla Jobs");
				}
			}
			if(DEPARTMENT_ID != null) {
				if(d.isPresent()) {
					jhistory.setDEPARTMENT_ID(DEPARTMENT_ID);
				}else {
					System.out.println("No se pudo actualizar el campo DEPARTMENT_ID: "+DEPARTMENT_ID+" ya que no existe en la tabla DEPARTMENTS");
				}
			}
			if(END_DATE != null) {
				jhistory.setEND_DATE(END_DATE);
			}
			repoJH.save(jhistory);
			System.out.println("El registro ha sido actualizado con exito");
		}else {
			System.out.println("El registro no se puede actualizar ya que el ID: "+id+" No existe");
		}

	}


}
