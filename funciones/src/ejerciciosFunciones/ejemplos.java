package ejerciciosFunciones;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Scanner;

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
	
	/**
	 * Dado un LocalDate te devuelve un String en formato dd/mm/aaaa
	 * @param fecha LocalDate pasado
	 * @return cadena con el formato indicado
	 */
	public static String devolverFechaEspanyol(LocalDate fecha) {
		String cadena = null;
		cadena = fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
		return cadena;
	}
	
	public static long diasVividos(LocalDate fechaNacimiento) {
		// int resta = LocalDate.now() - fechaNacimiento;  // no se puede hacer
		return ChronoUnit.DAYS.between(fechaNacimiento,LocalDate.now());		
	}
	
	public static void ejemplosFechas() {

		Scanner sc = new Scanner(System.in);
		
		// Para trabajar con fechas y horas
		LocalDateTime fechaCompleta = LocalDateTime.of(2021, 10, 23, 19, 48, 57);
		System.out.println(fechaCompleta.toString()); // 2021-10-23T19:48:57
		LocalDateTime ahora = LocalDateTime.now();  // fecha y hora del sistema
		System.out.println(ahora);
		
		// Para trabajar con fechas
		LocalDate fecha = LocalDate.now();
		LocalDate fecha2= LocalDate.of(2020, 12, 31);
		System.out.println(devolverFechaEspanyol(fecha));
		System.out.println(devolverFechaEspanyol(fecha2));
		//System.out.println("Intrduzca la fecha completa (dd/mm/aaaa):");
		//String fechaCadena = sc.nextLine();
		String fechaCadena = "09/11/2022";
		//LocalDate fechaTransformada = LocalDate.parse(fechaCadena);  // formato estándar (aaaa-mm-dd)
		LocalDate fechaTransformada = LocalDate.parse(fechaCadena,DateTimeFormatter.ofPattern("dd/M/y"));  // Patrón más común en España
		System.out.println(fechaTransformada);
		//System.out.println("Hoy es: " + fechaTransformada.getDayOfMonth() + "/" + fechaTransformada.getMonthValue() + "/" + fechaTransformada.getYear());
		System.out.println("Hoy es: " + devolverFechaEspanyol(fechaTransformada));
		System.out.println("Hoy es el día del año: " + fecha.getDayOfYear());
		String[] dias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
		System.out.println("Hoy es el día del semana: " + fecha.getDayOfWeek());  // En inglés por defecto
		System.out.println("Hoy es el día del semana: " +  dias[fecha.getDayOfWeek().getValue()]);  // en castellano
		
		// Operaciones de fechas
		System.out.println("Dentro de 10 días será: " + devolverFechaEspanyol(LocalDate.now().plusDays(55)));
		System.out.println("Hace dos semanas era: " + devolverFechaEspanyol(LocalDate.now().minusWeeks(2)));
		System.out.println("Llevo vividos " + diasVividos(LocalDate.of(1976, 7, 27)) + " días");
		System.out.println("Llevo vividos " + Duration.between(LocalDateTime.of(1976, 7, 27,0,0,0),LocalDateTime.now()).toDays() + " días");   // más apropiada si hay horas
		// Period devuelve el número de años, meses y días entre dos fechas
		System.out.println("Tengo : " + Period.between(LocalDate.of(1976, 7, 27),LocalDate.now()).getYears() + " años");   // más apropiada si no hay horas
		System.out.println("Tengo : " + Period.between(LocalDate.of(1976, 7, 27),LocalDate.now()).getMonths() + " meses");   // más apropiada si no hay horas
		System.out.println("Tengo : " + Period.between(LocalDate.of(1976, 7, 27),LocalDate.now()).getDays() + " días");   // más apropiada si no hay horas
		sc.close();
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
		
		/*
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
		*/

		// Los ejemplos de como utilizar las clases de fechas (LocalDate, LocalTime, LocalDateTime, ChronoUnit, Period, Duration). No usar Date.
		ejemplosFechas();

	}

}
