package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Jobs;

public interface JobsRepository extends CrudRepository<Jobs, String> {

}
