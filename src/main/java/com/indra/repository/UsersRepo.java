package com.indra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.model.Users;

public interface UsersRepo extends JpaRepository<Users, String> {
	Users findByUSERNAME(String USERNAME);
}
