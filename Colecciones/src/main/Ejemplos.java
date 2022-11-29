package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.MiComparador;
import modelo.Persona;

public class Ejemplos {

	public static void main(String[] args) {
		List<Integer> miLista=new ArrayList<Integer>();
		
		miLista.add(23);
		miLista.add(100);
		miLista.add(1,22);
		miLista.add(22);
		
		miLista.replaceAll(n->n-10);
		
		Integer[] numeros= {2,3,4};
		List<Integer> otraLista=Arrays.asList(numeros);
		
		miLista.addAll(1,otraLista);
		/*for(int i:miLista) {
			System.out.println(i);
		}*/
		Integer[] array=new Integer[miLista.size()];
		miLista.toArray(array);
		
		System.out.println(miLista.lastIndexOf(22));
		miLista.forEach(i->System.out.println(i));
		
		miLista.sort((n1,n2)-> Integer.compare(n2,n1));
		System.out.println("Ordenado");
		miLista.forEach(System.out::println);
		
		List<String> misCadenas=new ArrayList<>();
		
		
		/*if(miLista.contains(22))
		{
			System.out.println("Sí está");
		}
		*/
		misCadenas.add("Hola");
		misCadenas.add("adiós");
		misCadenas.add("Hello");
	/*	if(misCadenas.contains("Hola"))
			System.out.println("Sí está");
	*/
		
		
		misCadenas.sort((s1,s2)-> s1.compareToIgnoreCase(s2));
		//misCadenas.sort(new MiComparador());
		misCadenas.forEach(System.out::println);
		
		List<Persona> personas=new ArrayList<>();
		
		personas.add(new Persona("Mari Chelo","111111A",22));
		personas.add(new Persona("Pepito","222222C",93));
		personas.add(new Persona("María","3333333X",44));
		personas.add(new Persona("Esteban","44444S",25));
		personas.add(new Persona("Mariana","555555D",66));
		
		for(Persona p:personas) {
			System.out.println(p);
		}
		personas.forEach(p -> System.out.println(p));
	
		personas.forEach(p -> System.out.println(p));
		
		List<Persona> otrasPersonas=new ArrayList<>();
		otrasPersonas.add(new Persona("Mari Chelo","111111A",22));
		otrasPersonas.add(new Persona("María","3333333X",44));
		System.out.println(
				personas.containsAll(otrasPersonas));
			
		System.out.println(personas.lastIndexOf(new Persona("","3333333X",0)));
		System.out.println(personas.isEmpty());
	//	personas.clear();
		System.out.println(personas.isEmpty());
		personas.remove(new Persona("","111111A",0));
		
		
		//personas.forEach(p -> System.out.println(p));
		
	//	personas.removeIf(p -> p.getEdad()>40);
		
	//	System.out.println("Borrando mayores de 40");
	//	personas.forEach(System.out::println);
		
		personas.forEach(p -> p.setEdad(p.getEdad()+10));
		personas.replaceAll(
				p-> new Persona(p.getNombre(),p.getDni(),p.getEdad()+10));
	
		personas.sort((p1,p2)->p2.getNombre().compareToIgnoreCase(p1.getNombre()));
		personas.forEach(System.out::println);
		
		personas.sort(null);
		personas.forEach(System.out::println);
		
		personas.sort((p1,p2)-> Integer.compare(p2.getEdad(), p1.getEdad()));
		personas.forEach(System.out::println);
		
		
	}

}
