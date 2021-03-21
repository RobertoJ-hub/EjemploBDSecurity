package com.indra.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.model.Countries;

public interface CountriesRepository extends CrudRepository<Countries, String> {

}
