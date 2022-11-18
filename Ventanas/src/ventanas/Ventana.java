package ventanas;

public class Ventana {
	int anchura;
	int altura;
	
	public Ventana(int anchura,int altura) {
		this.anchura=anchura;
		this.altura=altura;
	}
	
	public void mostrar() {
		System.out.printf("Ventana de %d anchura "
				+ "y %d altura\n",anchura,altura);
	}

}
