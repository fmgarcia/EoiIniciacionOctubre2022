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
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return String.format("%s, %d",calle,numero);
	}
	

}
