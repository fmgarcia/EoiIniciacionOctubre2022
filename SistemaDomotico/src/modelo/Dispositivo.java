package modelo;

public abstract class Dispositivo {
	String nombre;
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}

}
