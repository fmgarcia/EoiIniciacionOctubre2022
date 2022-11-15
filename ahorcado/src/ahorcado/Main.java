package ahorcado;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int eligeOpcion() {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		System.out.println("1.- Añadir palabras");
		System.out.println("2.- Jugar");
		System.out.println("3.- Salir");
		System.out.println();
		System.out.println("Introduzca la opción:");
		opcion=sc.nextInt();
		return opcion;
		
	}
	
	public static void addPalabras(String fichero) {
		String palabra=null;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.print("Introduzca una palabra");
			palabra=sc.next();
			if(!palabra.equalsIgnoreCase("fin"))
					addUnaPalabra(fichero,palabra);
		}while(!palabra.equalsIgnoreCase("fin"));	
	}
	public static void addUnaPalabra(String fichero,String palabra) {	
		try {
			if(Files.exists(Paths.get(fichero))){
				Files.write(Paths.get(fichero), Arrays.asList(palabra),StandardOpenOption.APPEND);
			}
			else {
				Files.write(Paths.get(fichero), Arrays.asList(palabra));
			}
				
		} catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
	
	public static String[] leeFichero(String fichero) {
		try {
			return Files.readAllLines(Paths.get(fichero),Charset.defaultCharset()).
					stream().toArray(String[]::new);
		} catch (NoSuchFileException e) {
			System.out.println("No hay palabras con las que jugar, introduzca algunas primero.");
		}
		catch (IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		return null;
	}
	public static String eligePalabra(String[] palabras) {
		return palabras[(int)(Math.random()*palabras.length)];
	}
	
	public static String dibujaPalabra(String palabra) {
		String resultado="";
		for(int i=0;i<palabra.length();i++) {
			resultado+="-";
		}
		return resultado;
	}
	
	public static void jugar(String fichero) {
		boolean seguir=true,ganado=false;
		String palabraElegida,palabraDibujo;
		int vidas=6;
		String[] palabras=null;
		palabras=leeFichero(fichero);
		seguir=palabras.length>0;
		//while(seguir) {
			palabraElegida=eligePalabra(palabras);
			System.out.println(palabraElegida);
			palabraDibujo=dibujaPalabra(palabraElegida);
		//	while(vidas>0 && !ganado) {
				System.out.println(palabraDibujo);
				System.out.print("Introduzca una letra:");
		//	}
		
	//	}
		
		
	}
	
	
	public static void main(String[] args) {
		
		boolean salir=false;
		
		while(!salir)
		{
			int opcion=eligeOpcion();
			switch(opcion) {
			case 1:
				addPalabras("palabras.txt");
				// Añadir al fichero pasado como parámetro todas las palabras
				// que le iremos pidiendo al usuario hasta que introduzca una
				// vacía. Le de enter. Si el fichero no existe, se debe crear
				// si sí existe se añade al final.
				break;
			case 2:
				jugar("palabras.txt");
				break;
			case 3:
				salir=true;
				break;
			}
			
		}
	}

}
