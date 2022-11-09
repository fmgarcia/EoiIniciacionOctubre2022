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
		int num1=3;
		int num2=12;
		//suma(num1,num2);
		//System.out.println(num1);
		//suma(1,2,3,4,5);
		//suma(1,2,3);
		//resta(4,2);
		int[] array = {1, 2, 3, 4};
		cambiaValor(array); // 1,99,3,4
		System.out.println(Arrays.toString(array));

	}

}
