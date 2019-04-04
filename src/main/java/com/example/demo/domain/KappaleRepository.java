package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KappaleRepository extends CrudRepository<Kappale, Long> {

	List<Kappale> findByName(String string);
    
}