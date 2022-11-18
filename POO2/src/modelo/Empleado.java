package modelo;

public class Empleado {
	String nombre;
	double salario;
	
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
	}
	
	public Empleado(Empleado e) {
		nombre=e.nombre;
		salario=e.salario;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %.2f\n",nombre,salario);
	}
	
	

}
