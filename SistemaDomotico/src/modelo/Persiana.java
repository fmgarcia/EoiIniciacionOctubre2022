package modelo;

public class Persiana extends Dispositivo implements ISubirBajar{
	private static final int MAX_POSICION=100;
	private static final int MIN_POSICION=0;
	int posicion;
	
	public Persiana(int posicion) {
		abrir(posicion);
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public void abrir(int posicion) {
		this.posicion=posicion;
	}
	
	public void subir() {
		posicion=MAX_POSICION;
	}
	public void bajar() {
		posicion=MIN_POSICION;
	}
	public void subir(int porcentaje) {
		if(posicion+porcentaje<=MAX_POSICION) {
			posicion+=porcentaje;
		}
	}
	public void bajar(int porcentaje) {
		if(posicion-porcentaje>=MIN_POSICION) {
			posicion-=porcentaje;
		}
	}
	@Override
	public String toString() {
		return super.toString()+": "+ posicion;
	}

}
