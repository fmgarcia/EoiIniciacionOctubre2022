package main;

import modelo.Persona;

public class Main {

	public static void main(String[] args) {
		Persona p=new Persona();
		p.setNombre("Pedro");
		p.setDni("11111X");
		p.setEdad(25);
		Persona p2=new Persona();
		p2.setNombre("María");
		p2.setDni("22222X");
		p2.setEdad(26);
		System.out.println("Persona:"+ p.getNombre()+" "+p.getDni());
		System.out.println("Persona:"+p2.getNombre() +" "+p2.getDni());
		

	}

}
