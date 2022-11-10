package ejerciciosFunciones;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Scanner;

public class ejercicios {

	public static void dibujaAsteriscos(int cuantos)
	{
		for(int i=0;i<cuantos;i++)
		{
			System.out.print("*");
		}
	}
	
	public static void longitudEntre(String cadena,int valor1,int valor2) {
		System.out.println(cadena.length()>=valor1 && cadena.length()<=valor2?
					"La longitud está entre "+ valor1 +" y "+valor2:
						"La longitud no está entre "+ valor1 + " y "+ valor2);
	}
	
	public static boolean longitudEntre2(String cadena,int valor1,int valor2) {
		return cadena.length()>=valor1 && cadena.length()<=valor2;
	}
	
	public static int suma(int n1,int n2)
	{
		return n1+n2;
	}
	
	public static void dibujaCuadrado(char c,int n)
	{
		for(int fila=0;fila<n;fila++)
		{
			for(int columna=0;columna<n;columna++)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void mostrarTrabajos(String nombre,String ...tareas)
	{
		System.out.println(nombre+":");
		if(tareas.length==0)
		{
			System.out.println("Esta persona no ha trabajado nunca");
		}
		else
		{
			for(int i=0;i<tareas.length;i++)
			{
				System.out.println(tareas[i]);
			}
		}
	}
	
	public static boolean esPrimo(int numero)
	{
		boolean primo=true;
		for(int i=2;i<numero/2 && primo;i++)
		{
			if(numero%i==0)
				primo=false;
		}
		return primo;
	}
	
	public static int alReves(int numero) {
		
		String cadena=numero+"";
		String nuevaCadena="";
		for(int i=0;i<cadena.length();i++)
		{
			nuevaCadena=cadena.charAt(i)+nuevaCadena;
		}
		return Integer.parseInt(nuevaCadena);
	}
	
	public static boolean esEmirp(int numero) {
		int numeroAlReves=alReves(numero);
		return esPrimo(numero) && esPrimo(numeroAlReves);
	}
	
	public static int cuantasCifras(int numero) {
		int contador=1;
		while(numero/10!=0) {
			contador++;
			numero/=10;
		}
		return contador;
	}
	
	public static int alReves2(int numero) {
		int exponente=cuantasCifras(numero)-1;
		int resultado=0;
		int resto=0;
		while(numero/10!=0) {
			resto=numero%10;
			numero/=10;
			resultado+=resto*Math.pow(10, exponente);
			exponente--;
		}
		
		return resultado+numero;
	}
	
	public static double calculaMedia(int[] numeros){
		
		int suma=0;
		if (numeros.length!=0)
		{
			for(int i=0;i<numeros.length;i++)
			{
				suma+=numeros[i];
			}
			return (double)suma/numeros.length;
		}
		return 0;
	}
	
	public static double calculaMediaPF(int[] numeros) {
		
		OptionalDouble resultado=Arrays.stream(numeros).average();
		
		double media=0;
		if(resultado.isPresent())
		{
			media=resultado.getAsDouble();
		}
		return media;
	}
	
	public static String obtenCadena(String[] cadenas) {
	//	int numero=new Random().nextInt(cadenas.length);
		
		return cadenas[new Random().nextInt(cadenas.length)];
	}
	
	public static void juegoCadenas() {
		String[] cadenas= {"Hola","Adiós","bien","mal","Incorrecto"};
		String cadena=obtenCadena(cadenas);
		Scanner sc=new Scanner(System.in);
		String cadenaUsuario="";
		int intentos=0;
		while(!cadenaUsuario.equalsIgnoreCase(cadena) && intentos<3) {
			System.out.print("Adivina la cadena:");
			cadenaUsuario=sc.nextLine();
			intentos++;
		}
		if(cadenaUsuario.equalsIgnoreCase(cadena)) {
			System.out.println("Enhorabuena!!");
		}
		else
		{
			System.out.println("Lo siento la cadena era: "+cadena);
		}
		
	}
	
	public static int obtenMaximo(int ...numeros) {
		int maximo;
		if(numeros.length==0) {
			maximo=0;
		}
		else {	
			maximo=numeros[0];
			for(int i=1;i<numeros.length;i++) {
				maximo=Math.max(maximo, numeros[i]);
			}
		}
		return maximo;
	}
	
	public static int cuantasVeces(String cadena,String subcadena) {
		
		int posicion=0;
		int contador=0;
		
		while(posicion>=0) {
			posicion=cadena.indexOf(subcadena,posicion);
			if(posicion>=0) {
				contador++;
				posicion+=subcadena.length();
			}
		}
		return contador;
	}
	
	public static double calculaMediaCadena(String cadena) {
		
		String[] numerosCadena=cadena.split(";");
		int[] numeros=new int[numerosCadena.length];
		for(int i=0;i<numerosCadena.length;i++) {
			numeros[i]=Integer.parseInt(numerosCadena[i]);
		}
		return calculaMedia(numeros);
	}
	
	//ordenar al revés. Ejercicio 11
	// Crea una función que reciba un array de cadenas y te lo devuelva ordenado
	// alfabéticamente de la ‘z’ a la ‘a’.
	public static void OrdenaArrayDescendente(String[] cadenas) {
		Arrays.sort(cadenas, Collections.reverseOrder());
	}
	
	// Ejercicio 12.
	// Crea una función que reciba un array de números y un número. y te devuelva
	// cuantas veces aparece ese número en el array.
	public static int numeroApariciones(int[] numeros, int numero) {
		int apariciones = 0;
		for(int i=0; i<numeros.length;i++) {
			if(numeros[i]==numero)
				apariciones++;
		}
		return apariciones;
	}
	
	// Programación funcional
	public static int ex12(int[] intArr, int n) {
	      return (int) Arrays.stream(intArr).filter(e->e==n).count();     
	}
	
	public static int ex12b(Integer[] intArr, int n) {
	      return (int) Arrays.asList(intArr).stream()	    		  	    		  
	    		  .filter(i -> i==n)
	    		  .count();	      
	}
	
	/**
	 * Dado un LocalDate te devuelve un String en formato dd/mm/aaaa
	 * @param fecha LocalDate pasado
	 * @return cadena con el formato indicado
	 */
	public static String devolverFechaEspanyol(LocalDate fecha) {
		String cadena = null;
		cadena = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
		return cadena;
	}
	
	// Crea una función que reciba una fecha en formato dd-mm-yyyy, conviértela a fecha
	// (LocalDate) utilizando la función subString o split para extraer el día, mes y año, o
	// usa el DateTimeFormatter, súmale 2 años, 3 meses y 5 días, y muestra la fecha
	// resultante.
	
	public static void ejercicio13(String fechaCadena) {
		// Obtener dia, mes y año con subString
		/*
		int dia = Integer.parseInt(fechaCadena.substring(0,2));
		int mes = Integer.parseInt(fechaCadena.substring(3,5));
		int anyo = Integer.parseInt(fechaCadena.substring(6,10));
		*/
		// Obtener dia, mes y año con split
		/*String[] partesCadena = fechaCadena.split("-");
		int dia = Integer.parseInt(partesCadena[0]);
		int mes = Integer.parseInt(partesCadena[1]);
		int anyo = Integer.parseInt(partesCadena[2]);*/
		
		//LocalDate fecha = LocalDate.of(anyo, mes, dia);		
		
		
		// Obtener dia, mes y año con DateTimeFormatter
		//LocalDate fecha = LocalDate.parse(fechaCadena,DateTimeFormatter.ofPattern("dd-M-y"));
		LocalDate fecha = LocalDate.parse(fechaCadena,DateTimeFormatter.ofPattern("d-M-y"));
		LocalDate fechaSumada = fecha.plusYears(2).plusMonths(3).plusDays(5);
		System.out.println(devolverFechaEspanyol(fechaSumada));
		
		// Ejercicio en 1 línea
		// System.out.println(devolverFechaEspanyol(LocalDate.parse(fechaCadena,DateTimeFormatter.ofPattern("d-M-y")).plusYears(2).plusMonths(3).plusDays(5)));
		
	}
	
	// Ejercicio adicional
	// Realiza una programa que calcule el salario total que se te queda neto en tu trabajo
	// Para ello pediremos el sueldo bruto por pantalla al usuario y su fecha de nacimiento (dd/mm/aaaa)
	// Si tiene entre 18-35 años tiene una deducción de su sueldo de 1000 euros
	// Si tiene entre 36-64 años tiene una deducción de su sueldo de 5000 euros
	// Si está jubilado (65 años cumplidos o más) tiene una deducción de 2000 euros
	// El sueldo neto es lo que cobra una vez que se le aplica la deducción menos un %:
	// Si gana entre 0-15000 Euros se le resta un 7%
	// Si gana entre 15001-50000 Euros se le resta un 15%
	// Si gana +50000 Euros se le resta un 20%
	
	public static double calculaNeto(double bruto, LocalDate fechaNacimiento) {
		final int DESCUENTO_MENOR_15000 = 7;
		final int DESCUENTO_MENOR_50000 = 15;
		final int DESCUENTO_MAYOR_50000 = 20;
		double neto=bruto;
		int anyos = Period.between(fechaNacimiento,LocalDate.now()).getYears();
		if(anyos<0)
			return -1;
		// bloque de las deducciones
		if(anyos>=18 && anyos<=35) {
			neto -= 1000;
		} else if(anyos>=36 && anyos<=64) {
			neto -= 5000;
		} else if(anyos>=65) {
			neto -= 2000;
		}
		if(neto<0)
			return 0;
		// bloque de restar %
		if(neto>=0 && neto<=15000) {
			neto = neto * (1-(DESCUENTO_MENOR_15000/100.0));  // 1-(7/100) = 1-0.07 = 0.93
		} else if(neto>15000 && neto<=50000) {
			neto = neto * (1-(DESCUENTO_MENOR_50000/100.0));
		} else if(neto>50000) {
			neto = neto * (1-(DESCUENTO_MAYOR_50000/100.0));
		}
		
		return neto;
	}
	
	
	public static void main(String[] args) {
		/*
		int suma=suma(1,3)+suma(3,4);
		System.out.println(suma);
		
		longitudEntre("hola",2,8);
		longitudEntre("Hola que tal?",2,8);
		
		if(longitudEntre2("hola",2,8))
			System.out.println("Sí");
		if(longitudEntre2("Hola que tal?",2,8))
			System.out.println("Sí");	
		*/
		
		/*for(char c='a';c<'z';c++)
			dibujaCuadrado(c,4);
		dibujaCuadrado('@',5);
		*/
	/*	
		if(esPrimo(19))
		{
			System.out.println("Es primo");
		}
		
		System.out.println(esPrimo(9)?"Es primo":"No es primo");
		
		if (esEmirp(19))
		{
			System.out.println("Es emirp");
		}
		else {
			System.out.println ("No es emirp");
		}
			
		System.out.println(alReves2(123));
	
		int[] numeros= {2,3,4,5,6,1,2};
		System.out.printf("%.2f",calculaMedia(numeros));
		
		
		juegoCadenas();
		
		System.out.println(obtenMaximo(1,4,2,5,6,1,3));
		System.out.println(obtenMaximo(3,4,1));
		System.out.println(obtenMaximo());
		
		System.out.println(cuantasVeces("cocicondo cocos con chocolate","co"));
		
		System.out.printf("%.2f",calculaMediaCadena("3;5;2;4;6;6;8"));
		*/
		/*
		String[] cadenas= {"hola","adiós","bien","mal","incorrecto"};
		OrdenaArrayDescendente(cadenas);   // ejercicio 11
		System.out.println(String.join(",", cadenas));
		*/
		// Ejercicio 12
		/*
		int[] numeros = {1,5,9,1,8,6,5,1,9,4,2};
		int apariciones = numeroApariciones(numeros, 1);
		System.out.println("El número aparece " + apariciones + (apariciones==1?" vez":" veces"));
		System.out.println("El número aparece " + ex12(numeros,1) + (ex12(numeros,1)==1?" vez":" veces"));
		*/
		// Ejercicio 13
		// ejercicio13("27-07-1976");
		
		// Ejercicio ampliación
		double devuelto = calculaNeto(20000, LocalDate.of(2000, 10, 1));
		System.out.println(devuelto);
		System.out.println(calculaNeto(20000, LocalDate.of(2080, 10, 1)));
		System.out.println(calculaNeto(500, LocalDate.of(2000, 10, 1)));
	}

}
