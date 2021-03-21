package com.indra.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import com.indra.repository.EmployeesRepository2;
import com.indra.repository.JobHistoryRepository;
import com.indra.repository.JobsRepository;

@Service
public class EmployeesServiceimp implements EmployeesService {

	@Autowired
	private EmployeesRepository repoE;
	@Autowired
	private JobHistoryRepository repoJH;
	@Autowired
	private JobsRepository repoJ;
	@Autowired
	private DepartmentsRepository repoD;
	@Autowired
	private EmployeesRepository2 repoE2;
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
	
	@Override
	public Iterable<Employees> findAll() {
		//System.out.println("Mostrando datos de la BD de la tabla Employees");
		Iterable<Employees> iter3 = repoE.findAll();		
		return iter3;
	}

	
	@Override
	public Employees findById(Integer id) {
		System.out.println("Mostrando datos por ID: "+id);
		Employees empleado = new Employees();
		Optional<Employees> e = repoE.findById(id);
		
		if(e!=null)
			System.out.println(e.toString());
			empleado = e.get();
		if(e.isEmpty())
			System.out.println("Registro no encontrado en tabla Employees con id: "+id);
		return empleado;
	}

	@Override
	public Employees save(String FIRSTNAME,String LASTNAME,String EMAIL, String PHONE_NUMBER,Date HIREDATE,String JOB_ID,Double SALARY,Integer MANAGER_ID,Integer DEPARTMENT_ID) {
		Employees e = new Employees();
		if(EMAIL != null) {
			boolean comprobacion = false;
			boolean comprobacion2 = false;
			
			Iterable<Employees> empleados = repoE.findAll();
			
			for (Employees em: empleados) {
				if(em.getEMAIL().equals(EMAIL)) {
					comprobacion = true;
				}
			}
			if(comprobacion == true) {
				System.out.println("ERROR no se puede guardar el EMAIL porque otro registro de Employee ya lo tiene");
			}else {
				Optional<Jobs> j = repoJ.findById(JOB_ID);
				if(j.isPresent()) {	
						//Employees e = new Employees();
						Optional<Departments> d = repoD.findById(DEPARTMENT_ID);
						if(d.isPresent()) {
							
							Iterable<Departments> dep = repoD.findAll();
							for(Departments depa: dep) {
								if(depa.getMANAGER_ID() == (MANAGER_ID)) {
									//System.out.println(depa.getMANAGER_ID()+ " -> " +MANAGER_ID);
									comprobacion2 = true;
								}
							}
							if(comprobacion2 == true) {

								e.setFIRSTNAME(FIRSTNAME);
								e.setLASTNAME(LASTNAME);
								e.setEMAIL(EMAIL);
								e.setPHONE_NUMBER(PHONE_NUMBER);
								e.setHIRE_DATE(HIREDATE);
								e.setJOB_ID(JOB_ID);
								e.setSALARY(SALARY);
								e.setMANAGER_ID(MANAGER_ID);
								e.setDEPARTMENT_ID(DEPARTMENT_ID);
								repoE.save(e);
								System.out.println("Registro guardado con exito");
								
							}else {
								System.out.println("ERROR. El MANAGER_ID no existe en la tabla DEPARTMENTS");
							}
						}else {
							System.out.println("ERROR el DEPARTMENT_ID no existe en la tabla departments");
						}
				}else {
					System.out.println("Error, no se puede guardar ya que el JOB_ID ingresado no existe en la tabla JOBS");
				}
			}
			
		}else {
			System.out.println("Error, no puedes dejar el EMAIL como null");
		}
		
		return e;
	}

	@Override
	public void update(Integer id,String FIRSTNAME,String LASTNAME,String EMAIL, String PHONE_NUMBER,Date HIREDATE,String JOB_ID,Double SALARY,Integer MANAGER_ID,Integer DEPARTMENT_ID ) {
		Optional<Employees> e = repoE.findById(id);
		
		boolean comprobacion = false;
		
		if(e.isPresent()) {
			Employees emplo = e.get();
			Optional<JobHistory> jhi = repoJH.findById(new JobHistoryEmbedded(id,emplo.getHIRE_DATE())); 
			
			if(jhi.isPresent()) {
				repoJH.deleteById(new JobHistoryEmbedded(id,emplo.getHIRE_DATE()));
			}
			
			Employees em = e.get();
			if(FIRSTNAME != null) {
				em.setFIRSTNAME(FIRSTNAME);
			}
			if(LASTNAME != null) {
				em.setLASTNAME(LASTNAME);
			}
			if(EMAIL != null) {
				Iterable<Employees> empleados = repoE.findAll();
				for(Employees emp: empleados) {
					if(emp.getEMAIL().equals(EMAIL)) {
						System.out.println("No se puede actualizar el campo EMAIL porque ya se tiene registrado el EMAIL");
					}
					else {
						em.setEMAIL(EMAIL);
					}
				}
			}
			if(PHONE_NUMBER != null) {
				em.setPHONE_NUMBER(PHONE_NUMBER);
			}
			if(HIREDATE != null) {
				em.setHIRE_DATE(HIREDATE);
			}
			if(JOB_ID != null) {
				Optional<Jobs> j = repoJ.findById(JOB_ID);
				if(j.isPresent()) {
					em.setJOB_ID(JOB_ID);;
				}else {
					System.out.println("ERROR, No se puede actualizar el compo JOB_ID ya que el valor no existe en la tabla JOBS");
				}
			}
			if(SALARY != null) {
				em.setSALARY(SALARY);
			}
			if(MANAGER_ID != null) {
				Iterable<Departments> dtos = repoD.findAll();
				for(Departments dep: dtos) {
					if(dep.getMANAGER_ID().equals(MANAGER_ID)) {
						comprobacion = true;
					}
				}
				if(comprobacion == true) {
					em.setMANAGER_ID(MANAGER_ID);
				}else {
					System.out.println("Error, no se puede actualizar el campo MANAGER_ID ya que no existe en Departments");
				}
			}
			if(DEPARTMENT_ID !=null) {
				Optional<Departments> d = repoD.findById(DEPARTMENT_ID);
				if(d.isPresent()) {
					em.setDEPARTMENT_ID(DEPARTMENT_ID);
				}else {
					System.out.println("No se pudo actualizar el campo DEPARTMENT_ID ya que no existe en la tabla Departments");
				}
			}
			
			repoE.save(em);
			System.out.println("Registro actualizado con exito");
		}else {
			System.out.println("No existe el registro que se quiere editar");
		}
	}

