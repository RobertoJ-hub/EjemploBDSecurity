package com.indra.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.model.Employees;
import com.indra.model.Usuarios;
import com.indra.repository.EmployeesRepository;
import com.indra.service.CountriesService;
import com.indra.service.DepartmentsService;
import com.indra.service.EmployeesService;
import com.indra.service.JobHistoryService;
import com.indra.service.JobsService;
import com.indra.service.LocationsService;
import com.indra.service.RegionsService;
import com.indra.service.RolesService;
import com.indra.service.UsuariosService;

@Controller
public class EjemploBDSecurityApplicationController {
	@Autowired
	private EmployeesService eS;
	@Autowired
	private CountriesService cS;
	@Autowired
	private DepartmentsService dS; 
	@Autowired
	private JobHistoryService jhS;
	@Autowired
	private JobsService jS;
	@Autowired
	private LocationsService lS;
	@Autowired
	private RegionsService rS;
	
	@Autowired
	private UsuariosService uS;
	@Autowired
	private RolesService roS;
	@Autowired
	private EmployeesRepository repoE;
	
	
	  // Login form
	@RequestMapping("/login")
		public String login() {
	    return "login.html";
	}
	
	@RequestMapping("/registro")
	public String registrarUsuario() {
		return "ingresarUsuario";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(Usuarios s, Model m) {
		System.out.println(""+s.getNOMBREUSUARIO());
		System.out.println(""+s.getCLAVE());
		System.out.println(""+s.getEMAIL());
		System.out.println(""+s.getTELEFONO());
		System.out.println(""+s.getACTIVO());
		if(s.getNOMBREUSUARIO() != "" && s.getCLAVE() != "" && s.getEMAIL()!="" && s.getTELEFONO() !="") {
				if(uS.findById(s.getNOMBREUSUARIO()) == null) {
					uS.save(s.getNOMBREUSUARIO(), s.getCLAVE(), s.getEMAIL(), s.getTELEFONO(),s.getACTIVO());
					return "redirect:/login";
				}
				else {
					boolean encontrado=true;
					m.addAttribute("encontrado", encontrado);
					return "ingresarUsuario";
				}
		}
		else {
			String error = "error";
			m.addAttribute("error", error);
			return "ingresarUsuario";
		}
	}
	
	@GetMapping("/verMasUsuarios/{NOMBREUSUARIO}")
	public String verUsuarios(@PathVariable("NOMBREUSUARIO") String e, Model m) {
		m.addAttribute("usuario", uS.findById(e));
		return "verMasUsuario";
	}
	
	@GetMapping("/eliminarUsuarios/{NOMBREUSUARIO}")
	public String eliminarUsuario(@PathVariable("NOMBREUSUARIO") String e, Model m) {
		m.addAttribute("usuario", uS.findById(e));
		return "eliminarUsuario";
	}
	
	@GetMapping("/eliminarU/{NOMBREUSUARIO}")
	public String eliminar(@PathVariable("NOMBREUSUARIO") String e, Model m) {
		uS.deletedById(e);
		return "redirect:/editarRoles";
	}
	
	@GetMapping("/editarUsuario/{NOMBREUSUARIO}")
	public String editar(@PathVariable("NOMBREUSUARIO") String e, Model m) {
		m.addAttribute("usuario", uS.findById(e));
		m.addAttribute("roles", roS.findById(e));
		return "editarUsuarios";
	}
	
	@PostMapping("/editarUsuarioAceptado")
	public String editarUA(@RequestParam("rol") String r, Usuarios s, Model m) {
		System.out.println(""+s.getACTIVO());
		//System.out.println(""+s.getRol().getROL());
		uS.update(s.getNOMBREUSUARIO(), s.getCLAVE(), s.getEMAIL(), s.getTELEFONO(), s.getACTIVO(),r);
		return "redirect:/editarRoles";
	}
	
	@GetMapping("/editarRoles")
	public String editarRoles(Usuarios s, Model m) {
		m.addAttribute("usuarios", uS.findAll());
		m.addAttribute("roles",roS.find());
		
		return "Usuarios";
	}
	
	// Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login.html";
	  }
	  
