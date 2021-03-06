package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.domain.Description;
import com.example.demo.domain.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movie {
	
	//attribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private int publishYear;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "genreid")
    private Genre genre;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "descriptionid")
	private Description description;
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public Movie() {
		super();
		this.name = null;
		this.publishYear = 0;
	}
	
	public Movie(String name, int publishYear, Genre genre, Description description) {
		super();
		this.name = name;
		this.publishYear = publishYear;	
		this.genre = genre;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	@Override
	public String toString() {
		if (this.genre != null && this.description != null)
			return "Movie [id=" + id + ", name=" + name + ", publishYear=" + publishYear + "genre =" + this.getGenre() + "description =" + this.getDescription() + "]";		
		else
			return "Movie [id=" + id + ", name=" + name + ", publishYear=" + publishYear + "]";
	}
}