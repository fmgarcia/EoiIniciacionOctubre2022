package modelo;

import java.util.Random;

public class Ave extends Animal{
	private boolean puedeVolar;
	
	public Ave(boolean puedeVolar,double peso,String nombre) { 
		super(peso,nombre);
		this.puedeVolar = puedeVolar;
	}

	public boolean isPuedeVolar() {
		return puedeVolar;
	}

	public void setPuedeVolar(boolean puedeVolar) {
		this.puedeVolar = puedeVolar;
	}
	
	public void ponerHuevos() {
		int numHuevos = new Random().nextInt(6) + 1; 
		System.out.printf("He puesto %d huevos\n", numHuevos);
	}	
	
	@Override
	public void comer() {
		peso=peso*1.05;
	//	setPeso(getPeso() * 1.05);
		System.out.printf("Pio pio. He comido y ahora peso %.2f kilos\n",
		peso);
	}

}
