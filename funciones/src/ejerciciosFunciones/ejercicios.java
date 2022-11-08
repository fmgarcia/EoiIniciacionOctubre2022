package ejerciciosFunciones;

import java.util.Random;

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
	
	public static String obtenCadena(String[] cadenas) {
	//	int numero=new Random().nextInt(cadenas.length);
		
		return cadenas[new Random().nextInt(cadenas.length)];
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
	*/	
		String[] cadenas= {"Hola","Adiós","Me parece bien","No estoy segura","Incorrecto"};
		System.out.println(obtenCadena(cadenas));
		
	}

}
