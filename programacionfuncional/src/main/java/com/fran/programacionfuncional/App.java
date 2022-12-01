package com.fran.programacionfuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import com.fran.programacionfuncional.entidades.Usuario;


public class App 
{
	
	static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void ejemplosConstructores() {
		Usuario fran = new Usuario();
        System.out.println(fran);
        fran.setId(10);
        fran.setNombre("Francisco García");
        System.out.println(fran);
        Usuario fran2 = new Usuario(fran);
        fran2.setId(1234);
        System.out.println(fran2);
        Usuario fran3 = new Usuario(15,"Fran","1234",1000);
        Usuario fran4 = new Usuario(15,"Fran","1234");
	}
	
	public static void cargarDatosIniciales() {  // tearUp
		usuarios.clear();  // vaciar una lista
		usuarios.add(new Usuario(1,"Fran","1234",1000.0));
		usuarios.add(new Usuario(2,"Antonella","1234",15000));
		usuarios.add(new Usuario(3,"Esther","1234",18000));
		usuarios.add(new Usuario(4,"Jhojar","1234",9000.50));
		usuarios.add(new Usuario(1,"Francisco","1234",-3000));
		usuarios.add(new Usuario(5,"Theodros","1234",1000.0));
		usuarios.add(new Usuario(6,"Néstor","1234",2000.0));
		usuarios.add(new Usuario(6,"Álvaro","1234",3000.0));
		usuarios.add(new Usuario(6,"Fernando","1234",3000.0));
	}
	