	@Override
	public void deletedById(Integer id) {
		Optional<Employees> e = repoE.findById(id);
		
		if(e.isPresent()) {
			Employees emplo = e.get();
			Optional<JobHistory> jhi = repoJH.findById(new JobHistoryEmbedded(id,emplo.getHIRE_DATE())); 
			
			if(jhi.isPresent()) {
				repoJH.deleteById(new JobHistoryEmbedded(id,emplo.getHIRE_DATE()));
			}
				repoE.deleteById(id);
				System.out.println("Registro eliminado correctamente");
			
				
		}else {
			System.out.println("Error. El registro que intenta eliminar no existe");
		}
	}


	@Override
	public List<Employees> findByFIRSTNAMEAndLASTNAMEAndSALARY(String FIRSTNAME,String LASTNAME, Double SALARY) {
		List<Employees> e = repoE2.findByFIRSTNAMEAndLASTNAMEAndSALARY(FIRSTNAME,LASTNAME,SALARY);
		for(Employees emp: e) {
			System.out.println(""+emp.toString());
		}
		return e;
	}


	@Override
	public List<Employees> findBySALARYBetween(Double SALARY1, Double SALARY2) {
		List<Employees> e = repoE2.findBySALARYBetween(SALARY1, SALARY2);
		for(Employees emp: e) {
			System.out.println(""+emp.toString());
		}
		return null;
	}


	@Override
	public List<Employees> findByFIRSTNAMELikeAndSALARYBetween(String FIRSTNAME, Double SALARY1, Double SALARY2) {
		List<Employees> e = repoE2.findByFIRSTNAMELikeAndSALARYBetween(FIRSTNAME, SALARY1, SALARY2);
		for(Employees emp: e) {
			System.out.println(""+emp.toString());
		}
		return null;
	}


	@Override
	public List<Employees> findByEmailLike(String Email) {
		List<Employees> e = repoE2.findByEMAILLike(Email);
		for(Employees emp: e) {
			System.out.println(""+emp.toString());
		}
		return null;
	}


	@Override
	public void update(Integer id,Employees e) {
		Optional<Employees> em = repoE.findById(id);
		
		if(em.isPresent()) {
			Employees employee = em.get();
			Optional<JobHistory> jhi = repoJH.findById(new JobHistoryEmbedded(id,employee.getHIRE_DATE())); 
			
			if(jhi.isPresent()) {
				repoJH.deleteById(new JobHistoryEmbedded(id,employee.getHIRE_DATE()));
			}
			if(e.getFIRSTNAME() != null) {
				employee.setFIRSTNAME(e.getFIRSTNAME());
			}
			if(e.getLASTNAME() != null) {
				employee.setLASTNAME(e.getLASTNAME());
			}
			if(e.getEMAIL() != null) {
				employee.setEMAIL(e.getEMAIL());
			}
			if(e.getPHONE_NUMBER() != null) {
				employee.setPHONE_NUMBER(e.getPHONE_NUMBER());
			}
			if(e.getHIRE_DATE() != null) {
				employee.setHIRE_DATE(e.getHIRE_DATE());
			}
			if(e.getJOB_ID() != null) {
				employee.setJOB_ID(e.getJOB_ID());
			}
			if(e.getSALARY() != null) {
				employee.setSALARY(e.getSALARY());
			}
			if(e.getMANAGER_ID() != null) {
				employee.setMANAGER_ID(e.getMANAGER_ID());
			}
			if(e.getDEPARTMENT_ID() != null) {
				employee.setDEPARTMENT_ID(e.getDEPARTMENT_ID());
			}
			repoE.save(employee);
		}
	}

}
