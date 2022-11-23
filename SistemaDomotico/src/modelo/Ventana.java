package modelo;

public class Ventana extends Dispositivo{
	Persiana persiana;
	
	public Ventana(Persiana persiana) {
		this.persiana=persiana;
	}
	@Override
	public String toString() {
		return super.toString()+ " "+persiana.toString();
	}
	
	public Persiana getPersiana() {
		return persiana;
	}
}
