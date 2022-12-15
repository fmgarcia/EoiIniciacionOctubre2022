package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Alimento;
import modelo.ElementoDeMenu;
import modelo.Ingrediente;
import modelo.Menu;
import modelo.Plato;
import utils.FileUtils;

public class Main {
	
	public static Menu CreaMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca fecha del menú (dd/mm/aaaa):");
		String fechaCadena=sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha=LocalDate.parse(fechaCadena,formatter);
		System.out.print("Introduzca el cliente:");
		String cliente=sc.nextLine();
		return new Menu(cliente,fecha);
		
	}

	public static void MostrarMenu() {
		System.out.println("1.-Crear nuevo elemento");
		System.out.println("2.-Listar todos los elementos");
		System.out.println("3.-Listar aquellos con menos de … de grasas");
		System.out.println("4.-Listar aquellos con menos de .. calorías");
		System.out.println("5.-Listar aquellos con menos de .. de Carbohidratos");
		System.out.println("6.-Listar aquellos alimentos sin gluten");
		System.out.println("7.-Listar aquellos alimentos sin frutos secos");
		System.out.println("8.-Listar aquellos alimentos sin leche");
		System.out.println("9.-Listar aquellos alimentos sin huevos");
		System.out.println("10.-Listar alimentos sin alérgenos");
		System.out.println("11.-Borrar elemento");
		System.out.println("G.-Guardar menú");
		System.out.println("S.-Salir");
		System.out.println();
		System.out.print("Introduzca opción:");
	}
	
	public static Alimento creaAlimento() {
		Scanner sc=new Scanner(System.in);
		String nombre;
		String descripcion;
		String frecuencia;
		double calorias;
		double carbohidratos;
		double grasas;
		boolean gluten;
		boolean huevos;
		boolean frutosSecos;
		boolean leche;
		System.out.print("Nombre del alimento:");
		nombre=sc.nextLine();
		System.out.print("Descripción:");
		descripcion=sc.nextLine();
		System.out.print("Frecuencia:");
		frecuencia=sc.nextLine();
		System.out.println("Introduzca calorias carbohidratos y grasas separados por un espacio");
		calorias=sc.nextDouble();
		carbohidratos=sc.nextDouble();
		grasas=sc.nextDouble();
		sc.nextLine();
		System.out.print("Gluten S/N:");
		gluten=sc.nextLine().equalsIgnoreCase("S");
		System.out.print("Huevos S/N:");
		huevos=sc.nextLine().equalsIgnoreCase("S");
		System.out.print("Frutos secos S/N:");
		frutosSecos=sc.nextLine().equalsIgnoreCase("S");
		System.out.print("Leche S/N:");
		leche=sc.nextLine().equalsIgnoreCase("S");
		return new Alimento(nombre,descripcion,frecuencia,calorias,carbohidratos,
				grasas,gluten,huevos,frutosSecos,leche);
		
	}
	
	public static ElementoDeMenu borrarElemento() {
		Scanner sc=new Scanner(System.in);
		String nombre;
		System.out.print("Introduzca nombre:");
		nombre=sc.nextLine();
		return new Plato(nombre,"");
	}
	
	public static Plato creaPlato(List<ElementoDeMenu> elementos) {
		Scanner sc=new Scanner(System.in);
		String nombre;
		String descripcion;
		boolean salir=false;
		double cantidad;
		System.out.print("Nombre del plato:");
		nombre=sc.nextLine();
		System.out.print("Descripción del plato:");
		descripcion=sc.nextLine();
		Plato plato=new Plato(nombre,descripcion);
		while(!salir) {
			elementos.stream().filter(e-> e instanceof Alimento).forEach(System.out::println);
			System.out.print("Nombre del alimento:");
			nombre=sc.nextLine();
			if(nombre.equalsIgnoreCase("fin")) {
				salir=true;
			}
			else {
				System.out.print("Cantidad;");
				cantidad=sc.nextDouble();
				sc.nextLine();
				plato.addIngrediente(new Ingrediente((Alimento)elementos.get(
								elementos.indexOf(new Alimento(nombre))),
									cantidad));
			}
		}
		return plato;
	}
	
	public static void addElementosAlMenu(Menu miMenu,List<ElementoDeMenu> elementos) {
		Scanner sc=new Scanner(System.in);
		boolean salir=false;
		String nombre;
		while(!salir) {
			System.out.print("Nombre:");
			nombre=sc.nextLine();
			if(nombre.equalsIgnoreCase("fin"))
			{
				salir=true;
			}
			else
			{
				miMenu.addElemento(elementos.get(
						elementos.indexOf(new Alimento(nombre))));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String opcion;
		List<ElementoDeMenu> elementos=FileUtils.leerElementos();
		Menu miMenu=CreaMenu();
		boolean salir=false;
		while(!salir) {
			MostrarMenu();
			opcion=sc.nextLine();
			switch(opcion) {
			case "1":
				System.out.print("(A)limento o (P)lato:");
				String tipo=sc.nextLine();
				if(tipo.equalsIgnoreCase("A")){
					Alimento a=creaAlimento();
					elementos.add(a);
				}
				else if(tipo.equalsIgnoreCase("P")) {
					Plato p=creaPlato(elementos);
					elementos.add(p);
				}
				break;
			case "2":
				elementos.stream().forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "3":
				System.out.print("Introduzca grasas máximas:");
				double grasas=sc.nextDouble();
				elementos.stream().filter(e-> e.getGrasas()<grasas).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "4":
				System.out.print("Introduzca calorías máximas");
				double calorias=sc.nextDouble();
				elementos.stream().filter(e-> e.getCalorias()<calorias).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "5":
				System.out.print("Introduzca calorías máximas");
				double carbohidratos=sc.nextDouble();
				elementos.stream().filter(e-> e.getCarbohidratos()<carbohidratos).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "6":
				elementos.stream().filter(e->!e.tieneGluten()).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "7":
				elementos.stream().filter(e->!e.tieneFrutosSecos()).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "8":
				elementos.stream().filter(e->!e.tieneLeche()).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "9":
				elementos.stream().filter(e->!e.tieneHuevos()).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;	
			case "10":
				elementos.stream().filter(e-> !e.tieneGluten() && !e.tieneHuevos() && !e.tieneFrutosSecos() &&
											  !e.tieneLeche()).forEach(System.out::println);
				addElementosAlMenu(miMenu,elementos);
				break;
			case "11":
				elementos.remove(borrarElemento());
				break;
			case "G":
				FileUtils.guardaMenu(miMenu);
			case "S":
				salir=true;
				break;
			}
	
		}
	}

}
