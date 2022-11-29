package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import modelo.Direccion;
import modelo.Empleado;
import modelo.Empresa;

public class ejercicios {
	
	public static void ejercicio1() {
		
		List<Integer> listaEnteros=new ArrayList<>();
		Integer[] numeros= {10,20,30,40};
	//	List<Integer> listaEnteros=Arrays.asList(numeros);
		
		listaEnteros.add(10);
		listaEnteros.add(20);
		listaEnteros.add(30);
		listaEnteros.add(40);
		listaEnteros.add(50);
		listaEnteros.add(60);
		
	//	listaEnteros.addAll(Arrays.asList(50,60));
		
	//	listaEnteros.remove(20);
		
		listaEnteros.add(1,25);
		listaEnteros.add(2,26);
		
	//	listaEnteros.addAll(1,Arrays.asList(25,26));
		
		Collections.reverse(listaEnteros);
		
		listaEnteros.forEach(System.out::println);
	}
	
	public static void ejercicio2() {
		
		Empresa empresa=new Empresa("Mari Chelo's",
				new Direccion("mateo el sabio",3));
		
		empresa.contrataEmpleado(new Empleado("Jesús",3000));
		empresa.contrataEmpleado(new Empleado("Mario",2000));
		empresa.contrataEmpleado(new Empleado("Lucía",5000));
		
		Empresa empresa2=new Empresa(empresa);
		
		empresa2.setDireccion(new Direccion("mayor",4));
		
		empresa2.getDireccion().setCalle("Romero");
		
		empresa2.setNombre("Otra empresa");
		
		empresa2.getEmpleado(0).setNombre("Lorenzo");
		System.out.println("Empresa:" + empresa.getNombre()+" "+empresa.getDireccion());
		empresa.mostrarEmpleados();
		System.out.println("Empresa:" + empresa2.getNombre()+" "+empresa2.getDireccion());
		empresa2.mostrarEmpleados();
	}

	public static void ejercicio4() {
		List<Integer> numeros = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		numeros.replaceAll(n->n/2);
		numeros.removeIf(n->n%2!=0);
		
		numeros.forEach(System.out::println);
	}
	
	public static void ejercicioListas() {
		Scanner sc=new Scanner(System.in);
		boolean salir=false;
		String frase;
		List<String> listaFrases=new ArrayList<>();
		
		while(!salir)
		{
			System.out.println("Introduzca una frase:");
			frase=sc.nextLine();
			if(frase.length()>0)
				listaFrases.add(frase);		
			else
				salir=true;
		}
		System.out.println("Introduzca una frase a buscar:");
		frase=sc.nextLine();
		
		if(listaFrases.contains(frase))
			System.out.println("Sí está");
		
		
		
		//listaFrases.forEach(System.out::println);
		
		
	}

	public static void main(String[] args) {
	//	ejercicio1();
	//	ejercicio2();
	//	ejercicio4();
		ejercicioListas();
		
	}	

}
