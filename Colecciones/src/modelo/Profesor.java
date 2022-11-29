package modelo;

import java.util.List;

public class Profesor extends Persona{
	List<String> clases;
	
	public Profesor(String nombre,String dni,
				int edad,String telefono,List<String> clases) {
		super(nombre,dni,edad,telefono);
		this.clases=clases;
	}

}
