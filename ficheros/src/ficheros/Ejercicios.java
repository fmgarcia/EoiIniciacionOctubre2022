package ficheros;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Ejercicios {
	
	public static void leerFicheroJava8(String directorio, String nombreArchivo) throws IOException {
		Files.readAllLines(Paths.get(directorio, nombreArchivo),Charset.defaultCharset())
		.forEach(l->System.out.println(l));
	}
	
	public static void almacenarLineasJava8(String directorio, String nombreArchivo) throws IOException {
		List<String> lineasLista = Files.readAllLines(Paths.get(directorio, nombreArchivo),Charset.defaultCharset());
		String[] lineas = lineasLista.stream().toArray(String[]::new);  // transforma la lista en un array de elementos
		for(String linea : lineas)
			System.out.println(linea);
	}
	
	public static void escribirFicheroJava8(String directorio, String nombreArchivo,String[] lineas) throws IOException {
		Files.write(Paths.get(directorio, nombreArchivo), Arrays.asList(lineas));
	}
	
	public static void anyadirFicheroJava8(String directorio, String nombreArchivo,String[] lineas) throws IOException {
		Files.write(Paths.get(directorio, nombreArchivo), Arrays.asList(lineas),StandardOpenOption.APPEND);
	}
	
	public static void ejercicio1() throws IOException {
		almacenarLineasJava8("","funciones.txt");
	}

	public static void main(String[] args) throws IOException {
		ejercicio1();

	}

}
