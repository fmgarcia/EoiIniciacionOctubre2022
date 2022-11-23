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
	
	public void despideEmpleado(int posicion) {
		for(int i=posicion;i<numEmpleados-1;i++) {
			empleados[i]=empleados[i+1];
		}
		numEmpleados--;
	}
	
	public void despideEmpleado(String nombre) {
		boolean encontrado=false;
		int posicion=0;
		for(int i=0;i<numEmpleados && !encontrado;i++) {
			if(empleados[i].getNombre().equals(nombre)){
				encontrado=true;
				posicion=i;
			}
		}
		despideEmpleado(posicion);
	}

}
