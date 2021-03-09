package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository2 extends JpaRepository<Country, String> {

	List<Country> findByNameContaining(String name);
	
	List<Country> findByNameContainingOrderByNameAsc(String name);
	
	List<Country> findByNameStartingWithOrderByNameAsc(String alphabet);
	
}
