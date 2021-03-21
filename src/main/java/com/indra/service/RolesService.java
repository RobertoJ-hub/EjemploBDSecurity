package com.indra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.indra.model.Roles;

public interface RolesService {
	public Iterable<Roles> find();
	public Roles findById(String nombre);
	public void save(String nombre);
	public void deletedById(String nombre);
	public void update(String nombre, String rol);
}
