package main;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import modelo.MiComparador;
import modelo.Persona;
import modelo.Tarea;

public class Ejemplos {
	
	public static void ejemploMapas() {
		
		Map<String,String> miDiccionario=new HashMap<>();
		
		miDiccionario.put("mesa", "table");
		miDiccionario.put("silla", "chair");
		miDiccionario.put("cabeza", "head");
		miDiccionario.put("botella", "bottle");
		
		System.out.println(miDiccionario.get("bebé"));
		System.out.println(miDiccionario.getOrDefault("bebé", "Unknown"));
		
		for(Entry<String,String> e:miDiccionario.entrySet()) {
			System.out.printf("%s es en inglés %s\n",e.getKey(),e.getValue());
			
		}
		
		for(String key:miDiccionario.keySet())
			System.out.println(key);
		
		for(String value:miDiccionario.values()) {
			System.out.println(value);
		}
		
		miDiccionario.forEach((clave,valor)-> System.out.printf("%s es en inglés %s\n",clave,valor));
		
		
		
		
	}
	public static void ejemploListas() {
	List<Integer> miLista=new ArrayList<Integer>();
		
		miLista.add(23);
		miLista.add(100);
		miLista.add(1,22);
		miLista.add(22);
		
		miLista.replaceAll(n->n-10);
		
		for(int i=0;i<miLista.size();i++)
		{
			System.out.println(miLista.get(i));
		}
		
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
		
		personas.addAll(otrasPersonas);
		personas.get(personas.size()-1).setEdad(10);	
		otrasPersonas.forEach(System.out::println);
		
		ArrayList<Persona> miOtraLista=new ArrayList<>();
		
		
	}

	public static void ejemploMapas2() {
		Map<LocalDateTime,Tarea> agenda=new HashMap<>();
		agenda.put(LocalDateTime.now().plusDays(3), new Tarea("Ir a la compra"));
		agenda.put(LocalDateTime.parse("2022-11-29T19:55:00"), 
				new Tarea("Hacer la cena"));
		agenda.put(LocalDateTime.now().plusHours(3), new Tarea("Sacar la basura"));
		
		agenda.forEach((clave,valor)-> System.out.println(clave +"-"+valor));
		
		agenda.get(LocalDateTime.parse("2022-11-29T19:55:00")).setAcabada(true);
		
		agenda.forEach((clave,valor)-> System.out.println(clave +"-"+valor));
	}
	
	public static void ejemploConjunto() {
		Set<String> misFrutas=new HashSet<>();
		misFrutas.add("Manzana");
		misFrutas.add("Plátano");
		misFrutas.add("Ciruela");
		misFrutas.add("Manzana");
		misFrutas.add("Ciruela");
		misFrutas.add("ciruela");
		
		Set<String> otrasFrutas=new HashSet<>();
		otrasFrutas.add("Plátano");
		otrasFrutas.add("Manzana");
		
		System.out.println(misFrutas);
		misFrutas.remove("ciruela");
		System.out.println(misFrutas);
		System.out.println(misFrutas.contains("Manzana"));
		System.out.println(misFrutas.containsAll(otrasFrutas));
		
		
	}
	
	public static void main(String[] args) {
	//	ejemploListas();
	//	ejemploMapas();
	//	ejemploMapas2();
		ejemploConjunto();
		
	}

}
