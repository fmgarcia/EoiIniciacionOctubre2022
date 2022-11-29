package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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


	public static void main(String[] args) {
		ejercicio1();
		
	}	

}
