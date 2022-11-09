package ejerciciosFunciones;

public class ejercicios {

	public static void dibujaAsteriscos(int cuantos)
	{
		for(int i=0;i<cuantos;i++)
		{
			System.out.print("*");
		}
	}
	
	public static void longitudEntre(String cadena,int valor1,int valor2) {
		System.out.println(cadena.length()>=valor1 && cadena.length()<=valor2?
					"La longitud está entre "+ valor1 +" y "+valor2:
						"La longitud no está entre "+ valor1 + " y "+ valor2);
	}
	
	public static boolean longitudEntre2(String cadena,int valor1,int valor2) {
		return cadena.length()>=valor1 && cadena.length()<=valor2;
	}
	
	public static int suma(int n1,int n2)
	{
		return n1+n2;
	}
	
	/**
	 * Crea una función que reciba un carácter y un número, dibuja un cuadrado usando
	 * ese carácter cuyo ancho y alto sea igual al número recibido. Prueba la función.
	 *
	 * @param c el caracter del que pintará el cuadrado
	 * @param n el ancho y alto del cuadrado
	 */	 
	public static void dibujaCuadrado(char c,int n)
	{
		for(int fila=0;fila<n;fila++)
		{
			for(int columna=0;columna<n;columna++)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void mostrarTrabajos(String nombre,String ...tareas)
	{
		System.out.println(nombre+":");
		if(tareas.length==0)
		{
			System.out.println("Esta persona no ha trabajado nunca");
		}
		else
		{
			for(int i=0;i<tareas.length;i++)
			{
				System.out.println(tareas[i]);
			}
		}
	}
	
	public static boolean esPrimo(int numero)
	{
		boolean primo=true;
		for(int i=2;i<numero && primo;i++)
		{
			if(numero%i==0)
				primo=false;
		}
		return primo;
	}
	
	public static void main(String[] args) {
		
		// suma(7,9);  // No da fallo pero no tiene sentido
		//int sumaValores = suma(7,9);  // int sumaValores = 16;
		//System.out.println(suma(7,9));  // System.out.println(16);
		
		// Ejercicio 3
		// dibujaCuadrado('*',7);  // pinta un cuadrado de 7X7 asteriscos
		
		// Ejercicio 5
		/*
		if(esPrimo(7))
		{
			System.out.println("Es primo");
		}
		
		System.out.println(esPrimo(9)?"Es primo":"No es primo");
		*/
		
		
	}

}
