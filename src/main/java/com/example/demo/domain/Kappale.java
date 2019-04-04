package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kappale {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long kappaleid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kappaleid")
	private List<Albumi> albumit;
	
	public Kappale() {}
	
	public Kappale(String name) {
		super();
		this.name = name;
	}

	public Long getKappaleid() {
		return kappaleid;
	}

	public void setKappaleid(Long kappaleid) {
		this.kappaleid = kappaleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Albumi> getAlbumit() {
		return albumit;
	}

	public void setAlbumit(List<Albumi> albumit) {
		this.albumit = albumit;
	}

	@Override
	public String toString() {
		return "Kappale [kappaleid=" + kappaleid + ", name=" + name + "]";
	}
}
