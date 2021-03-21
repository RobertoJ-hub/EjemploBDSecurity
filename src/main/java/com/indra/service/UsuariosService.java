package com.indra.service;

import java.util.Optional;

import com.indra.model.Usuarios;

public interface UsuariosService {
	public Iterable<Usuarios> findAll();
	public void save(String nombre, String clave, String email, String telefono, Integer activo);
	public Usuarios findById(String nombre);
	public void update(String nombre, String clave, String email, String telefono, Integer activo, String rol);
	public void deletedById(String nombre);
}
