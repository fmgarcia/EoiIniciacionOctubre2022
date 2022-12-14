package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.ElementoDeMenu;
import modelo.Menu;
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

	public static void main(String[] args) {
		List<ElementoDeMenu> elementos=FileUtils.leerElementos();
	//	elementos.stream().forEach(System.out::println);
		Menu miMenu=CreaMenu();
		System.out.println(miMenu.getFecha());

	}

}
