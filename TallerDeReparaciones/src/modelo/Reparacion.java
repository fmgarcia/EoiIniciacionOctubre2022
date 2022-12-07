package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reparacion {
	Vehiculo vehiculo;
	String descripcion;
	List<Pieza> piezas;
	double horas;
	
	public Reparacion(Vehiculo vehiculo, String descripcion) {
		this.vehiculo = vehiculo;
		this.descripcion = descripcion;
		this.horas=0;
		piezas= new ArrayList<>();
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(List<Pieza> piezas) {
		this.piezas = piezas;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		String resultado="";
		resultado=vehiculo.toString()+ " "+descripcion+" "+horas;
		for(Pieza p:piezas) {
			resultado+=p.toString()+"\n";
		}
		return resultado;
	}
	
	public void addPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	
	public void addHoras(double horas) {
		this.horas+=horas;
	}
	
	public double calculaPrecio() {
	//	double sumaTotal=0;
	/*	for(Pieza p:piezas) {
			sumaTotal+=p.getPrecio();
		}
		sumaTotal+=horas*50;
		return sumaTotal;
	*/
		
		return (horas*50)+
				piezas.stream().mapToDouble(p->p.getPrecio()).sum();
		}
	

}
