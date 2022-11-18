package libros;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String titulo, autor;
		int ejemplares;
		//se crea el objeto libro1 utilizando el constructor con parámetros
		Libro libro1 = new Libro("El quijote", "Cervantes", 1, 0);

		//se crea el objeto libro2 utilizando el constructor por defecto
		Libro libro2 = new Libro(); 
		System.out.print("Introduce titulo: ");
		titulo = sc.nextLine(); 
		System.out.print("Introduce autor: ");
		autor = sc.nextLine(); 
		System.out.print("Numero de ejemplares: "); 
		ejemplares = sc.nextInt();
		libro2.setTitulo(titulo);
		libro2.setAutor(autor); 
		libro2.setEjemplares(ejemplares);

		System.out.println(libro1);
		System.out.println(libro2);
	}

}
