package ejerciciosFunciones;

import java.util.Arrays;

public class ejemplos {
	
	public static void suma(int num1, int num2) {
		num1=0;
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); 
		}
	
	public static void suma(int ...nums) {
		System.out.println("He recibido " + nums.length + " números"); 
		int total = 0;
		
	    for (int i = 0; i < nums.length; i++) { 
	    	total += nums[i];
		}
		System.out.println("La suma total es " + total); 
		}
	
	public static int resta(int n1,int n2)
	{
		int resultado=n1-n2;
		return resultado;
		//return n1-n2;
	}
	
	public static void cambiaValor(int[] nums) {
        nums[1] = 99;
    }
	
	public static void main(String[] args) {
		//suma(2,3);
		//int num1=3;
		//int num2=12;
		//suma(num1,num2);
		//System.out.println(num1);
		//suma(1,2,3,4,5);
		//suma(1,2,3);
		//resta(4,2);
		//int[] array = {1, 2, 3, 4};
		//cambiaValor(array); 
		//System.out.println(Arrays.toString(array));
		
		String s = "Mi perro se llama Comeniños"; 
		System.out.println(s.indexOf("ome")); // 3 
		System.out.println(s.indexOf("gato")); // -1
		
		s = "Mi perro se llama Comeniños"; 
		System.out.println(s.contains("ome")); // true 
		System.out.println(s.contains("gato")); // false
		
		s = "Mi perro se llama Comeniños"; 
		System.out.println(s.startsWith("perro")); // false
		System.out.println(s.endsWith("niños")); // true
		
		s = "Mi perro se llama Comeniños";
		String s1 = s.replace("m", "t"); 
		System.out.println(s1); 
		
		s = "Mi perro se llama Comeniños"; 
		String animal = s.substring(3, 8); 
		System.out.println(animal);
		
		int posicion=s.indexOf("llama");
		
		String nombre=s.substring(posicion+6);
		System.out.println(nombre);
		
		String[] palabras=s.split(" ");
		System.out.println(String.join("-",palabras));

		

	}

}
