package main;

import modelo.Empresa;
import modelo.Persona;

public class ejercicios {
	
	public static void ejercicio12y3() {
		Persona persona=new Persona("Nacho","11111X",23);
		persona.setEdad(-12);
		//persona.saluda();
		Persona persona2=new Persona(persona);
		persona2.setNombre("Mari Chelo");
		persona.saluda();
		persona2.saluda();
		persona2=persona;
		persona2.setNombre("Juan");
		persona2.saluda();
		persona.saluda();
	}
	
	public static void ejercicio4y5() {
		Persona[] personas=new Persona[4];
		
		personas[0]=new Persona("Mari Chelo","11111X",3);
		personas[1]=new Persona("Nacho","22222M",15);
		personas[2]=new Persona("María","33333K",45);
		personas[3]=new Persona("Jesús","555555L",66);
		
		for(int i=0;i<personas.length;i++)
		{
			personas[i].saluda();
		}
		Persona[] personas2=Persona.copiaArray(personas);
		personas2[0].setNombre("José Miguel");
		for(int i=0;i<personas.length;i++) {
			personas[i].saluda();
			personas2[i].saluda();
		}
		Persona prueba=personas[0];
		prueba=new Persona();
		
		System.out.println(prueba.estoyEnArray(personas));
		
		
	}
	
	public static void ejerciciosEmpresa() {
		Empresa miEmpresa=new Empresa("Mari Chelo's");
		System.out.println("He creado la empresa "+ 
							miEmpresa.getNombre());
		Persona unaPersona=new Persona("Rafael","343434",34);
		miEmpresa.contrataEmpleado(unaPersona);
		miEmpresa.contrataEmpleado(
				new Persona("María","88787",24));
		miEmpresa.contrataEmpleado(new Persona("Lola","999",34));
		miEmpresa.mostrarEmpleados();
		
		miEmpresa.despideEmpleado("Lola");
		miEmpresa.mostrarEmpleados();
	}

	public static void main(String[] args) {
		//ejercicio12y3();
		//ejercicio4y5();
		ejerciciosEmpresa();
		
		

	}

}
