package modelo;

import java.util.ArrayList;
import java.util.List;

public class Colegio {
	List<Persona> personas;
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Colegio() {
		personas=new ArrayList<>();
	}
	
	public void addPersona(Persona p) {
		personas.add(p);
	}
	
	@Override
	public String toString() {
		String resultado="";
		for(Persona p:personas) {
			resultado+=p.toString()+"\n";
		}
		return resultado;
	}
	
	public void listarAlumnos() {
		personas.forEach(p->{
			if(p instanceof Alumno) 
				System.out.println(p);
		});
		
	/*	for(Persona p:personas) {
			if(p instanceof Alumno) 
				System.out.println(p);
		}*/
	}
	
	public void listarProfesores() {
		personas.forEach(p->{
			if(p instanceof Profesor) 
				System.out.println(p);
		});
	}
	

}
