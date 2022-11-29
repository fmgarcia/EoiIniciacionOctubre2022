package modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	Direccion direccion;
	List<Empleado> empleados;
	String nombre;
	
	
	public Empresa(String nombre,Direccion direccion) {
		this.nombre=nombre;
		this.direccion=direccion;
		empleados=new ArrayList<>();
		
	}
	
	public Empresa(Empresa e) {
		nombre=e.nombre;
		direccion=new Direccion(e.direccion);
		empleados=new ArrayList<>();
		e.empleados.forEach(emp-> this.empleados.add(new Empleado(emp)));
		
	}
	
	
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getEmpleado(int posicion) {
		return empleados.get(posicion);
	}
	
	@Override
	public String toString() {
		String resultado;
		resultado=nombre+" "+direccion+"\n";
		
		for(Empleado e:empleados) {
			resultado+=e;
		}
		
		return resultado;
	}
	

	public void contrataEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void mostrarEmpleados() {
		empleados.forEach(System.out::println);
	}
	
	public void despideEmpleado(int posicion) {
		empleados.remove(posicion);
	}
	
	public void despideEmpleado(String nombre) {
		empleados.remove(new Empleado(nombre,0));
	}
}
