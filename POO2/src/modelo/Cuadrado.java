package modelo;

public class Cuadrado implements IFigura{
	double lado;
	
	public Cuadrado(double lado) {
		this.lado=lado;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return 4*lado;
	}
	public double getArea() {
		return lado*lado;
	}

}
