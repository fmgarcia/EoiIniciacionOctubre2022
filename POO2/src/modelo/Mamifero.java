package modelo;

public class Mamifero extends Animal{
	private boolean carnivoro;
	
	public Mamifero(String nombre, double peso, boolean carnivoro) { 
		super(peso, nombre);
	this.carnivoro = carnivoro;
	}
	
	@Override
	public void comer() {
		super.comer();
		System.out.println(
			"He comido: " + (carnivoro ? "carne" : "hierba"));
	} 

}
