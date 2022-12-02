package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Taller {
	Map<String,Reparacion> reparaciones;
	
	public Taller() {
		reparaciones=new HashMap<>();
	}
	
	public void add(Reparacion r) {
		
		reparaciones.put(r.getVehiculo().getMatricula(), r);
	}
	
	public void addHoras(String matricula, double horas) {
		
		reparaciones.get(matricula).addHoras(horas);
	}
	
	public void addPieza(String matricula,Pieza pieza) {
		
		reparaciones.get(matricula).addPieza(pieza);
	}
	
	public double calculaPrecio(String matricula) {
		
		return reparaciones.get(matricula).calculaPrecio();
	}
	
	public void borraReparacion(String matricula) {
		reparaciones.remove(matricula);
	}

	@Override
	public String toString() {
		String resultado="";
		for(Reparacion value: reparaciones.values()) {
			resultado+=value.toString()+"\n";
		}
		return resultado;
	}
	
	public boolean existeReparacion(String matricula) {
		return reparaciones.containsKey(matricula);
	}
	

}
