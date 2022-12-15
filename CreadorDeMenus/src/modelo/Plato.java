package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Plato extends ElementoDeMenu{
	
	List<Ingrediente> ingredientes;
	
	public Plato(String nombre, String descripcion) {
		super(nombre,descripcion);
		ingredientes=new ArrayList<>();
	}

	@Override
	public double getCalorias() {
		double calorias=0;
		for(Ingrediente i:ingredientes) {
			calorias+=i.getAlimento().getCalorias()*i.getCantidad();
		}
		//return calorias;
		
		return ingredientes.stream().
		mapToDouble(i->i.getAlimento().getCalorias()*i.getCantidad()).sum();
	}

	@Override
	public
	double getGrasas() {
		double grasas=0;
		for(Ingrediente i:ingredientes) {
			grasas+=i.getAlimento().getGrasas()*i.getCantidad();
		}
		//return grasas;
		
		return ingredientes.stream().
				mapToDouble(i->i.getAlimento().getGrasas()*i.getCantidad()).sum();
	}

	@Override
	public
	double getCarbohidratos() {
		double carbohidratos=0;
		for(Ingrediente i:ingredientes) {
			carbohidratos+=i.getAlimento().getCarbohidratos()*i.getCantidad();
		}
		//return carbohidratos;
		
		return ingredientes.stream().
				mapToDouble(i->i.getAlimento().getCarbohidratos()*i.getCantidad()).sum();
	}

	@Override
	public
	boolean tieneLeche() {
		boolean leche=false;
		for(int i=0;i<ingredientes.size() && !leche;i++) {
			if(ingredientes.get(i).getAlimento().tieneLeche())
				leche=true;
		}
		//return leche;
		
		//return ingredientes.stream().filter(i->i.getAlimento().tieneLeche()).count()>0;
		return ingredientes.stream().anyMatch(i->i.getAlimento().tieneLeche());
	}

	@Override
	public
	boolean tieneFrutosSecos() {
		return ingredientes.stream().anyMatch(i->i.getAlimento().tieneFrutosSecos());
	}

	@Override
	public
	boolean tieneGluten() {
		return ingredientes.stream().anyMatch(i->i.getAlimento().tieneGluten());
	}

	@Override
	public
	boolean tieneHuevos() {
		return ingredientes.stream().anyMatch(i->i.getAlimento().tieneHuevos());
	}
	
	public void addIngrediente(Ingrediente i) {
		ingredientes.add(i);
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n"+ 
				ingredientes.stream().map(i->i.toString()).
				collect(Collectors.joining("\n"));
	}
	
}
