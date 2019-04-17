package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DesRepository extends CrudRepository<Description, Long> {

	List<Description> findByName(String string);
    
}