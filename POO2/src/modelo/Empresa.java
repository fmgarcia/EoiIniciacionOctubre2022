package modelo;

public class Empresa {
	Direccion direccion;
	Empleado[] empleados;
	String nombre;
	int numEmpleados;
	
	public Empresa(String nombre,Direccion direccion,int maxEmpleados) {
		this.nombre=nombre;
		this.direccion=direccion;
		empleados=new Empleado[maxEmpleados];
		int numEmpleados=0;
	}
	
	public Empresa(Empresa e) {
		nombre=e.nombre;
		direccion=new Direccion(e.direccion);
		numEmpleados=e.numEmpleados;
		empleados=new Empleado[e.empleados.length];
		for(int i=0;i<e.numEmpleados;i++) {
			empleados[i]=new Empleado(e.empleados[i]);
		}
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
		return empleados[posicion];
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
		empleados[numEmpleados]=empleado;
		numEmpleados++;
	}
	
	public void mostrarEmpleados() {
		for(int i=0;i<numEmpleados;i++) {
			System.out.print(empleados[i]);
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