	public static void forEach() {
		
		// 1. For clásico
		for(int i=0;i<usuarios.size();i++) {
			System.out.println(usuarios.get(i));
		}
		
		// 2. For-Each
		for(Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		// Formas funcionales. Es final.
		// 3. lambda
		usuarios.forEach(e->System.out.println(e));
		
		// 4. Método a aplicar
		usuarios.forEach(System.out::println);
		
		// 5. Uso de Stream
		usuarios.stream().forEach(e->System.out.println(e));
	}
	
	// A partir de una lista de elementos filtro algunos de ellos
	public static void filter() {
		// No es final
		for(Usuario usuario : usuarios) {  // Programación estructurada
			if(usuario.getSueldo()>5000) {
				if(usuario.getNombre().length()>6) {
					System.out.println(usuario);
				}				
			}
		}
		
		usuarios.stream()  // Progración funcional
		.filter(e->e.getSueldo()>5000)
		.filter(e->e.getNombre().length()>6)
		.forEach(e->System.out.println(e));
		
		// Creación de una sublista de elementos estructura
		// Creamos una lista de aquellos que ganen entre 5000 y 2000 y que tengan más de 5 letras en su nombre
		List<Usuario> sueldosAltos = new ArrayList<Usuario>();
		for(Usuario usuario : usuarios) {
			if(usuario.getSueldo()>5000) {
				if(usuario.getSueldo()<20000) {
					if(usuario.getNombre().length()>5) {
						sueldosAltos.add(usuario);
					}
				}				
			}
		}
		for(Usuario usuario : sueldosAltos) {
			System.out.println(usuario);
		}
		
		// Programacion funcional
		List<Usuario> sueldosAltosF = usuarios.stream()
				.filter(e->e.getSueldo()>5000)
				.filter(e->e.getSueldo()<20000)
				.filter(e->e.getNombre().length()>5)
				.collect(Collectors.toList());
		sueldosAltosF.forEach(e->System.out.println(e));
		
	}
	
	// Sirva para quedarse con parte de un objeto
	public static void map() {
		// No final.
		// Lista de los nombres de los usuarios que tengan más de 5 letras
		List<String> nombresUsuariosMas5letras =usuarios.stream()
			.map(e->e.getNombre())
			//.filter(e->e.length()>5)
			.collect(Collectors.toList());
		System.out.println("Imprimo el List:");
		nombresUsuariosMas5letras.forEach(e->System.out.println(e));
		
		Set<String> nombresNorepetidosUsuarios =usuarios.stream()
				.map(e->e.getNombre())
				.collect(Collectors.toSet());
		System.out.println("Imprimo el Set:");
		nombresNorepetidosUsuarios.forEach(e->System.out.println(e));
	}
	
	// Sirve para crear conjuntos de elementos no repetidos. Un elemento es igual a otro si cumple su método equals.
	public static void toSet() {
		// Final
		// Funcional. Crear conjunto de elementos no repetidos
		Set<Usuario> usuariosNoRepetidos = usuarios.stream().collect(Collectors.toSet());
		usuariosNoRepetidos.forEach(e->System.out.println(e));
		
		// Estructurado. Hace lo mismo que la linea anterior
		Set<Usuario> usuariosNoRepetidosE = new HashSet<Usuario>();
		for(Usuario usuario : usuarios) {
			boolean noEsta = false;
			for(Usuario noRepetido : usuariosNoRepetidosE) {
				if(noRepetido.equals(usuarios)) {
					noEsta = true;
				}
			}
			if(noEsta==false) {
				usuariosNoRepetidosE.add(usuario);
			}
		}
		usuariosNoRepetidosE.forEach(e->System.out.println(e));
		
		// Hace lo mismo que las dos de arriba
		Set<Usuario> noRepetidos = new HashSet<Usuario>(usuarios);
		noRepetidos.forEach(e->System.out.println(e));
		
	}

	// Para calcular sumas de atributos numéricos de objetos en una lista. Final
	public static void sum() {
		// En dos pasos
		double sumaSueldos = usuarios.stream()
			.mapToDouble(e->e.getSueldo())
			.sum();
		System.out.println(sumaSueldos);
		
		// Imprimir sueldo en un paso
		System.out.println(usuarios.stream().mapToDouble(e->e.getSueldo()).sum());
		
		// Suma de los sueldos >0
		// Filtro los sueldos de los usuarios
		System.out.println(usuarios.stream()
				.filter(e->e.getSueldo()>=0)
				.mapToDouble(e->e.getSueldo())
				.sum());
		// Filtros una vez que ya tengo los sueldos
		System.out.println(usuarios.stream()
				.mapToDouble(e->e.getSueldo())
				.filter(e->e>=0)
				.sum());		
	}
	
	// Para calcular medias de atributos numéricos de objetos en una lista. Final
	public static void average() {
		
		// 1 forma de gestionar los optional
		OptionalDouble mediaSueldos = usuarios.stream()
				.mapToDouble(e->e.getSueldo())
				.average();
		if(mediaSueldos.isPresent())
			System.out.println(mediaSueldos.getAsDouble());
		else
			System.out.println("No hay media ya que la lista está vacia");
		
		// 2 forma de gestionar los valores opcionales con valores por defecto (orElse)
		double mediaSueldos2 = usuarios.stream()
				.mapToDouble(e->e.getSueldo())
				.average()
				.orElse(-1);
		if(mediaSueldos2!=-1)
			System.out.println(mediaSueldos2);
		else
			System.out.println("No hay media ya que la lista está vacia");
	}
	
	// Buscar elementos en las listas. Final
	public static void find() {
		// Ejemplo findAny
		Usuario alAzar = usuarios.stream()
				.filter(e->e.getSueldo()<5000)
				.findAny()   // Coge uno pero no tiene porqué ser el primero
				.orElse(new Usuario(-1,"Al azar","1234"));
		System.out.println(alAzar);
		
		// Ejemplo findFirst
		Usuario elPrimero = usuarios.stream()
				.filter(e->e.getSueldo()<5000)
				.findFirst()   // Coge uno pero no tiene porqué ser el primero
				.orElse(new Usuario(-1,"No hay ninguno","1234"));
				System.out.println(elPrimero);
	}
	
	// A partir de una lista de listas las fusiona
	public static void flatMap() {
		
		// Cogemos una lista de listas y las concatenamos en una única lista. Pasa de dos dimensiones a una [][] -> []
		List<String> chicas = new ArrayList<String>(Arrays.asList("Antonella","Esther"));
		List<String> chicos = new ArrayList<String>(Arrays.asList("Néstor","Alvaro","Jhohar","Theo","James"));
		//chicos.forEach(e->System.out.println(e));
		List<List<String>> alumnos = new ArrayList<List<String>>(Arrays.asList(chicas,chicos));
		
		List<String> todosJuntos = alumnos.stream()
			.flatMap(e->e.stream())
			.collect(Collectors.toList());
		todosJuntos.forEach(e->System.out.println(e));
	}

	// Hace lo mismo que el forEach pero no es final
	public static void peek() {
		usuarios.stream()
			.peek(e->e.setSueldo(e.getSueldo()+1000))
			.filter(e->e.getSueldo()>10000)
			.forEach(e->System.out.println(e));
	}
	
	// A partir de una lista, crear dos sublistas, una que cumple la condición y otra que no.
	public static void partitioningBy() {
		// Final
		Map<Boolean,List<Usuario>> sublistas =usuarios.stream()
			.collect(Collectors.partitioningBy(e->e.getNombre().length()>6));
		// los que cumplen la condición
		System.out.println("Usuarios con nombre mayor a 6 letras:");
		sublistas.get(true).forEach(e->System.out.println(e));
		System.out.println("Usuarios con nombre menor o igual a 6 letras:");
		sublistas.get(false).forEach(e->System.out.println(e));
	}
	
	// A partir de una listas crea tantas listas como opciones haya a la hora de la condición de agrupación
	public static void groupingBy() {
		// Final
		Map<Character,List<Usuario>> letras = usuarios.stream()
			.collect(Collectors.groupingBy(e->e.getNombre().charAt(0)));
		letras.get('F').forEach(e->System.out.println(e));
		System.out.println("Los que empiezan por Z:");
		if(letras.containsKey('Z'))
			letras.get('Z').forEach(e->System.out.println(e));
		else
			System.out.println("No existe ninguno con la Z");
	}
	
	// Cuenta los elementos. Final.
	public static void count() {
		long numeroUsuarios = usuarios.stream()
				.filter(e->e.getSueldo()<0)
				.count();
		System.out.println("Usuarios " + numeroUsuarios);
	}
	
	// Skip salta un número de elementos y Limit limita el número de resultados
	// Dentro haremos algunas ordenaciones
	public static void skipLimit() {
		// queremos quedarnos con el 3,4 y 5 usuario que más ganan
		/*List<Usuario> usuarios345 = usuarios.stream()
			.sorted(Comparator.comparingDouble(Usuario::getSueldo).reversed())
			.skip(2)
			.limit(3)
			.collect(Collectors.toList());
		usuarios345.forEach(e->System.out.println(e));*/
		
		usuarios.stream()
		.sorted(Comparator.comparingDouble(Usuario::getSueldo).reversed())
		.skip(2)
		.limit(3)
		.forEach(e->System.out.println(e));		
	}
	
	// Máximo y mínimo valor de la comparación
	public static void maxMin() {
		
		// Con Optional
		Optional<Usuario> masGana = usuarios.stream()
			.max(Comparator.comparingDouble(Usuario::getSueldo));
		if(masGana.isPresent())
			System.out.println(masGana.get());
		
		// Sin optional
		Usuario menosGana = usuarios.stream()
				.min(Comparator.comparingDouble(Usuario::getSueldo))
				.orElse(new Usuario());
		System.out.println(menosGana);		
	}
	
	// Saca los elementos distintos. No final
	public static void distinct() {
		// Contar los diferentes ids de Usuario
		long idsDistintos = usuarios.stream()
			.distinct()
			.count();
		System.out.println(idsDistintos);			
	}
	
	// Todos devuelven booleanos. 
	public static void match() {
		// Finales
		// anyMatch. True si existe alguno que cumpla la condición
		// allMatch. True si todos cumples la condición
		// noneMatch. True si ninguno cumple la condición
		
		if(usuarios.stream().anyMatch(e->e.getSueldo()>15000)) {
			System.out.println("Existe/n persona/s que gana/n más de 15000 euros");
		} else {
			System.out.println("Nadie gana más de 15000 euros");
		}
		
		if(usuarios.stream().allMatch(e->e.getSueldo()>15000)) {
			System.out.println("Todos los usuarios ganan más de 15000 euros");
		} else {
			System.out.println("No todos ganan más de 15000 euros");
		}
		
		if(usuarios.stream().noneMatch(e->e.getSueldo()>15000)) {
			System.out.println("Ninguno gana más de 15000 euros");
		} else {
			System.out.println("Alguno gana más de 15000 euros");
		}
		
	}
	
	// recolectar datos estadísticos del atributo que queremos. Final
	public static void summarizingDouble() {
		DoubleSummaryStatistics estadisticas = usuarios.stream()
				.collect(Collectors.summarizingDouble(Usuario::getSueldo));
		System.out.println("Sueldo medio: " + estadisticas.getAverage());
		System.out.println("Máximo sueldo: " + estadisticas.getMax());
		System.out.println("Mínimo sueldo: " + estadisticas.getMin());
		System.out.println("Suma de todos los sueldos: " + estadisticas.getSum());
		System.out.println("Número de sueldos: " + estadisticas.getCount());
	}
	
	
	
    public static void main( String[] args )
    {
    	cargarDatosIniciales();
    	//forEach();
    	//filter();
    	//map();
    	//toSet();
    	//sum();
    	//average();
    	//find();
    	//flatMap();
    	//peek();
    	//partitioningBy();
    	//groupingBy();
    	//count();
    	//skipLimit();
    	//maxMin();
    	//distinct();
    	//match();
    	//summarizingDouble();
    }
}
