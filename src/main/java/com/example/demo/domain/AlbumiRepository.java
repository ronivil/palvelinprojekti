package com.example.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumiRepository extends CrudRepository<Albumi, Long> {

	List<Albumi> findByName(String string);
    
}