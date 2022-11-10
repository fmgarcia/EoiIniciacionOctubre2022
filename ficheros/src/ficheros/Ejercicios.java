package ficheros;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {
	
	public static void leerFicheroJava8(String directorio, String nombreArchivo)  {
		try {
			Files.readAllLines(Paths.get(directorio, nombreArchivo),Charset.defaultCharset())
			.forEach(l->System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void almacenarLineasJava8(String directorio, String nombreArchivo) throws IOException {
		String[] lineas = Files.readAllLines(Paths.get(directorio, nombreArchivo),Charset.defaultCharset())
				.stream().toArray(String[]::new);  // String[] lineas = {"10",50","40","28","9","16"};
		
		for(String linea : lineas)
			System.out.println(linea);
	}
	
	public static void escribirFicheroJava8(String directorio, String nombreArchivo,String[] lineas) throws IOException {
		Files.write(Paths.get(directorio, nombreArchivo), Arrays.asList(lineas));
	}
	
	public static void anyadirFicheroJava8(String directorio, String nombreArchivo,String[] lineas) throws IOException {
		Files.write(Paths.get(directorio, nombreArchivo), Arrays.asList(lineas),StandardOpenOption.APPEND);
	}
	
	/**
	 * Programa que añade una línea a un fichero por el final.
	 * @param directorio Directorio del fichero
	 * @param nombreArchivo Nombre del fichero
	 * @param linea Línea a añadir
	 * @throws IOException Posible error
	 */
	public static void anyadirLineaFicheroJava8(String directorio, String nombreArchivo,String linea) throws IOException {
		Files.writeString(Paths.get(directorio, nombreArchivo), "\n" + linea ,StandardOpenOption.APPEND);
	}
	
	public static void ejercicio1() throws IOException {
		String[] lineas = Files.readAllLines(Paths.get("files", "numeros.txt"),Charset.defaultCharset())
				.stream().toArray(String[]::new);  // String[] lineas = {"10",50","40","28","9","16"};

		int suma = 0;
		for(String linea : lineas) {
			suma += Integer.parseInt(linea);
		}

		System.out.println(String.join("+", lineas) + " = " + suma);
			
	}
	
	public static void ejercicio2(String directorio,String nombreFichero) throws IOException {
		final int MAX_LINEAS = 100;
		Scanner sc = new Scanner(System.in);
		String linea;
		String[] lineasFichero = new String[MAX_LINEAS];
		int lineaActual = 0;
		do {
			System.out.println("Introduzca línea para el fichero (FIN para finalizar): ");
			linea = sc.nextLine();
			if(!linea.toUpperCase().equals("FIN")) {
				lineasFichero[lineaActual]=linea;
				lineaActual++;
			}
				
		}while(!linea.toUpperCase().equals("FIN") && lineaActual<MAX_LINEAS);
		lineasFichero = Arrays.copyOf(lineasFichero, lineaActual);  // redimensionar el array con el número de líneas que lleva guardadas
		escribirFicheroJava8(directorio,nombreFichero,lineasFichero);		
		sc.close();
	}
	
	public static void ejercicio2b(String directorio,String nombreFichero) throws IOException {
		Scanner sc = new Scanner(System.in);
		String linea;
		do {
			System.out.println("Introduzca línea para el fichero (FIN para finalizar): ");
			linea = sc.nextLine();
			if(!linea.toUpperCase().equals("FIN")) {
				anyadirLineaFicheroJava8(directorio,nombreFichero,linea);
			}
				
		}while(!linea.toUpperCase().equals("FIN"));				
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		//ejercicio1();
		//ejercicio2("files", "ejercicio2.txt");
		ejercicio2b("files", "ejercicio2.txt");
	}

}
