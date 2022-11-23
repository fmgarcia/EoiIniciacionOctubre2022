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
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return String.format("%s: %.2f\n",nombre,salario);
	}
	
	

}
