package main;

import java.util.Scanner;

import modelo.InventarioPiezas;
import modelo.Pieza;
import modelo.Reparacion;
import modelo.Taller;
import modelo.Vehiculo;

public class Main {
	
	public static void Menu()
	{
		System.out.println("    TALLER");
		System.out.println("    ------");
		System.out.println("1.- Añadir vehículo");
		System.out.println("2.- Modificar reparación");
		System.out.println("3.- Servir vehículo");
		System.out.println("4.- Mostrar reparaciones");
		System.out.println("S.- Salir");
		System.out.println();
	}
	
	public static InventarioPiezas rellenaInventario()
	{
		InventarioPiezas piezas=new InventarioPiezas();
		
		piezas.addPieza(new Pieza("carburador",300));
		piezas.addPieza(new Pieza("discos",500));
		piezas.addPieza(new Pieza("neumático",400));
		piezas.addPieza(new Pieza("filtro del polen",30));
		piezas.addPieza(new Pieza("filtro de aceite",50));
		piezas.addPieza(new Pieza("inyector",500));
		piezas.addPieza(new Pieza("eje",600));
		
	//  piezas.getPiezas().add(new Pieza("carburador",300));
		
		return piezas;
	}
	
	public static Vehiculo creaVehiculo() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Matrícula:");
		String matricula=sc.nextLine();
		System.out.print("Marca:");
		String marca=sc.nextLine();
		System.out.print("Modelo:");
		String modelo=sc.nextLine();
		System.out.print("Color:");
		String color=sc.nextLine();
		
		return new Vehiculo(matricula,marca,modelo,color);
	}
	
	public static void addReparacion(Taller miTaller) {
		Scanner sc=new Scanner(System.in);
		Vehiculo vehiculo=creaVehiculo();
		System.out.print("Descripción del problema:");
		String descripcion=sc.nextLine();
		miTaller.add(new Reparacion(vehiculo,descripcion));		
	}
	
	public static void modificaReparacion(Taller miTaller,InventarioPiezas piezas) {
		Scanner sc=new Scanner(System.in);
		String matricula="";
		String opcion;
		boolean matriculaValida=false;
		System.out.print("(H)oras o (P)iezas?:");
		opcion=sc.next();
		while(!matriculaValida) {
			System.out.print("Introduzca matrícula:");
			matricula=sc.next();
			matriculaValida=miTaller.existeReparacion(matricula);
		}
		
		if(opcion.equalsIgnoreCase("H")) {
			System.out.print("¿Cuantas horas?");
			double horas=sc.nextDouble();
			miTaller.addHoras(matricula, horas);
		}
		else if(opcion.equalsIgnoreCase("P"))
		{
			System.out.println(piezas);
			System.out.print("Elija pieza:");
			String nombre=sc.next();
			Pieza pieza=piezas.getPieza(nombre);
			if (pieza!=null) {
				miTaller.addPieza(matricula, pieza);
			}
			
		}
	}
	
	public static void verReparaciones(Taller miTaller) {
		System.out.println(miTaller);
		
	}
	
	public static void servirVehiculo(Taller miTaller) {
		Scanner sc=new Scanner(System.in);
		double precio=0;
		System.out.print("Matrícula:");
		String matricula=sc.nextLine();
		if(miTaller.existeReparacion(matricula)) {
			precio=miTaller.calculaPrecio(matricula);
			System.out.printf("Precio de la reparación de %s es: %.2f\n",matricula,precio);
			miTaller.borraReparacion(matricula);
		}
	}

	public static void main(String[] args) {
		boolean salir=false;
		Scanner sc=new Scanner(System.in);
		String opcion;
		Taller miTaller=new Taller();
		InventarioPiezas piezas=rellenaInventario();
		
		
		while(!salir) {
			Menu();
			System.out.print("Introduzca opcion:");
			opcion=sc.nextLine();
			switch(opcion) {
			case "1":
				addReparacion(miTaller);
				break;
			case "2":
				modificaReparacion(miTaller,piezas);
				break;
			case "3":
				servirVehiculo(miTaller);
				break;
			case "4":
				verReparaciones(miTaller);
				break;
			case "S":
				salir=true;
				break;
			}
			
		}
	}

}
