package ahorcado;

import java.util.Scanner;

public class Main {
	
	public static int eligeOpcion() {
		Scanner sc=new Scanner(System.in);
		int opcion;
		
		System.out.println("1.- Añadir palabras");
		System.out.println("2.- Jugar");
		System.out.println("3.- Salir");
		System.out.println();
		opcion=sc.nextInt();
		return opcion;
		
	}

	public static void main(String[] args) {
		
		boolean salir=false;
		
		while(!salir)
		{
			int opcion=eligeOpcion();
			switch(opcion) {
			case 1:
				//TODO addPalabras("palabras.txt")
				// Añadir al fichero pasado como parámetro todas las palabras
				// que le iremos pidiendo al usuario hasta que introduzca una
				// vacía. Le de enter. Si el fichero no existe, se debe crear
				// si sí existe se añade al final.
				break;
			case 2:
				//TODO jugar("palabras.txt");
				break;
			case 3:
				salir=true;
				break;
			}
			
		}
	}

}
