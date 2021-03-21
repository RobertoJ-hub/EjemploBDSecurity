package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, String> {
	
}
