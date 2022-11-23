package modelo;

public class Calefaccion extends Dispositivo implements IEncenderApagar{
	int temperatura;
	boolean estado;
	
	
	public Calefaccion(int temperatura,boolean estado) {
		this.temperatura=temperatura;
		this.estado=estado;
	}
	public Calefaccion(int temperatura) {
		this(temperatura,false);		
	}
	public int getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(int temperatura) {
		this.temperatura=temperatura;
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
		return super.toString()+ " Temperatura:"+temperatura+
		(estado?" Encendida":" Apagada");
	}

}
