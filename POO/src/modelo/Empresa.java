package modelo;

public class Empresa {
	String nombre;
	Persona[] empleados;
	private int numEmpleados;
	
	public Empresa(String nombre) {
		this.nombre=nombre;
		empleados=new Persona[100];
		numEmpleados=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Persona[] getEmpleados() {
		return empleados;
	}
	
	public void contrataEmpleado(Persona persona) {
		empleados[numEmpleados]=persona;
		numEmpleados++;
	}
	
	public void mostrarEmpleados() {
		for(int i=0;i<numEmpleados;i++) {
			System.out.println(empleados[i].getNombre()
								+":"+empleados[i].getDni());
		}
	}

}
