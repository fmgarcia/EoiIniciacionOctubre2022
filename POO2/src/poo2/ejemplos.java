package poo2;

import modelo.Animal;
import modelo.Ave;
import modelo.Mamifero;

public class ejemplos {

	public static void main(String[] args) {
		Animal miAnimal=new Animal();
		miAnimal.comer();
		
		Ave miGallina=new Ave(false,1,"Turuleta");
		miGallina.comer();
		miGallina.comer();
		miGallina.ponerHuevos();
		
		System.out.println(miGallina.getNombre());
		
		Mamifero perro=new Mamifero("Toby",20,true);
		perro.comer();
		
		Mamifero leon = new Mamifero("León", 210, true); 
		//Mamifero leon2=leon;
		Mamifero leon2= new Mamifero("León", 210, true); 
		if(leon ==leon2)
			System.out.println("Son el mismo objeto (referencia)"); 
		else
			System.out.println("No son el mismo objeto (referencia)");
		if(leon.equals(leon2)) 
				System.out.println("Son iguales");
			else
				System.out.println("No son iguales");
		
	}

}
