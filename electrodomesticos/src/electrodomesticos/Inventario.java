package electrodomesticos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Inventario {
	List<Electrod> lista;
	
	public Inventario() {
		lista=new ArrayList<>();
		lista.addAll(rellenaBlanca());
		lista.addAll(rellenaGris());
		lista.addAll(rellenaMarron());
		lista.addAll(rellenaPae());
	}
	
	private List<Electrod> rellenaBlanca(){
		DecimalFormat df= new DecimalFormat();
		try(Stream<String> stream=Files.lines(Paths.get("blanca.txt")))
		{
			return stream.map(line->{
				String[] partes=line.split(";");
				return new Blanca(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5],Integer.parseInt(partes[6]));
			}).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return null;
	}
	private List<Electrod> rellenaMarron(){
		try(Stream<String> stream=Files.lines(Paths.get("marron.txt")))
		{
			return stream.map(line->{
				String[] partes=line.split(";");
				return new Marron(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5],Integer.parseInt(partes[6]));
			}).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return null;
	}
	private List<Electrod> rellenaGris(){
		try(Stream<String> stream=Files.lines(Paths.get("gris.txt")))
		{
			return stream.map(line->{
				String[] partes=line.split(";");
				return new Gris(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5],Integer.parseInt(partes[6]));
			}).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return null;
	}
	private List<Electrod> rellenaPae(){
		try(Stream<String> stream=Files.lines(Paths.get("pae.txt")))
		{
			return stream.map(line->{
				String[] partes=line.split(";");
				return new Pae(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5],Integer.parseInt(partes[6]));
			}).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return null;
	}
	
	public void add(Electrod elemento) {
		lista.add(elemento);
	}
	
	public void borrar(String codigo) {
		lista.remove(new Blanca(codigo,"","",0,0,"",0));
	}
	
	public Electrod getElemento(String codigo) {
		return lista.get(lista.indexOf(new Blanca(codigo,"","",0,0,"",0)));
	}
	
	public void mostrarGamaNombre(String gama) {
		
		switch(gama) {
		case "B":
			lista.stream().
			filter(e-> e instanceof Blanca).
			sorted((e1,e2)-> e1.getNombre().compareTo(e2.getNombre())).
			forEach(System.out::println);
			break;
		case "G":
			lista.stream().
			filter(e-> e instanceof Gris).
			sorted((e1,e2)-> e1.getNombre().compareTo(e2.getNombre())).
			forEach(System.out::println);
			break;
		case "P":
			lista.stream().
			filter(e-> e instanceof Pae).
			sorted((e1,e2)-> e1.getNombre().compareTo(e2.getNombre())).
			forEach(System.out::println);
			break;
		case "M":
			lista.stream().
			filter(e-> e instanceof Marron).
			sorted((e1,e2)-> e1.getNombre().compareTo(e2.getNombre())).
			forEach(System.out::println);
			break;	
		}
		
	}
	
	public void mostrarPrecioVentaInferior(double precio) {
		lista.stream().filter(e->e.getPrecioVenta()<precio).
		sorted((e1,e2)-> 
		Double.compare(e1.getPrecioVenta(), e2.getPrecioVenta())).
		forEach(System.out::println);
	}
	
	public void mostrarPrecioCompraInferior(double precio) {
		lista.stream().filter(e->e.getPrecioCompra()<precio).
		sorted((e1,e2)-> 
		e1.getNombre().compareTo(e2.getNombre())==0?
				Double.compare(e1.getPrecioCompra(), e2.getPrecioCompra()):
				e1.getNombre().compareTo(e2.getNombre())).
		forEach(System.out::println);
	}
	
	public void recalculaPrecio(String texto,double porcentaje) {
		lista.stream().filter(e->e.getDescripcion().contains(texto))
		.forEach(e->e.setPrecioVenta(e.getPrecioCompra()*porcentaje/100+e.getPrecioCompra()));
	}
	
	public void addCantidad(int cantidad,String codigo) {		
		lista.stream().filter(e-> e.getCodigo().equals(codigo))
		.forEach(e -> e.setCantidad(e.getCantidad()+cantidad));
	}
	
	public void addCantidadTexto(int cantidad,String texto) {
		lista.stream().filter(e-> e.getNombre().contains(texto) ||
				e.getDescripcion().contains(texto))
		.forEach(e -> e.setCantidad(e.getCantidad()+cantidad));
	}
	
	public void guardar() {
		try(PrintWriter printB=new PrintWriter(new FileWriter("blanca.txt"));
			PrintWriter printM=new PrintWriter(new FileWriter("marron.txt"));
			PrintWriter printG=new PrintWriter(new FileWriter("gris.txt"));
			PrintWriter printP=new PrintWriter(new FileWriter("pae.txt")))
		{
			lista.stream().filter(e-> e instanceof Blanca)
			.forEach(e-> printB.println(e.cadenaFichero()));
			lista.stream().filter(e-> e instanceof Gris)
			.forEach(e-> printG.println(e.cadenaFichero()));
			lista.stream().filter(e-> e instanceof Marron)
			.forEach(e-> printM.println(e.cadenaFichero()));
			lista.stream().filter(e-> e instanceof Pae)
			.forEach(e-> printP.println(e.cadenaFichero()));
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String toString() {
		return "  CODIGO   NOMBRE              DESCRIPCION                    "+
				"   P.COMPRA P.VENTA E\n"+lista.stream().map(e->e.toString()).
				collect(Collectors.joining("\n"));
	}
	
}
