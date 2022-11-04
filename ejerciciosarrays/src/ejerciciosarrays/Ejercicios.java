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
		
		String[] nombreAlumnos = {"María","José","Ana","Gustavo"};
		int[][] notas = {
				{8,4,6,9},
				{2,9,1,5},
				{3,6,10,9},
				{8,5,6,9}			
		};
		
		for(int i = 0 ; i < nombreAlumnos.length; i++) {
			int sumaNotas = 0;  // para cada alumno le damos valor 0 para que no arrastre los datos del alumno anterior
			for(int j=0; j< notas[i].length; j++) {
				sumaNotas += notas[i][j];  // hacemos la suma de todas sus notas
			}
			double media = (double)sumaNotas / notas[i].length;  // calculamos su media
			System.out.println(nombreAlumnos[i] + " tiene nota media: " + media);
		}
		
	}
	
	public static void ejercicio11MediasTotales() {
		
		String[] nombreAlumnos = {"María","José","Ana","Gustavo"};
		int[][] notas = {
				{8,4,6,9},
				{2,9,1,5},
				{3,6,10,9},
				{8,5,6,9}			
		};
		
		int sumaTotal = 0;
		int contadorNotas = 0;
		for(int i = 0 ; i < nombreAlumnos.length; i++) {
			int sumaNotas = 0;  // para cada alumno le damos valor 0 para que no arrastre los datos del alumno anterior
			for(int j=0; j< notas[i].length; j++) {
				sumaNotas += notas[i][j];  // hacemos la suma de todas sus notas
				sumaTotal += notas[i][j];  // incrementamos la suma total de las notas de todos los alumnos
				contadorNotas++;  // contadorNotas = contadorNotas + 1;
			}
			double media = (double)sumaNotas / notas[i].length;  // calculamos su media
			System.out.println(nombreAlumnos[i] + " tiene nota media: " + media);
		}
		
		System.out.println("La nota media del curso es: " + ((double)sumaTotal/contadorNotas));
		System.out.println("La nota media del curso es: " + ((double)sumaTotal/(notas.length*notas[0].length)));  // notas.length es el número de filas y notas[0].length el número de columnas de la primera fila
		
	}
	
	public static void ejercicio12() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el número de alumnos: ");
		int numAlumnos = Integer.parseInt(sc.nextLine());
		
		String[] nombreAlumnos = new String[numAlumnos];
		int[][] notas = new int[numAlumnos][4];
		
		// Aquí rellenaré los datos de los alumnos
		for(int i = 0 ; i < nombreAlumnos.length; i++) {
			System.out.println("Intrduzca el nombre del alumno " + (i+1));
			nombreAlumnos[i] = sc.nextLine();
			for(int j=0; j< notas[i].length; j++) {
				System.out.println("Introduzca para el alumno " + (i+1) + " la nota "+ (j+1));
				notas[i][j] = Integer.parseInt(sc.nextLine());
			}
		}
		
		for(int i = 0 ; i < nombreAlumnos.length; i++) {
			int sumaNotas = 0;  // para cada alumno le damos valor 0 para que no arrastre los datos del alumno anterior
			for(int j=0; j< notas[i].length; j++) {
				sumaNotas += notas[i][j];  // hacemos la suma de todas sus notas
			}
			double media = (double)sumaNotas / notas[i].length;  // calculamos su media
			System.out.println(nombreAlumnos[i] + " tiene nota media: " + media);
		}
		
		sc.close();
	}
	
	public static void ejercicio2Repaso()
	{
		Scanner sc=new Scanner(System.in);
		int[] numeros=new int[10];
		int suma=0;
		double media=0;
		
		for(int i=0;i<10;i++)
		{
			System.out.println("N:");
			numeros[i]=sc.nextInt();
		}
		sc.close();
		for(int i=0;i<10;i+=2)
		{
			suma+=numeros[i];
		}
		media=suma/(numeros.length/2);
		System.out.println(media);
		
	}
	
	public static void ejercicio5Repaso()
	{
		// 1.- Rellenar array
		// 2.- Recorrer array y llevar 3 contadores
		// cuantosPositivos, cuantosNegativos, cuantosCeros
		// por cada positivo sumo uno a cuantosPositivos
		//para los negativos y ceros lo mismo
		
		
		Scanner sc=new Scanner(System.in);
		int[] numeros=new int[10];
		int cuantosPositivos=0,cuantosNegativos=0,cuantosCeros=0;
		
		for(int i=0;i<10;i++)
		{
			System.out.print("Número:");
			numeros[i]=sc.nextInt();
		}
		sc.close();
		for(int i=0;i<10;i++)
		{
			if(numeros[i]>0)
				cuantosPositivos++;
			else if(numeros[i]<0)
				cuantosNegativos++;
			else
				cuantosCeros++;
		}
		System.out.printf("Positivos:%d Negativos:%d Ceros:%d",
				cuantosPositivos,cuantosNegativos,cuantosCeros);	
	}
	
	public static void ejercicio5RepasoPF()
	{
		Scanner sc=new Scanner(System.in);
		int[] numeros=new int[10];
		int cuantosPositivos=0,cuantosNegativos=0,cuantosCeros=0;		
		for(int i=0;i<10;i++)
		{
			System.out.print("Número:");
			numeros[i]=sc.nextInt();
		}
		sc.close();
		cuantosPositivos=(int)Arrays.stream(numeros).filter(n->n>0).count();
		cuantosNegativos=(int)Arrays.stream(numeros).filter(n->n<0).count();
		cuantosCeros=(int)Arrays.stream(numeros).filter(n->n==0).count();
		
		
		System.out.println(cuantosPositivos);
		
	}
	
	public static void ejercicio6Repaso()
	{
		/*1 Rellenar array
		 * 2.Recorrer array y 
		 * si es positivo el contenido
		 * 		sumaPositivos+=numeros[i]
		 * 		cuantosPositivos++;
		 * si es negativo lo sumo a los negativos 
		 * Cuando termino de recorre el array
		 * saco las medias:
		 *    sumaPositivos/cuantosPositivos
		 *    sumaNegativos/cuantosNegativos
		 */
		Scanner sc=new Scanner(System.in);
		int[] numeros=new int[10];
		int cuantosPositivos=0,cuantosNegativos=0,cuantosCeros=0;
		double mediaPositivos=0,mediaNegativos=0;
		int sumaPositivos=0,sumaNegativos=0;
		for(int i=0;i<10;i++)
		{
			System.out.print("Número:");
			numeros[i]=sc.nextInt();
		}
		sc.close();
		for(int i=0;i<10;i++)
		{
			if(numeros[i]>0)
			{
				cuantosPositivos++;
				sumaPositivos+=numeros[i];
			}
			else if(numeros[i]<0)
			{
				cuantosNegativos++;
				sumaNegativos+=numeros[i];
			}
			
		}
		mediaPositivos=(double)sumaPositivos/cuantosPositivos;
		mediaNegativos=(double)sumaNegativos/cuantosNegativos;
		
		System.out.printf("Media positivos:%.2f Media negativos:%.2f",
							mediaPositivos,mediaNegativos);
		
		
	}
	
	public static void ejercicio08Repaso()
	{
		/* 1.- Rellenar los 2 arrays al mismo tiempo --> en un solo for
		 * 2.- Inicializo la variable maxSueldo=sueldos[0] 
		 * 											indiceMaximo=0
		 * 3.- Busco sueldo máximo y actualizo índice máximo 
		 * 4.- Mostrar el nombre del empleado con el sueldo más alto
		 */
		Scanner sc=new Scanner(System.in);
	/*	String[] nombres=new String[20];
		double[] sueldos=new double[20];
		*/
		
		String[] nombres= {"Pepe","Juan","León","María","Lucía"};
		double[] sueldos= {2000,53000,1000,2345,4567};
		double maxSueldo;
		int indiceMaximo;
		
	/*	for(int i=0;i<nombres.length;i++)
		{
			System.out.print("Nombre:");
			nombres[i]=sc.next();
			System.out.print("Sueldo");
			sueldos[i]=sc.nextDouble();
		}*/
		
		
		maxSueldo=sueldos[0];
		indiceMaximo=0;
		for(int i=1;i<sueldos.length;i++)
		{
			if(sueldos[i]>maxSueldo)
			{
				maxSueldo=sueldos[i];
				indiceMaximo=i;
			}
		}
		System.out.printf("%s con %.2f sueldo",
				nombres[indiceMaximo],sueldos[indiceMaximo]);
	
		sc.close();
		
		
		
		
		
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
		//ejercicio11();
		//ejercicio11MediasTotales();
		//ejercicio12();
		//ejercicio2Repaso();
		//ejercicio5Repaso();
		//ejercicio5RepasoPF();
		//ejercicio6Repaso();
		ejercicio08Repaso();
		
	}

}
