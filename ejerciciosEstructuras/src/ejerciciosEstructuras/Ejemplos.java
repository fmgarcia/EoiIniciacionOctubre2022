package ejerciciosEstructuras;

import java.util.Scanner;

public class Ejemplos {

	public static void vacio() {

	}

	public static void switch1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el prefijo de tu país: ");
		int prefijo = sc.nextInt();
		switch (prefijo) {
		case 34:
			System.out.println("Tu país es España");
			break;
		case 49:
			System.out.println("Tu país es Alemania");
			break;
		case 12:
			System.out.println("Tu país es Francia");
			break;
		default:
			System.out.println("No sé cual es tu país...");
			break;
		}
	}

	public static void ejemplosIncrementos() {
		// i++ (post-incremento)
		// ++i (pre-incremento)
		// i-- (post-decremento)
		// --i (pre-decremento)
		
		int numero = 0;
		numero++; // numero = 1;
		++numero; // numero = 2;
		System.out.println("número vale: " + numero); // 2
		int otronumero = numero++; // otronumero vale 2 o 3? -> 2
		System.out.println("Otro número vale: " + otronumero + " y número vale: " + numero);
		
		int valor = 3; 
		System.out.println(valor++);  // 3 o 4? -> 3
		System.out.println(valor); // 4
	}

	public static void main(String[] args) {
		//switch1();
		ejemplosIncrementos();
	}

}
