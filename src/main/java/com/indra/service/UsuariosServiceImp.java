package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Roles;
import com.indra.model.Usuarios;
import com.indra.repository.RolesRepository;
import com.indra.repository.UsuariosRepository;

@Service
public class UsuariosServiceImp implements UsuariosService {

	@Autowired
	private UsuariosRepository uRepo;
	@Autowired
	private RolesRepository rRepo;
	
	@Autowired
	private RolesService rS;
	
	@Override
	public Iterable<Usuarios> findAll() {
		Iterable<Usuarios>  usuarios = uRepo.findAll();
		for(Usuarios u: usuarios) {
			System.out.println(u.toString());
		}
		return usuarios;
	}

	@Override
	public void save(String nombre, String clave, String email, String telefono, Integer activo) {
		Optional<Usuarios> u = uRepo.findById(nombre);
		if(u.isPresent()) {
			System.out.println("Error, el usuario ya existe");
		}else {
			Usuarios usuario = new Usuarios();
			usuario.setNOMBREUSUARIO(nombre);
			usuario.setCLAVE("{noop}"+clave);
			usuario.setEMAIL(email);
			usuario.setTELEFONO(telefono);
			usuario.setACTIVO(activo);
			uRepo.save(usuario);
			//Aqui mismo crear el rol
			rS.save(nombre);
		}
	}

	@Override
	public Usuarios findById(String nombre) {
		Usuarios usuario;
		Optional<Usuarios> u = uRepo.findById(nombre);
		if(u.isPresent()) {
			usuario = u.get();
		}else {
			usuario = null;
		}
		System.out.println(""+usuario);
		return usuario;
	}

	@Override
	public void update(String nombre, String clave, String email, String telefono, Integer activo, String rol) {
		Optional<Usuarios> u = uRepo.findById(nombre);
		Optional<Roles> r = rRepo.findById(nombre);
		
		Usuarios usuario = u.get();
		Roles rolCambio = r.get();
		
		if(clave != null) {
			usuario.setCLAVE("{noop}"+clave);
		}
		if(email!=null) {
			usuario.setEMAIL(email);
		}
		if(telefono != null) {
			usuario.setTELEFONO(telefono);
		}
		if(activo != null) {
			usuario.setACTIVO(activo);
		}
		uRepo.save(usuario);
		if(rol != null) {
			rolCambio.setROL(rol);
		}
		rRepo.save(rolCambio);
	}

	@Override
	public void deletedById(String nombre) {
		Optional<Usuarios> u = uRepo.findById(nombre);
		Optional<Roles> rol = rRepo.findById(nombre);
		if(u.isPresent()) {
			rRepo.deleteById(nombre);
			uRepo.deleteById(nombre);
			System.out.println("Eliminado correctamente");
		}
	}

}
