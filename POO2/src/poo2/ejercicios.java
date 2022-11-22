package poo2;

import modelo.Direccion;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Persona;
import modelo.TiendaLicores;

public class ejercicios {
	
	public static void ejercicio1y2() {
		TiendaLicores tienda=new TiendaLicores();
		tienda.bienvenida();
		
	}
	public static void ejercicio3() {
		Persona[] personas=new Persona[4];
		personas[0]=new Persona("Mari Chelo","22222",22);
		personas[1]=new Persona("Silvia","55555",55);
		personas[2]=new Persona("Mateo","33333",33);
		personas[3]=new Persona("Lidia","8888",88);
		
		Persona copia=new Persona(personas[3]);
		copia.setNombre("Jesús");
		for(int i=0;i<personas.length;i++) {
			if(personas[i].equals(copia)) {
				System.out.println("Encontrada en posición "+i);
				System.out.println(personas[i]);
				System.out.println(copia);
			}
		}
		
		
		
	}
	
	public static void ejercicio4() {
		Empresa empresa=new Empresa("Mari Chelo's",
				new Direccion("mateo el sabio",3),5);
		
		empresa.contrataEmpleado(new Empleado("Jesús",3000));
		empresa.contrataEmpleado(new Empleado("Mario",2000));
		empresa.contrataEmpleado(new Empleado("Lucía",5000));
		
		Empresa empresa2=new Empresa(empresa);
		
		empresa2.setDireccion(new Direccion("mayor",4));
		
		empresa2.getDireccion().setCalle("Romero");
		
		empresa2.setNombre("Otra empresa");
		
		empresa2.getEmpleado(0).setNombre("Lorenzo");
		System.out.println("Empresa:" + empresa.getNombre()+" "+empresa.getDireccion());
		empresa.mostrarEmpleados();
		System.out.println("Empresa:" + empresa2.getNombre()+" "+empresa2.getDireccion());
		empresa2.mostrarEmpleados();
		
		
		
	}

	public static void main(String[] args) {
		//ejercicio1y2();
		//ejercicio3();
		ejercicio4();
		
	}

}
