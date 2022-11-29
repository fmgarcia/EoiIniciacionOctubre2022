package modelo;

public class Alumno extends Persona{
	String curso;
	
	public Alumno(String nombre,String dni,int edad,String telefono,String curso) {
		super(nombre,dni,edad,telefono);
		this.curso=curso;
	}
}
