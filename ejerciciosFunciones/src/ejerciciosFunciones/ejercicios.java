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
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			dibujaAsteriscos(20);
			System.out.println();
		}
		
		int suma=suma(1,3)+suma(3,4);
		System.out.println(suma);
		
		longitudEntre("hola",2,8);
		longitudEntre("Hola que tal?",2,8);
		
		if(longitudEntre2("hola",2,8))
			System.out.println("Sí");
		if(longitudEntre2("Hola que tal?",2,8))
			System.out.println("Sí");		

	}

}
