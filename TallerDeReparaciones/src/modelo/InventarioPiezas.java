package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventarioPiezas {
	List<Pieza> piezas;

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}

	public InventarioPiezas() {
		piezas=new ArrayList<>();
	}

	@Override
	public String toString() {
	/*	String resultado="";
		for(Pieza p:piezas) {
			resultado+=p.getNombre()+"\n";
		}
		return resultado;
		*/
		return piezas.stream().map(p->p.getNombre()).collect(Collectors.joining("\n"));
		
	}
	
	public void addPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	
	public void removePieza(Pieza pieza) {
		piezas.remove(pieza);
	}
	
	public Pieza getPieza(String nombre) {
		if((piezas.indexOf(new Pieza(nombre,0))>=0))
		{
				return piezas.get(piezas.indexOf(new Pieza(nombre,0)));
		}
		return null;
	}

}
