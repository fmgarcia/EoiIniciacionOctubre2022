package modelo;

public class Aspirador extends Dispositivo implements IEncenderApagar{
	int bateria;
	boolean estado;
	
	public Aspirador(int bateria,boolean estado) {
		this.bateria=bateria;
		this.estado=estado;
	}
	
	public int getBateria() {
		return bateria;
	}
	
	public boolean getEncendido() {
		return estado;
	}
	
	public void encender() {
		estado=true;
	}
	public void apagar() {
		estado=false;
	}
	
	@Override
	public String toString() {
		return super.toString()+": "+ bateria+ 
		(estado?" Encendido":" Apagado");
	}
	
}
