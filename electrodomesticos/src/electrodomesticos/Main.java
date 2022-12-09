package electrodomesticos;

import java.util.Scanner;

public class Main {
	
	public static void mostrarMenu() {
		System.out.println("--- INVENTARIO ELECTRODOMÉSTICOS ---");
		System.out.println("------------------------------------");
		System.out.println("1.- Crear nuevo electrodométicos");
		System.out.println("S.- Salir");
		System.out.println();
		System.out.print("Introduzca una opción:");
	}
	
	public static void Crear(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		String codigo,nombre,descripcion,cEnergetica;
		double precioVenta,precioCoste;
		String gama;
		System.out.print("Codigo: ");
		codigo=sc.nextLine();
		System.out.print("Nombre: ");
		nombre=sc.nextLine();
		System.out.print("Descripcion: ");
		descripcion=sc.nextLine();
		System.out.print("Precio de Coste: ");
		precioCoste=sc.nextDouble();
		System.out.print("Precio de Venta: ");
		precioVenta=sc.nextDouble();
		System.out.print("Categoría energética: ");
		cEnergetica=sc.next();
		System.out.print("Gama:(G)ris (B)lanca (P)AE (M)arrón: ");
		gama=sc.next();
		switch(gama) {
		case "G":
			inventario.add(new Gris(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica));
			break;
		case "B":
			inventario.add(new Blanca(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica));
			break;
		case "P":
			inventario.add(new Pae(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica));
			break;	
		case "M":
			inventario.add(new Marron(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica));
			break;
			default:
				System.out.println("Gama incorrecta");
				break;
		}
		
		
		
	}

	public static void main(String[] args) {
		Inventario inventario=new Inventario();
		Scanner sc=new Scanner(System.in);
	//	System.out.println(inventario);
		boolean salir=false;
		String opcion;
		while(!salir) {
			System.out.println(inventario);
			mostrarMenu();
			opcion=sc.next();
			switch(opcion) {
			case "1":
				Crear(inventario);
				break;
			case "S":
				salir=true;
				break;
			}
		}

	}

}
