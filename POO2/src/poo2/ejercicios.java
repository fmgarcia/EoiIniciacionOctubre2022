package poo2;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Direccion;
import modelo.Empleado;
import modelo.Empresa;
import modelo.Figura;
import modelo.IFigura;
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
	
	/*public static void ejercicio5() {
		Figura[] figuras=new Figura[3];
		figuras[0]=new Circulo(2.4);
		figuras[1]=new Cuadrado(2.3);
		figuras[2]=new Cuadrado(4.7);
		for(Figura f:figuras) {
			System.out.println(f.getArea()+" "+f.getPerimetro());
		}
	}*/
	
	public static void ejercicio6y7() {
		IFigura[] figuras=new IFigura[3];
		figuras[0]=new Circulo(2.4);
		figuras[1]=new Cuadrado(2.3);
		figuras[2]=new Cuadrado(4.7);
		for(IFigura f:figuras) {
			System.out.println(
					"Área: "+f.getArea()+" Perímetro: "+f.getPerimetro());
		}
	}
	public static void ejercicio8() {
		IFigura[] figuras=new IFigura[4];
		figuras[0]=new Circulo(2.4);
		figuras[1]=new Cuadrado(2.3);
		figuras[2]=new Cuadrado(4.7);
		figuras[3]=new Circulo(6.9);
		for(IFigura f:figuras) {
			if(f instanceof Circulo)
				System.out.printf("***Círculo - Radio: %.2f\n",((Circulo)f).getRadio());
			else if (f instanceof Cuadrado)
				System.out.printf("***Cuadrado - Lado: %.2f\n",((Cuadrado)f).getLado());
						
			System.out.printf("Área: %.2f Perímetro: %.2f\n",f.getArea(),f.getPerimetro());
		}
	}
	

	public static void main(String[] args) {
		//ejercicio1y2();
		//ejercicio3();
		//ejercicio4();
		//ejercicio5();
		//ejercicio6y7();
		ejercicio8();
		
	}

}
