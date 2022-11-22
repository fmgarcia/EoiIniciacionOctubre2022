package modelo;

public class Circulo implements IFigura{
	double radio;
	
	public Circulo(double radio) {
		this.radio=radio;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getPerimetro() {
		return 2*Math.PI*radio;
	}
	public double getArea() {
		return Math.PI*radio*radio;
	}

}
