package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Albumi {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long albumiid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "albumi")
	private List<Artisti> artistit;
	
	public Albumi() {}
	
	public Albumi(String name) {
		super();
		this.name = name;
	}
	

	public Long getAlbumiid() {
		return albumiid;
	}

	public void setAlbumiid(Long albumiid) {
		this.albumiid = albumiid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artisti> getArtistit() {
		return artistit;
	}

	public void setArtistit(List<Artisti> artistit) {
		this.artistit = artistit;
	}

	@Override
	public String toString() {
		return "Albumi [albumiid=" + albumiid + ", name=" + name + "]";
	}
}
