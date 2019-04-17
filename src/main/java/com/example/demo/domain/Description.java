package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Description {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long descriptionid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "description")
	private List<Movie> movies;
	
	public Description() {}
	
	public Description(String name) {
		super();
		this.name = name;
	}
	
	public Long getDescriptionid() {
		return descriptionid;
	}

	public void setDescriptionid(Long descriptionid) {
		this.descriptionid = descriptionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return name;
	}
}
