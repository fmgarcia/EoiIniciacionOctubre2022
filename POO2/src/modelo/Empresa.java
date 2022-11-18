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
		empleados=new Empleado[e.empleados.length];
		for(int i=0;i<e.numEmpleados;i++) {
			empleados[i]=new Empleado(e.empleados[i]);
		}
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
}
