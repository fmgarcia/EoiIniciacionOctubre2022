package com.fran.programacionfuncional.entidades;

import java.util.Objects;

public class Usuario {
	
	private int id;
	private String nombre;
	private String password;
	private double sueldo;
	
	public Usuario() {
		
	}

	public Usuario(int id, String nombre, String password, double sueldo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.sueldo = sueldo;
	}
		
	
	public Usuario(int id, String nombre, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
	}

	public Usuario(Usuario u) {
		super();
		this.id = u.id;
		this.nombre = u.nombre;
		this.password = u.password;
		this.sueldo = u.sueldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", sueldo=" + sueldo + "]";
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
		Usuario other = (Usuario) obj;
		return id == other.id;
	}
	
	
	

}
