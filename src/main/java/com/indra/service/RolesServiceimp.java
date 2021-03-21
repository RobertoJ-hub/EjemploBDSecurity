package com.indra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.model.Roles;
import com.indra.repository.RolesRepository;

@Service
public class RolesServiceimp implements RolesService {

	@Autowired
	private RolesRepository rRepo;
	
	@Override
	public Iterable<Roles> find() {
		Iterable<Roles> r = rRepo.findAll();
		return r;
	}

	@Override
	public void save(String nombre) {
		Iterable<Roles> roles = rRepo.findAll();
		int cont=0;
		Roles r = new Roles();
		r.setNOMBREUSUARIO(nombre);
		for(Roles ro: roles) {
			cont++;
		}
		if(cont==0) {
			r.setROL("admin");
		}
		else {
			r.setROL("basico");
		}
		rRepo.save(r);
	}

	@Override
	public void deletedById(String nombre) {
		Optional<Roles> rol = rRepo.findById(nombre);
		if(rol.isPresent()) {
			rRepo.deleteById(nombre);
			System.out.println("Rol eliminado con exito");
		}
	}

	@Override
	public void update(String nombre, String rol) {
		Optional<Roles> r = rRepo.findById(nombre);
		if(r.isPresent()) {
			Roles rolNuevo = r.get();
			rolNuevo.setROL(rol);
			rRepo.save(rolNuevo);
		}
	}

	@Override
	public Roles findById(String nombre) {
		Optional<Roles> rol = rRepo.findById(nombre);
		Roles r = rol.get();
		System.out.println(r);
		return r;
	}

}
