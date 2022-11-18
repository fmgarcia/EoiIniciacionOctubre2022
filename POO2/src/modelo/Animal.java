package modelo;

import java.util.Objects;
import java.util.Random;

public class Animal {
	protected double peso; 
	protected String nombre;
	
	public Animal() {
		peso=1;
		nombre="Animal desconocido";
	}
	

	public Animal(double peso, String nombre) {
		this.peso = peso;
		this.nombre = nombre;
	}


	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void comer() {
		peso += new Random().nextDouble() * 0.5; 
		System.out.printf("Ñam ñam. Ahora peso %.2f kilos\n", peso);
	}
	@Override
	public String toString() {
	return String.format("%s: %.2f kilos", nombre, peso);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Animal))
			return false;
		Animal other = (Animal) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		return true;
	}


	


		

}