	@GetMapping("/")
	public String mostarEmpleados(Authentication a,Model m) {
		
		/*String nombreUsuario = a.getName();
		var autoridad = "";
		for(GrantedAuthority rol: a.getAuthorities()) {
			autoridad = rol.getAuthority();
			System.out.println("ROL: "+rol.getAuthority());
		}*/
		
		//System.out.println("Nombre de usuaruio: "+nombreUsuario);
		
		m.addAttribute("datos", eS.findAll());
		//m.addAttribute("nombreUsuario", nombreUsuario);
		//m.addAttribute("autoridad", autoridad);
		return "mostrarEmpleados"; 
	}
	
	@GetMapping("/guardar") 
	public String agregarEmpleado(Model m) {
		m.addAttribute("datosJobs", jS.findAll());
		m.addAttribute("datosDepartments", dS.findAll());
		return "agregarEmpleado";
	}
	
	@PostMapping("/guardados")
	public String agregarE(Employees e, Model m) {
		
		Iterable<Employees> empleados = repoE.findAll();
		boolean comprobacion=false;
		for (Employees em: empleados) {
			if(em.getEMAIL().equals(e.getEMAIL())) {
				comprobacion = true;
			}
		}
		if(comprobacion == true) {
			m.addAttribute("encontrado", comprobacion);
			m.addAttribute("datosJobs", jS.findAll());
			m.addAttribute("datosDepartments", dS.findAll());
			return "agregarEmpleado";
		}else {
		eS.save(e.getFIRSTNAME(), e.getLASTNAME(), e.getEMAIL(), e.getPHONE_NUMBER(), e.getHIRE_DATE(), e.getJOB_ID(), e.getSALARY(), e.getMANAGER_ID(), e.getDEPARTMENT_ID());
		return "redirect:/";
		}
	}
	
	@GetMapping("/verMasEmpleado/{EMPLOYEE_ID}")
	public String verMasEmpleado(@PathVariable("EMPLOYEE_ID") Integer e,Model m) {
		m.addAttribute("empleado", eS.findById(e));
		return "verMasEmpleado";
	}
	
	@GetMapping("/editar/{EMPLOYEE_ID}")
	public String editarEmpleado(@PathVariable("EMPLOYEE_ID") Integer e,Model m) {
		m.addAttribute("empleado", eS.findById(e));
		m.addAttribute("datosJobs", jS.findAll());
		m.addAttribute("datosDepartments", dS.findAll());
		return "editarEmpleado";
	}
	
	@PostMapping("/actualizar")
	public String actualizarE(Employees e, Model m, RedirectAttributes ra) {
		boolean comprobacion = false;
		System.out.println("EMPLOYEE_ID: "+e.getEMPLOYEE_ID());
		System.out.println("FIRST NAME: "+e.getFIRSTNAME());
		System.out.println("LAST_NAME: "+e.getLASTNAME());
		System.out.println("EMAIL: "+e.getEMAIL());
		System.out.println("PHONE: "+e.getPHONE_NUMBER());
		System.out.println("HIRE DATE: "+e.getHIRE_DATE());
		System.out.println("JOB: "+e.getJOB_ID());
		System.out.println("SALARY: "+e.getSALARY());
		System.out.println("MANAGER ID: "+e.getMANAGER_ID());
		System.out.println("DEPARTMENT: "+e.getDEPARTMENT_ID());
		Iterable<Employees> empleados = eS.findAll();
		for(Employees emp : empleados) {
			if(emp.getEMAIL().equals(e.getEMAIL()) && !emp.getEMPLOYEE_ID().equals(e.getEMPLOYEE_ID())) {
				comprobacion = true;
			}
		}
		if(comprobacion == true) {
			System.out.println("Error el email ya existe en otro usuario");
			ra.addFlashAttribute("comprobacion", comprobacion);
			return "redirect:/";
		}else {
			eS.update(e.getEMPLOYEE_ID(),e);
			return "redirect:/";
		}
	}
	
	@GetMapping("/eliminar/{EMPLOYEE_ID}")
	public String eliminarEmpleado(@PathVariable("EMPLOYEE_ID") Integer e,Model m) {
		m.addAttribute("empleado", eS.findById(e));
		m.addAttribute("datosJobs", jS.findAll());
		m.addAttribute("datosDepartments", dS.findAll());
		return "eliminarEmpleado";
	}
	
	@GetMapping("/confirmacionEliminacion/{EMPLOYEE_ID}")
	public String confirmarEliminacion(@PathVariable("EMPLOYEE_ID") Integer e, Model m) {
		eS.deletedById(e);
		return "redirect:/";
	}
	@InitBinder()
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
