package modelo;

import poo2.IHablador;

public class Perro extends Mamifero {
	String raza;
	
	public Perro(String nombre,double peso,
			boolean carnivoro,String raza)
	{
		super(nombre,peso,carnivoro);
		this.raza=raza;
	}
	public String tipoAnimal()
	{
		return "Perro de raza: "+raza;
	}
	
	public void ladrar() {
		System.out.println("Guau! Guau!");
	}
	public void hablar() {
		System.out.println("Guau!");
	}

}
