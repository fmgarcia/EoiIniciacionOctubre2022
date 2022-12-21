package com.eoi.spring1.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empleados")
public class Empleados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private int num;
	private String nombre;
	private int edad;
	private int departamento;
	private int categoria;
	@Temporal(TemporalType.DATE)
	private Date contrato;
	
	public Empleados() {
		
	}

	public Empleados(int num, String nombre, int edad, int departamento, int categoria, Date contrato) {
		super();
		this.num = num;
		this.nombre = nombre;
		this.edad = edad;
		this.departamento = departamento;
		this.categoria = categoria;
		this.contrato = contrato;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Date getContrato() {
		return contrato;
	}

	public void setContrato(Date contrato) {
		this.contrato = contrato;
	}

	@Override
	public String toString() {
		return "Empleados [num=" + num + ", nombre=" + nombre + ", edad=" + edad + ", departamento=" + departamento
				+ ", categoria=" + categoria + ", contrato=" + contrato + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleados other = (Empleados) obj;
		return num == other.num;
	}
	
	

}
