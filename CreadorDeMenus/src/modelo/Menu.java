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
	
	
	
	

}
