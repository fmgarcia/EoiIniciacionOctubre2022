package ejerciciosarrays;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Ejemplos {

	public static void ejemplo1() {
		String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };
		boolean encontrado = false; // Nos indicará si hemos encontrado el valor
		String buscar = "Pedro"; // Valor a buscar en el array
		// La condición también incluye que no hayamos encontrado lo que buscamos
		for (int i = 0; i < nombres.length && !encontrado; i++) {
			if (nombres[i].equals(buscar)) {
				encontrado = true;
			}
		}
		if (encontrado) {
			System.out.println("El nombre " + buscar + " está en el array");
		} else {
			System.out.println(buscar + " no encontrado...");
		}
	}

	public static void ejemplo1PF() {
		String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };
		String buscar = "Pedro"; // Valor a buscar en el array
		if (Arrays.stream(nombres).anyMatch(nombre -> nombre.equals("Pedro"))) { // debemos importar import
																					// java.util.Arrays;
			System.out.println("El nombre " + buscar + " está en el array");
		} else {
			System.out.println(buscar + " no encontrado...");
		}
	}

	public static void redimensionarArray() {
		String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };

		nombres = Arrays.copyOf(nombres, 10); // nombres[0] hasta nombres[9]
		nombres[5] = "Marta";
		System.out.println(nombres.length); // 10
		System.out.println(String.join(", ", nombres)); // Juan, Ana, Pedro, Eva, Paco, Marta, null, null, null, null
	}

	// Quiero ir cogiendo nombre por pantalla y añadiéndolos al array hasta que
	// pongan Salir
	public static void aumentarDeUnoEnUno() {
		Scanner sc = new Scanner(System.in);
		String[] nombres = { "Fran" };
		String nombre;
		do {
			System.out.println("Introduzca un nombre:");
			nombre = sc.nextLine(); // coge el nombre
			if (!nombre.toLowerCase().equals("salir")) {
				nombres = Arrays.copyOf(nombres, nombres.length + 1); // aumenta en 1 el array
				nombres[nombres.length - 1] = nombre; // Me copia el nombre en la posición extra que acabo de añadir
			}
		} while (!nombre.toLowerCase().equals("salir"));

		System.out.println("El array ha quedado con los siguientes nombres");
		for (String nombreArray : nombres) {
			System.out.println(nombreArray);
		}
		sc.close();
	}

	public static void eliminarElementosArrayDesplazamiento() {

		final int MAX_ITEMS = 10;
		int[] nums = new int[MAX_ITEMS];
		int guardados = 0;

		nums[guardados++] = 15;
		nums[guardados++] = 6;
		nums[guardados++] = 9;
		nums[guardados++] = 12;
		nums[guardados++] = 20;

		System.out.println("Números guardados: " + guardados); // Números guardados: 5
		for (int i = 0; i < guardados; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println(); // 15 6 9 12 20

		// Ahora vamos a borrar la posición 2 (número 9)
		for (int i = 2; i <= guardados - 1; i++) {
			nums[i] = nums[i + 1]; // Desplazamos los números a la izquierda
		}
		guardados--; // Decrementamos el número de elementos guardados

		for (int i = 0; i < guardados; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println(); // 15 6 12 20
	}

	public static void eliminarElementosArray() {
		Scanner sc = new Scanner(System.in);
		int[] nums = { 15, 6, 9, 12, 20 };
		// System.out.println("Elementos del array: " + Arrays.toString(nums));
		System.out.println("Elementos del array: ");
		for (int i = 0; i < nums.length; i++)
			System.out.println((i + 1) + ". " + nums[i]);
		System.out.println("Introduzca la posición del elemento que desea borrar: ");
		int borrado = Integer.parseInt(sc.nextLine());

		// Ahora vamos a borrar el seleccionado por el usuario
		for (int i = borrado - 1; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1]; // Desplazamos los números a la izquierda
		}
		nums = Arrays.copyOf(nums, nums.length - 1);
		System.out.println("El array ha quedado de la siguiente forma:");
		System.out.println(Arrays.toString(nums)); // [15, 6, 12, 20] (posición borrada con éxito)
	}

	public static void anyadirElementosArrayDesplazamiento() {
		final int MAX_ITEMS = 10;
		int[] nums = new int[MAX_ITEMS]; // [0,0,0,0,0,0,0,0,0,0]
		int guardados = 0;
		nums[guardados++] = 15;
		nums[guardados++] = 6;
		nums[guardados++] = 9;
		nums[guardados++] = 12;
		nums[guardados++] = 20; // [15,6,9,12,20,0,0,0,0,0]
		System.out.println("Números guardados: " + guardados); // Números guardados: 5
		if (guardados < MAX_ITEMS) {
			for (int i = guardados - 1; i >= 3; i--) { // Recorremos al revés
				nums[i + 1] = nums[i]; // Desplazamos los números a la derecha
			}
			nums[3] = 2; // Insertamos el número 2 en la posición 3
			guardados++;
		}
		System.out.println(Arrays.toString(nums)); // [15, 6, 9, 2, 12, 20, 0, 0, 0, 0] (posición insertada con éxito)
	}

	public static void anyadirElementosArray() {
		int[] nums = { 15, 6, 9, 12, 20 };
		// Ahora vamos a insertar el número 2 en la posición 3
		nums = Arrays.copyOf(nums, nums.length + 1); // Redimensionamos array
		for (int i = nums.length - 2; i >= 3; i--) {
			nums[i + 1] = nums[i]; // Desplazamos los números a la derecha
		}
		nums[3] = 2; // Añadimos el 2 en la posición 3
		System.out.println(Arrays.toString(nums)); // [15, 6, 9, 2, 12, 20] (posición insertada con éxito)
	}

	public static void ordenacionBurbuja() {
		int[] nums = { 15, 6, 9, 12, 20 };
		for (int i = 0; i < nums.length; i++) { // burbuja
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) { // Intercambiamos
					int aux = nums[i];
					nums[i] = nums[j];
					nums[j] = aux;
				}
			}
		}
		System.out.println(Arrays.toString(nums)); // [6, 9, 12, 15, 20] (Ordenados)
	}

	public static void ordenarArray() {

		/*
		 * Integer numero = 5; int numero2 = 8; int numero3 = 0; String cadena = "hola";
		 * numero3 = numero + numero2; String cadena5 = numero.toString(); // "5"
		 */

		Integer[] nums = { 15, 6, 9, 12, 20 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums, Collections.reverseOrder());
		System.out.println(Arrays.toString(nums));

		// a, á, A, Á
		String[] nombres = { "alejo", "Esther", "Álvaro", "Theodros", "Jhohar", "Antonella", "Julio", "Néstor",
				"Raúl" };
		Arrays.sort(nombres); // orden lexicográfico (normal) tiene en cuenta las mayúsculas y minúsculas,
								// acentos...
		System.out.println(Arrays.toString(nombres));
		Arrays.sort(nombres, Collections.reverseOrder()); // orden lexicográfico (normal) de mayor a menor
		System.out.println(Arrays.toString(nombres));
		Arrays.sort(nombres, String.CASE_INSENSITIVE_ORDER); // No tiene en cuenta las mayúsculas y minúsculas
		System.out.println(Arrays.toString(nombres));
		Arrays.sort(nombres, String.CASE_INSENSITIVE_ORDER.reversed()); // No tiene en cuenta las mayúsculas y
																		// minúsculas en orden inverso
		System.out.println(Arrays.toString(nombres));

		// Teniendo en cuenta el idioma español
		Collator comparador = Collator.getInstance(new Locale("es")); // teniendo en cuenta el idioma que queremos usar
		comparador.setStrength(Collator.PRIMARY);
		Arrays.sort(nombres, comparador); // de menor a mayor
		System.out.println(Arrays.toString(nombres));
		Arrays.sort(nombres, comparador.reversed()); // de mayor a menor
		System.out.println(Arrays.toString(nombres));

		// Ordenar por tamaño de la cadena
		Arrays.sort(nombres, Comparator.comparingInt(String::length)); // Tamaño de menor a mayor
		System.out.println(Arrays.toString(nombres));
		Arrays.sort(nombres, Comparator.comparingInt(String::length).reversed()); // Tamaño de mayor a menor
		System.out.println(Arrays.toString(nombres));

	}

	public static void matrices() {
		// int[][] array2D = new int[3][4]; // 3 filas de 4 columnas cada una
		int[][] array2D = { { 12, 3, 4 }, { 22, 36, 34 }, { 23, 65, 75 }, { 1, 4, 7 } }; // array de 4 x 3
		// asignar valores
		System.out.println(array2D[2][1]); // 65
		array2D[2][1] = 20; // 65 -> 20
		System.out.println(array2D[2][1]); // 20

		int[][] array2Descalonado = { { 1, 2, 3 }, { 4, 5, 6, 9 }, { 7 } }; // array del Ejemplo2
		// System.out.println(array2Descalonado[2][1]); // no existe esa posición

		// Recorrer matrices
		for (int i = 0; i < array2D.length; i++) {  // Cada fila de la matriz
			for (int j = 0; j < array2D[i].length; j++) {  // Cada columna de la matriz
				System.out.print(array2D[i][j] + " ");
			}
			System.out.println();
		}
		
		String[][] alumnos = {{"Fran","Luis","Pepe"},{"Paco","José"}};
		int[][] notas = {{10,2,5},{9,1}};
		notas[0][1] = 5;  // Cambio la nota de Luis
		for (int i = 0; i < alumnos.length; i++) {  // Cada fila de la matriz
			for (int j = 0; j < alumnos[i].length; j++) {  // Cada columna de la matriz
				System.out.println(alumnos[i][j] + " " + notas[i][j] + (notas[i][j]>=5?" Aprobado":" Suspenso") );
			}
		}
	}

	public static void main(String[] args) {
		// ejemplo1();
		// ejemplo1PF();
		// redimensionarArray();
		// aumentarDeUnoEnUno();
		// eliminarElementosArrayDesplazamiento();
		// eliminarElementosArray();
		// anyadirElementosArrayDesplazamiento();
		// anyadirElementosArray();
		// ordenacionBurbuja();
		// ordenarArray();
		// matrices();
		// System.out.println("Hola " + args[0] + " " + args[1]);
	}

}
