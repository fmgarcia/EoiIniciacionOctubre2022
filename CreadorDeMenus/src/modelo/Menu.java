package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Menu {
	String cliente;
	LocalDate fecha;
	List<ElementoDeMenu> elementos;
	
	public Menu(String cliente, LocalDate fecha) {
		this.cliente = cliente;
		this.fecha = fecha;
		elementos=new ArrayList<>();
	}
	
	public List<ElementoDeMenu> getElementos(){
		return elementos;
	}
	
	public void addElemento(ElementoDeMenu m) {
		elementos.add(m);
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	public double getCalorias() {
		
		return elementos.stream().
		mapToDouble(i->i.getCalorias()).sum();
	}

	public double getCarbohidratos() {
		
		return elementos.stream().
		mapToDouble(i->i.getCarbohidratos()).sum();
	}
	public double getGrasas() {
		
		return elementos.stream().
		mapToDouble(i->i.getGrasas()).sum();
	}	
	
	
	public
	boolean tieneHuevos() {
		return elementos.stream().anyMatch(i->i.tieneHuevos());
	}
	public
	boolean tieneGluten() {
		return elementos.stream().anyMatch(i->i.tieneGluten());
	}
	public
	boolean tieneLeche() {
		return elementos.stream().anyMatch(i->i.tieneLeche());
	}
	public
	boolean tieneFrutosSecos() {
		return elementos.stream().anyMatch(i->i.tieneFrutosSecos());
	}
	
	
	
	

}
