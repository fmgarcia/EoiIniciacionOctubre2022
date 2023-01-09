package com.eoi.proyecto.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="family")
public class Family implements Serializable {

	private static final long serialVersionUID = 1L;
	//  Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Cuando es un campo auto-incremental
	private int id;
	private String name;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "family")
	private Set<Species> especies = new HashSet<Species>(0);
	
	// Constructores
	public Family() {
		
	}
	
	public Family(String name) {
		super();
		this.name = name;
	}
	

	public Family(String name, Set<Species> especies) {
		super();
		this.name = name;
		this.especies = especies;
	}

	public Family(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	// Getter and Setters

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
	
	

	// toString
	
	public Set<Species> getEspecies() {
		return especies;
	}

	public void setEspecies(Set<Species> especies) {
		this.especies = especies;
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", name=" + name + "]";
	}
	
	//HashCode and Equals

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
		Family other = (Family) obj;
		return id == other.id;
	}
	
	
}
