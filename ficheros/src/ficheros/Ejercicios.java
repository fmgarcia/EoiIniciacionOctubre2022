package ficheros;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
		String[] lineas = Files.readAllLines(Paths.get(directorio, nombreArchivo),
						Charset.defaultCharset()).stream().toArray(String[]::new);  // String[] lineas = {"10",50","40","28","9","16"};
		
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
	
	public static void leerFichero3lineas(String path,String file)
	{
		
		try {
			/*String[] lineas = Files.readAllLines(Paths.get(path, file),Charset.defaultCharset())
					.stream().toArray(String[]::new);*/
			
			String[] lineas =Files.readAllLines(Paths.get(path, file),Charset.defaultCharset())
					.stream().limit(3).toArray(String[]::new);
			
			/*for(int i=0;i<3;i++) {
				System.out.println(lineas[i]);
			  }
				*/
			for(int i=0;i<lineas.length;i++) {
				System.out.println(lineas[i]);
			}		
		}catch(NoSuchFileException e) {
			System.out.println("Fichero no existe");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		
	}
	public static int cuentaLineas(String nombre) {
		String[] lineas=null;
		try {
		File f=new File(nombre);
		if(f.exists()) {
			lineas = Files.readAllLines(Paths.get(nombre),Charset.defaultCharset())
					.stream().toArray(String[]::new);
			return lineas.length;
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static long cuentaLineasPF(String nombre) {
		int numeroDeLineas;
		try {
		File f=new File(nombre);
		if(f.exists()) {
			return Files.lines(Paths.get(nombre)).count();
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static void ejercicioContarLineas()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca nombre de fichero:");
		String nombre=sc.nextLine();
		System.out.println(cuentaLineas(nombre));
		System.out.println(cuentaLineasPF(nombre));
		sc.close();
	}
	
	public static String[] leerFichero(String nombre) {
		try {
			return Files.readAllLines(Paths.get(nombre),Charset.defaultCharset())
					.stream().toArray(String[]::new);
		}catch (NoSuchFileException e) {
			return new String[0];
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void lineasEmpiezanPorA()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca nombre de fichero:");
		String nombre=sc.nextLine();
		String[] lineas=leerFichero(nombre);
		if(lineas.length>0) {
			for(int i=0;i<lineas.length;i++){
				if(lineas[i].startsWith("a") || lineas[i].startsWith("A")) {
					System.out.println(i+1+": "+lineas[i]);
				}
			}
		}
		sc.close();
	}
	
	public static void lineasEmpiezanPorAPF()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca nombre de fichero:");
		String nombre=sc.nextLine();
		try {
			Files.lines(Paths.get(nombre)).filter(line-> 
					line.startsWith("a") || line.startsWith("A")).
					forEach(System.out::println);
		} catch (NoSuchFileException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
		sc.close();
	}
	public static void contarPalabras(){
		int palabras=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca nombre de fichero:");
		String nombre=sc.nextLine();
		String[] lineas=leerFichero(nombre);
		for(String s:lineas) {
			palabras+=s.split(" ").length;
		}
		System.out.println(palabras);
		sc.close();
	}
	
	public static void contarPalabrasPF() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca nombre de fichero:");
		String nombre=sc.nextLine();
		try {
			System.out.println(Files.lines(Paths.get(nombre)).
					mapToInt(line->
							(line.split(" ").length)).sum());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		sc.close();
	}
	
	public static void ejercicio3() {
		//1.- Leer el fichero--> String[]
		//2.- Recorrer el array y separar las líneas con el separador ;
		//3.- La primera parte la guardamos en otro array de strings
		//4.- La segunda parte la guardamos en un array de doubles
		//5.- La longitud de ambos arrays sera la misma del array 
		//     resultante de leer el fichero.
	}
	

	public static void main(String[] args) throws IOException {
		//ejercicio1();
		//ejercicio2("files", "ejercicio2.txt");
		//ejercicio2b("files", "ejercicio2.txt");
		//leerFichero3lineas("files","ejercicio3.txt");
		//ejercicioContarLineas();
		//lineasEmpiezanPorA();
		//lineasEmpiezanPorAPF();
		//contarPalabras();
		contarPalabrasPF();
				
	}

}
