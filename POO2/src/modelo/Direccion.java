package modelo;

public class Direccion {
	String calle;
	int numero;
	
	public Direccion(String calle, int numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}
	
	public Direccion(Direccion d) {
		calle=d.calle;
		numero=d.numero;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %d",calle,numero);
	}
	

}
