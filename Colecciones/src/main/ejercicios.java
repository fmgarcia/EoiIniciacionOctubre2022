package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import modelo.Alumno;
import modelo.Colegio;
import modelo.Company;
import modelo.CuentoDeHadas;
import modelo.Direccion;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Person;
import modelo.Persona;
import modelo.Profesor;

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
	
	public static void ejercicio3() {
		Map<String,Persona> personas=new HashMap<>();
		
		personas.put("111111A", new Persona("Mari Chelo","111111A",22,"1122777"));
		personas.put("3333333X", new Persona("María","3333333X",44,"2333667"));
		personas.put("44444S",new Persona("Esteban","44444S",25,"2223554"));
		personas.put("222222C", new Persona("Pepito","222222C",93,"3232322"));
		
	//	personas.forEach((clave,valor)-> System.out.println(valor));
		
		int edad=personas.get("111111A").getEdad();
		personas.get("111111A").setEdad(edad+10);
		
		List<String> invitadas=new ArrayList<>();
		
		invitadas.add("111111A");
		invitadas.add("44444S");
		
		for(String s:invitadas) {
			System.out.println(personas.get(s).getNombre()+"--"+
						personas.get(s).getTelefono());
		}
		
		
	}

	public static void ejercicioColegio() {
		Scanner sc=new Scanner(System.in);
		
		Colegio colegio=new Colegio();
		colegio.addPersona(new Alumno("Man","333",12,"333","PP"));
		colegio.addPersona(new Alumno("Man2","444",12,"333","P2"));
		colegio.addPersona(new Alumno("Man3","666",12,"333","PP"));
		colegio.addPersona(new Alumno("Man4","777",12,"333","PP"));	
		colegio.addPersona(new Profesor("Profe","343434",44,"r3r3",Arrays.asList("Prog","Mates")));
		colegio.addPersona(new Profesor("Profe2","34377434",47,"r3r3",Arrays.asList("Prog","Lengua")));
		colegio.addPersona(new Alumno("Man5","388833",12,"333","P2"));
		colegio.addPersona(new Alumno("Man6","889",12,"333","PP"));
	
		colegio.listarAlumnos();
		Map<String,Alumno> excursion=new HashMap<>();
		boolean salir=false;
		String dni;
		while(!salir) {
			System.out.print("Introduzca alumno:");
			dni=sc.nextLine();
			int posicion;
			if(dni.length()>0)
			{
				posicion=colegio.getPersonas().indexOf(new Persona("",dni,0));
				excursion.put(dni, (Alumno)colegio.getPersonas().get(posicion));
			}
			else
				salir=true;
			System.out.println(excursion);
		}	
		
	}
	
	public static void ejercicio5() {
		Set<String> cadenas=new HashSet<>();
		Scanner sc=new Scanner(System.in);
		String palabra;
		boolean salir=false;
		while(!salir) {
			System.out.print("Introduzca una palabra:");
			palabra=sc.nextLine();
			if(palabra.equals("salir")){
				salir=true;
			}
			else {
				if(cadenas.contains(palabra)) {
					System.out.printf("La palabra %s está repetida\n",palabra);
				}
				else {
					cadenas.add(palabra);
				}
			}
		}
		System.out.println(cadenas);
	}
	
	public static void ejercicioSet() {
		Set<CuentoDeHadas> cuentos=new HashSet<>();
		cuentos.add(new CuentoDeHadas("Blancanieves",200));
		cuentos.add(new CuentoDeHadas("Caperucita roja",230));
		cuentos.add(new CuentoDeHadas("Blancanieves",450));
		cuentos.add(new CuentoDeHadas("Pulgarcito",223));
		cuentos.add(new CuentoDeHadas("Pulgarcito",233));
		cuentos.forEach(System.out::println);
		
		System.out.println(cuentos.contains(new CuentoDeHadas("Blancanieves",0)));
	}
	public static void ejercicioArboles()
	{
		Map<Company,TreeSet<Person>> companies=
				new TreeMap<>(
				(c1,c2)-> Double.compare(c1.getDinero(), c2.getDinero()));
		
		TreeSet<Person> tmp=new TreeSet<>(
				(p1,p2)-> Integer.compare(p1.getEdad(), p2.getEdad()));
		tmp.add(new Person("p1C1",22));
		tmp.add(new Person("p2C1",56));
		tmp.add(new Person("p3C1",33));
		
		companies.put(new Company("C1",200000), tmp);
		tmp=new TreeSet<>(
				(p1,p2)-> Integer.compare(p1.getEdad(), p2.getEdad()));
		tmp.add(new Person("p1C2",52));
		tmp.add(new Person("p2C2",26));
		tmp.add(new Person("p3C2",43));
		companies.put(new Company("C2",210000), tmp);
		tmp=new TreeSet<>(
				(p1,p2)-> Integer.compare(p1.getEdad(), p2.getEdad()));
		tmp.add(new Person("p1C3",32));
		tmp.add(new Person("p2C3",52));
		tmp.add(new Person("p3C3",23));
		companies.put(new Company("C3",110000), tmp);
		
		companies.forEach((c,e)-> System.out.println(c+" "+e));
		
	}
	
	public static void main(String[] args) {
	//	ejercicio1();
	//	ejercicio2();
	//	ejercicio4();
	//	ejercicioListas();
	//	ejercicio3();
	//	ejercicioColegio();
	//	ejercicio5();
	//	ejercicioSet();
	  ejercicioArboles();
		
		
	}	

}
