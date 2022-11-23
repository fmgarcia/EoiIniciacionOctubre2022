package modelo;

public class Gallina extends Ave{
	
	public Gallina(boolean puedeVolar,
			double peso,String nombre) {
		super(puedeVolar,peso,nombre);
	}
	
	public String tipoAnimal() {
		return "Gallina";
	}
	
	public void hablar() {
		System.out.println("Coc! coc!");
	}

}
