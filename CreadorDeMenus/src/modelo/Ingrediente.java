package modelo;

public class Ingrediente {
	Alimento alimento;
	double cantidad;
	
	public Ingrediente(Alimento alimento, double cantidad) {
		super();
		this.alimento = alimento;
		this.cantidad = cantidad;
	}
	
	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return alimento+":"+cantidad;
	}
	

}
