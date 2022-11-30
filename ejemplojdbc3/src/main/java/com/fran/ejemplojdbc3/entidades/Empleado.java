package com.fran.ejemplojdbc3.entidades;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Empleado {
	
	// 1 creamos los atributos
	private int num;
	private String nombre;
	private int edad;
	private int departamento;
	private int categoria;
	private LocalDate contrato;
	
	// 2 Creamos los constructores
	// 2.1 Constructor vacío
	public Empleado() {
		
	}

	// 2.2 Constructor con parámetros
	public Empleado(int num, String nombre, int edad, int departamento, int categoria, LocalDate contrato) {
		super();
		this.num = num;
		this.nombre = nombre;
		this.edad = edad;
		this.departamento = departamento;
		this.categoria = categoria;
		this.contrato = contrato;
	}
	
	// 2.3 Constructor de copia (Opcional)
	public Empleado(Empleado e) {
		super();
		this.num = e.num;
		this.nombre = e.nombre;
		this.edad = e.edad;
		this.departamento = e.departamento;
		this.categoria = e.categoria;
		this.contrato = e.contrato;
	}

	
	// 3. Creación de Getters and Setters
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

	public LocalDate getContrato() {
		return contrato;
	}

	public void setContrato(LocalDate contrato) {
		this.contrato = contrato;
	}

	// 4. Creación del toString()
	@Override
	public String toString() {
		return "Empleado [num=" + num + ", nombre=" + nombre + ", edad=" + edad + ", departamento=" + departamento
				+ ", categoria=" + categoria + ", contrato=" + contrato + "]";
	}

	// 5. Creación HashCode and Equals
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
		Empleado other = (Empleado) obj;
		return num == other.num;
	}
	
	// 6. Métodos adicionales de el Empleado
	public int anyosTrabajados() {
		return Period.between(this.contrato, LocalDate.now()).getYears();
	}

	
}
