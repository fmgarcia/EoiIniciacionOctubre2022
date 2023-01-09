package com.eoi.proyecto.entidades;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="species")
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String researchgradle;
	private String urlimage;
	@ManyToOne(fetch = FetchType.LAZY)
	private Family family;
	
	public Species() {
		
	}

	public Species(String name, String researchgradle, String urlimage, Family family) {
		super();
		this.name = name;
		this.researchgradle = researchgradle;
		this.urlimage = urlimage;
		this.family = family;
	}

	public Species(String name, String researchgradle, String urlimage) {
		super();
		this.name = name;
		this.researchgradle = researchgradle;
		this.urlimage = urlimage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResearchgradle() {
		return researchgradle;
	}

	public void setResearchgradle(String researchgradle) {
		this.researchgradle = researchgradle;
	}

	public String getUrlimage() {
		return urlimage;
	}

	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", name=" + name + ", researchgradle=" + researchgradle + ", urlimage=" + urlimage
				+ ", family=" + family + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		return id == other.id;
	}
	
	
	
}
