package ejerciciosarrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {
	
	public static void ejercicio8() {
		
		final int ELEMENTOS = 10;
		Scanner sc = new Scanner(System.in);
		String[] nombres = new String[ELEMENTOS];  // cadenas[0] hasta cadenas[9]			
		int nombresValidos = 0;
		
		while(nombresValidos<ELEMENTOS) {
			System.out.println("Introduzca un nombre: ");
			String buscar = sc.nextLine();
			boolean encontrado = false;
			for (int i = 0; i < nombresValidos && !encontrado; i++) {
				if (nombres[i].equals(buscar)) {					
					encontrado = true;
				}
			}
			if (encontrado) {
				System.out.println("El nombre " + buscar + " ya está en el array");
			} else {
				nombres[nombresValidos]=buscar;
				nombresValidos++;
				System.out.println("El nombre " + buscar + " ha sido introducido en el array");
			}
		}
		
		System.out.println("El array contiene los siguientes elementos:");
		for(String nombre: nombres) {  // recorrer un array y mostrar su contenido
			System.out.println(nombre);
		}
		sc.close();
	}
	
	public static void ejercicio8PF() {
		
		final int ELEMENTOS = 10;
		Scanner sc = new Scanner(System.in);
		String[] nombres = new String[ELEMENTOS];  // cadenas[0] hasta cadenas[9]			
		int nombresValidos = 0;
		
		while(nombresValidos<ELEMENTOS) {
			System.out.println("Introduzca un nombre: ");
			String buscar = sc.nextLine();
			
			if (Arrays.stream(nombres)
					.filter(nombre->nombre!=null)
					.anyMatch(nombre -> nombre.equals(buscar))) { // debemos importar import java.util.Arrays;
				System.out.println("El nombre " + buscar + " ya está en el array");
			} else {
				nombres[nombresValidos++]=buscar;
				System.out.println("El nombre " + buscar + " ha sido introducido en el array");
			}			
		}
		
		System.out.println("El array contiene los siguientes elementos:");
		Arrays.stream(nombres).forEach(nombre->System.out.println(nombre));
		sc.close();
	}
	

	public static void ejercicio9() {
		String cadena="Ana";
		char[] aCaracteres = cadena.toCharArray();
		for(int i = 0; i<aCaracteres.length; i++) {
			if(aCaracteres[i]=='a' || aCaracteres[i]=='e' || aCaracteres[i]=='i' || aCaracteres[i]=='o' || aCaracteres[i]=='u') {
				System.out.println(aCaracteres[i]);
			}
		}		
	}
	
	public static void ejercicio9b() {
		String cadena="Ana";		
		for(int i = 0; i<cadena.length(); i++) {
			if(cadena.charAt(i)=='a' || cadena.charAt(i)=='e' 
					|| cadena.charAt(i)=='i' || cadena.charAt(i)=='o' 
					|| cadena.charAt(i)=='u') {
				System.out.println(cadena.charAt(i));
			}
		}		
	}
	
	public static void ejercicio9AdmitaMayusculas() {
		String cadena = "Ana";  // Ana

		char[] aCaracteres = cadena.toLowerCase().toCharArray();
		for(int i = 0; i<aCaracteres.length; i++) {
			if(aCaracteres[i]=='a' || aCaracteres[i]=='e' || aCaracteres[i]=='i' || aCaracteres[i]=='o' || aCaracteres[i]=='u') {
				//System.out.println(aCaracteres[i]); // a a
				System.out.println(cadena.charAt(i)); // A a
			}
		}		
	}
	
	public static void ejercicio9ContadorVocales() {
		String cadena = "Esto es una cAdena larga con muchas vOcales";  
		int[] vocales = new int[5]; // 0->a, 1->e, 2->i, 3->o, 4->u
		char[] aCaracteres = cadena.toLowerCase().toCharArray();
		for(int i = 0; i<aCaracteres.length; i++) {
			if(aCaracteres[i]=='a') 
				vocales[0]++; 
			else if(aCaracteres[i]=='e')
				vocales[1]++; 
			else if(aCaracteres[i]=='i')
				vocales[2]++; 
			else if(aCaracteres[i]=='o')
				vocales[3]++; 
			else if(aCaracteres[i]=='u')
				vocales[4]++; 			
		}
		System.out.println("Numero de A: " + vocales[0]);
		System.out.println("Numero de E: " + vocales[1]);
		System.out.println("Numero de I: " + vocales[2]);
		System.out.println("Numero de O: " + vocales[3]);
		System.out.println("Numero de U: " + vocales[4]);
	}
	
	public static void ejercicio9ContadorVocalesSwitch() {
		String cadena = "Esto es una cAdena larga con muchas vOcales";  
		int[] vocales = new int[5]; // 0->a, 1->e, 2->i, 3->o, 4->u
		char[] aCaracteres = cadena.toLowerCase().toCharArray();
		for(int i = 0; i<aCaracteres.length; i++) {			
			switch(aCaracteres[i]) {
			case 'a':
				vocales[0]++;
				break;
			case 'e':
				vocales[1]++;
				break;
			case 'i':
				vocales[2]++;
				break;
			case 'o':
				vocales[3]++;
				break;
			case 'u':
				vocales[4]++;
				break;
			}			 			
		}
		System.out.println("Numero de A: " + vocales[0]);
		System.out.println("Numero de E: " + vocales[1]);
		System.out.println("Numero de I: " + vocales[2]);
		System.out.println("Numero de O: " + vocales[3]);
		System.out.println("Numero de U: " + vocales[4]);
	}
	
	public static void ejercicio9ContadorLetras() {
		String cadena = "a Esto es una cAdena larga con muchas vOcales";  
		int[] cantidadLetras = new int[26]; // 0->a, 1->b, 2->c, ..., 26->z
		char[] aCaracteres = cadena.toLowerCase().toCharArray();
		for(int i = 0; i<aCaracteres.length; i++) {	// almacena el contador para cada letra		
			if(aCaracteres[i]>=97 && aCaracteres[i]<=122) {  // solo las letras minúsculas
				cantidadLetras[aCaracteres[i]-97]++;
			}
		}
		char letra = 'a';
		for(int numeroLetra : cantidadLetras) { // muestra los resultados de cada letra
			System.out.println(letra++ + " -> " + numeroLetra);
		}
	}
	
	public static void ejemploContarAPF() {
		String cadena = "a Esto es una cAdena larga con muchas vOcales";
		long numeroVocales = cadena.toLowerCase().chars()
				.mapToObj(l->(char)l)
				.filter(l->l=='a' || l=='e' || l=='i' || l=='o' || l=='u')
				.count();
		System.out.println("El número de vocales es: " + numeroVocales);
		
		//System.out.println("El número de vocales es: " + "a Esto es una cAdena larga con muchas vOcales".toLowerCase().chars().mapToObj(l->(char)l).filter(l->l=='a' || l=='e' || l=='i' || l=='o' || l=='u').count());
	}
	
	public static void ejercicio11() {
		
	}
	

	public static void main(String[] args) {
		//ejercicio8();
		//ejercicio8PF();
		//ejercicio9();
		//ejercicio9AdmitaMayusculas();
		//ejercicio9ContadorVocales();
		//ejercicio9ContadorVocalesSwitch();
		//ejercicio9ContadorLetras();
		//ejemploContarAPF();
		ejercicio11();
	}

}
