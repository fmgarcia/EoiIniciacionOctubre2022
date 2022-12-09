package electrodomesticos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		try(Stream<String> stream=Files.lines(Paths.get("blanca.txt")))
		{
			return stream.map(line->{
				String[] partes=line.split(";");
				return new Blanca(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5]);
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
							partes[5]);
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
				return new Marron(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5]);
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
				return new Marron(partes[0],partes[1],partes[2],
							Double.parseDouble(partes[3]),
							Double.parseDouble(partes[4]),
							partes[5]);
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
	
	@Override
	public String toString() {
		return "  CODIGO   NOMBRE              DESCRIPCION                    "+
				"   P.COMPRA P.VENTA E\n"+lista.stream().map(e->e.toString()).
				collect(Collectors.joining("\n"));
	}
	
}
