package ejerciciosEstructuras;

import java.util.Scanner;

public class Ejercicios {

	public static void vacio() {

	}

	public static void ejercicio1() {

	}

	public static void ejercicio22() {
		for (int i = 1; i <= 5; i++) { // número de veces que voy a repetir una acción
			for (int j = 1; j <= 9; j++) { // elementos repetidos por cada acción
				System.out.print(j);
			}
		}
	}

	public static void ejercicio23() {
		int alto = 9, ancho = 9;
		for (int fila = 0; fila < alto; fila++) {
			for (int col = 1; col <= ancho - fila; col++) {
				System.out.print(col);
			}
			System.out.println();
		}
	}

	public static void ejercicio24() {
		// Crtl+flecha arriba(shift)+o -> mete los imports
		// Crtl+flecha arriba(shift)+f -> organiza el codigo fuente
		Scanner sc = new Scanner(System.in);
		System.out.println("Exercise 24");
		System.out.print("Insert integer: ");
		int n = sc.nextInt();

		for (int row = 0; row < n; row++) { // row=0, row=1, row=2, row=3
			for (int col = 0; col < n; col++) { // col=0, col=1, col=2, col=3
				System.out.print("*");
			}
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio25() {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("Dime un número: ");
		num = sc.nextInt(); // suponemos que el usuario mete un 4

		for (int fila = 0; fila < num; fila++) // fila=0, fila=1, fila=2, fila=3
		{
			for (int col = 0; col <= fila; col++) // En la primera fila col=0, en la segunda fila col=0, col=1, en la
													// tercera fila col=0,col=1,col=2, en la cuarta fila
													// col=0,col=1,col=2,col=3
			{
				// System.out.print("fila: "+ fila + " col: "+ col);
				System.out.println("*");
			}
			System.out.println();
		}

		sc.close();
	}

	public static void ejercicio25b() {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("Dime un número: ");
		num = sc.nextInt(); // suponemos que el usuario mete un 4

		for (int fila = 0; fila < num; fila++) // fila=0, fila=1, fila=2, fila=3
		{
			for (int col = 0; col <= fila; col++) // En la primera fila col=0, en la segunda fila col=0, col=1, en la
													// tercera fila col=0,col=1,col=2, en la cuarta fila
													// col=0,col=1,col=2,col=3
			{
				if (col % 2 == 0) { // ver si un número es par o impar
					System.out.print("*");
				} else {
					System.out.print("?");
				}

			}
			System.out.println();
		}

		sc.close();
	}

	public static void ejercicio26Antonella() {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("Give me a number: ");
		num = sc.nextInt();
		for (int i = 0; i < num; i++) { // número de filas que me pasen
			for (int j = num - i; j > 1; j--) { // pintar los blancos
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) { // pintar los *
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void ejercicio26Alvaro() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Exercise 26");
		System.out.print("Insert integer: ");
		int n = sc.nextInt();

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				System.out.print(col > n - row ? "*" : " ");
			}
			System.out.print("\n"); // System.out.println();
		}
		sc.close();
	}

	public static void ejercicio26AlvaroModificado() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Exercise 26");
		System.out.print("Insert integer: ");
		int n = sc.nextInt();

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				System.out.print(col + 1 >= n - row ? "*" : " ");
			}
			System.out.print("\n"); // System.out.println();
		}
		sc.close();
	}

	public static void ejercicio26AlvaroIfElse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Exercise 26");
		System.out.print("Insert integer: ");
		int n = sc.nextInt();

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (col > n - row) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio27Nestor() {
		Scanner sc = new Scanner(System.in);
		int ancho;
		int alto;
		System.out.println("Escribe el ancho del rectángulo.");
		ancho = sc.nextInt();
		System.out.println("Escribe el alto del rectángulo.");
		alto = sc.nextInt();

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				if (j == 0 || j == ancho - 1 || i == 0 || i == alto - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		sc.close();
	}

	public static void ejercicio27NestorTernaria() {
		Scanner sc = new Scanner(System.in);
		int ancho;
		int alto;
		System.out.println("Escribe el ancho del rectángulo.");
		ancho = sc.nextInt();
		System.out.println("Escribe el alto del rectángulo.");
		alto = sc.nextInt();

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				System.out.print((j == 0 || j == ancho - 1 || i == 0 || i == alto - 1) ? "*" : " ");
			}
			System.out.println();
		}
		sc.close();
	}

	public static void ejercicio27Jhojar()
	{
		Scanner sc = new Scanner(System.in);
		int num, num2;  
		System.out.print("Dime un ancho: ");
		num = sc.nextInt(); // almacena el ancho
		System.out.print("Dime un alto: ");
		num2 = sc.nextInt(); // almacena el alto

		for (int cont = 0; num > cont; cont++) {
			System.out.print("*");
		}
		System.out.println();

		for (int cont = 1; (num2 - 2) >= cont; cont++) {
			System.out.print("*");
			for (int i = 0; (num - 2) > i; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
		for (int cont = 0; num > cont; cont++) {
			System.out.print("*");
		}
		sc.close();
	}
	
	public static void ejercicio28Esther() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime la altura de la pirámide: ");
		int num = sc.nextInt();
		
		for(int alt=1; alt<=num;alt++)
		{
			for(int bl=0; bl<num-alt;bl++)  // Izquierda de la pirámide
			{
				System.out.print("?");
			}
			for (int ast=1;ast<=(alt*2)-1; ast++)  // pirámide de asteriscos
			{
				System.out.print("*");
			}
			for(int derecha=num+alt; derecha<=(num*2)-1;derecha++)  // Derecha de la pirámide
			{
				System.out.print("¿");
			}
			System.out.println();
		}
		sc.close();
	}
	
	public static void apartado28() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime altura pirámide: ");
		int alto = sc.nextInt();
		int astStart = alto;
		int astEnd = alto;
		
		for(int fila = 1; fila <= alto; fila++) {
			for(int col = 1; col <= alto * 2 - 1; col++) {
				if(col >= astStart && col <= astEnd) {
					System.out.print("*");
				} else {
					System.out.print("?");
				}
			}
			System.out.println();
			astStart--;
			astEnd++;
		}
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio22();
		// ejercicio23();
		// ejercicio24();
		// ejercicio25();
		// ejercicio25b();
		// ejercicio26Antonella();
		// ejercicio26Alvaro();
		// ejercicio26AlvaroIfElse();
		// ejercicio26AlvaroModificado();
		// ejercicio27Nestor();
		// ejercicio27NestorTernaria();
		// ejercicio27Jhojar();
		// ejercicio28Esther();
		apartado28();
	}

}
