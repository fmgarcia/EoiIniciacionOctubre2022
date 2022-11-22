package modelo;

public class Luz extends Dispositivo implements IEncenderApagar{
	
	boolean estado;
	
	public Luz(boolean estado) {
		this.estado=estado;
	}
	
	public boolean getEncendida() {
		return estado;
	}
	
	public void encender() {
		this.estado=true;
	}
	public void apagar() {
		this.estado=false;
	}
	
	@Override
	public String toString() {
		return super.toString()+" :"
	+(estado?"Encendida":"Apagada");
	}
	

}
