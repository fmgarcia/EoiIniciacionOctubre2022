package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.Alimento;
import modelo.ElementoDeMenu;
import modelo.Ingrediente;
import modelo.Plato;

public class FileUtils {
	
	public static List<ElementoDeMenu> leerElementos() {
		
		List<ElementoDeMenu> lista=new ArrayList<>();
		
		if(Files.exists(Paths.get("aliments.txt")) &&
				Files.exists(Paths.get("dishes.txt"))) {
			
			try(Stream<String> streamA=Files.lines(Paths.get("aliments.txt"));
				Stream<String> streamD=Files.lines(Paths.get("dishes.txt"))){
				
				lista.addAll(
						streamA.map(linea->{
							String[] partes=linea.split(";");
							return new Alimento(partes[0],partes[1],partes[2],
									Double.parseDouble(partes[7]),Double.parseDouble(partes[8]),
									Double.parseDouble(partes[9]),Boolean.parseBoolean(partes[3]),
											Boolean.parseBoolean(partes[6]),Boolean.parseBoolean(partes[5]),
													Boolean.parseBoolean(partes[4]));
						}).collect(Collectors.toList()));
				
				lista.addAll(
						streamD.map(linea ->{
							String[] partes=linea.split(";");
							Plato plato=new Plato(partes[0],partes[1]);
							for(int i=2;i<partes.length;i+=11) {
								plato.addIngrediente(new Ingrediente(new Alimento(partes[i+1],partes[i+2],partes[i+3],
									Double.parseDouble(partes[i+8]),Double.parseDouble(partes[i+9]),
									Double.parseDouble(partes[i+10]),Boolean.parseBoolean(partes[i+4]),
											Boolean.parseBoolean(partes[i+7]),Boolean.parseBoolean(partes[i+6]),
													Boolean.parseBoolean(partes[i+5])),Double.parseDouble(partes[i])));
							}
							return plato;
						}).collect(Collectors.toList()));
				
				
			} catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
			
		}
		return lista;
		
	}

}
