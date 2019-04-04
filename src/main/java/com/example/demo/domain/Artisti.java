package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.domain.Albumi;
import com.example.demo.domain.Kappale;

@Entity
public class Artisti {
	
	//attribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nimi;
	private int perustamisVuosi;
	
	@ManyToOne
    @JoinColumn(name = "albumiid")
    private Albumi albumi;
	
	public Albumi getAlbumi() {
		return albumi;
	}

	public void setAlbumi(Albumi albumi) {
		this.albumi = albumi;
	}

	public Artisti() {
		super();
		this.nimi = null;
		this.perustamisVuosi = 0;
	}
	
	public Artisti(String nimi, int perustamisVuosi) {
		super();
		this.nimi = nimi;
		this.perustamisVuosi = perustamisVuosi;	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getPerustamisVuosi() {
		return perustamisVuosi;
	}

	public void setPerustamisVuosi(int perustamisVuosi) {
		this.perustamisVuosi = perustamisVuosi;
	}
	
	@Override
	public String toString() {
		return "Artisti [id=" + id + "nimi=" + nimi + "perustamisVuosi=" + perustamisVuosi + "]";
	}
}