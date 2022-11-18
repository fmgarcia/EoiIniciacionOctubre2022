package main;

import modelo.Mesa;

public class Main {

	public static void main(String[] args) {
		Mesa miMesa =new Mesa();
		
		miMesa.setAltura(1.25);
		miMesa.setAnchura(2.5);
		miMesa.setMaterial("aluminio");
		miMesa.getPata().setColor("negra");
		miMesa.getPata().setMaterial("aluminio");
		
		System.out.println(miMesa);
	}

}
