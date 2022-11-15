package modelo;

public class Cuadrado {
	double lado;
	
	
	public Cuadrado() {
		this.lado=1;
	}
	
	public Cuadrado(double lado) {
		this.setLado(lado);
	}
	
	public Cuadrado(int lado) {
		this.setLado(lado);
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		if(lado>0) {
			this.lado = lado;
		}
		
	}
	
	public double getArea() {
		return lado*lado;
	}
	
	

}
