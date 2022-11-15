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
	
	public static String rellenaPalabra(String palabraElegida,char letra,String palabraDibujo) {		
		String resultado="";
		for(int i=0;i<palabraDibujo.length();i++) {
			if(palabraElegida.charAt(i)==letra) {
				resultado+=letra;
			}
			else {
				resultado+=palabraDibujo.charAt(i);
			}
		}
		return resultado;
		
	}
	public static void dibujaAhorcado(int vidas) {
		if(vidas<=5) {
			System.out.println("\t\t\t O");
		}
		if(vidas==4) {
			System.out.println("\t\t\t |");
		}
		else if(vidas==3) {
			System.out.println("\t\t\t/|");
		}
		else if (vidas<=2) {
			System.out.println("\t\t\t/|\\");
		}
		if(vidas==1) {
			System.out.println("\t\t\t/");
		}
		else if(vidas==0) {
			System.out.println("\t\t\t/ \\");
		}
	}
	
	public static void jugar(String fichero) {
		Scanner sc=new Scanner(System.in);
		boolean seguir=true,ganado=false;
		String palabraElegida,palabraDibujo,letrasFalladas="";
		String seguirJugando;
		char letra;
		int vidas=6;
		String[] palabras=null;
		palabras=leeFichero(fichero);
		seguir=palabras.length>0;
		while(seguir) {
			vidas=6;
			ganado=false;
			palabraElegida=eligePalabra(palabras);
			//System.out.println(palabraElegida);
			palabraDibujo=dibujaPalabra(palabraElegida);
			while(vidas>0 && !ganado) {
				System.out.println(palabraDibujo);
				System.out.print("Introduzca una letra:");
				letra=sc.next().charAt(0);
				if(palabraElegida.contains(letra+"")) {
					palabraDibujo=rellenaPalabra(palabraElegida,letra,palabraDibujo);					
				}
				else {
					letrasFalladas+=letra+" ";
					vidas--;
				}
				if(palabraElegida.equalsIgnoreCase(palabraDibujo)) {
					ganado=true;
					System.out.println("Enhorabuena has acertado la palabra: " + palabraDibujo);				
				}
				dibujaAhorcado(vidas);
				System.out.println("\n\t\t\t"+letrasFalladas);
			}
			if(vidas==0)
				System.out.println("¡Lo siento! La palabra era:"+palabraElegida);
			System.out.print("¿Desea jugar otra partida? (S/N)");
			seguirJugando=sc.next();
			seguir=seguirJugando.equalsIgnoreCase("S");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		boolean salir=false;
		
		while(!salir)
		{
			int opcion=eligeOpcion();
			switch(opcion) {
			case 1:
				addPalabras("palabras.txt");
				break;
			case 2:
				jugar("palabras.txt");
				break;
			case 3:
				salir=true;
				System.out.println("¡Adiós!");
				break;
			}
			
		}
	}

}
