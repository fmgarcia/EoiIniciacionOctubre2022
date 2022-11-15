package main;

import modelo.Persona;

public class ejercicios {
	
	public static void ejercicio1() {
		Persona persona=new Persona("Nacho","11111X",23);
		persona.setEdad(-12);
		System.out.printf("Persona:%s con edad: %d\n",
				persona.getNombre(),persona.getEdad());
	}

	public static void main(String[] args) {
		ejercicio1();

	}

}
