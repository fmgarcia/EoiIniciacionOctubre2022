package poo2;

import modelo.Animal;
import modelo.Ave;
import modelo.Gallina;
import modelo.Mamifero;
import modelo.Perro;
import modelo.Persona;

public class ejemplos {

	public static void main(String[] args) {
		//Animal miAnimal=new Animal();
	//	miAnimal.comer();
		
	/*	Ave miGallina=new Gallina(false,1,"Turuleta");
		miGallina.comer();
		miGallina.comer();
		miGallina.ponerHuevos();
		
		System.out.println(miGallina.getNombre());
		
		Mamifero perro=new Perro("Toby",20,true,"Pastor Alemán");
		perro.comer();
		
		Mamifero leon = new Perro("León", 210, true,"Mastín"); 
		//Mamifero leon2=leon;
		Mamifero leon2= new Perro("León", 210, true,"Labrador"); 
		if(leon ==leon2)
			System.out.println("Son el mismo objeto (referencia)"); 
		else
			System.out.println("No son el mismo objeto (referencia)");
		if(leon.equals(leon2)) 
				System.out.println("Son iguales");
			else
				System.out.println("No son iguales");
		
	}
	*/
	
	Animal miAnimal=new Perro("Toby2",20,true,"Pastor Alemán");
	
	Animal[] misAnimales=new Animal[3];
	misAnimales[0]=new Perro("Toby3",20,true,"Pastor Alemán");
	misAnimales[1]=new Gallina(false,1,"Turuleta");
	misAnimales[2]=new Gallina(false,1,"Turuleta2");
	
	for(int i=0;i<misAnimales.length;i++) {
		System.out.println(misAnimales[i].tipoAnimal());
		misAnimales[i].hablar();
		if(misAnimales[i] instanceof Perro) {
			misAnimales[i].comer();
			((Perro)misAnimales[i]).ladrar();		
		}
		
	}
	Persona p=new Persona();
	p.hablar();
	
	IHablador[] hablantes=new IHablador[3];
	hablantes[0]=new Persona();
	hablantes[1]=new Perro("Toby2",20,true,"Pastor Alemán");
	hablantes[2]=new Gallina(false,1,"Turuleta2");
	for(IHablador h:hablantes) {
		h.hablar();
	}
	
	}
}
