package main;

import modelo.Cuadrado;
import modelo.Persona;
import modelo.Producto;

public class Ejemplos {

	public static void main(String[] args) {
	/*	Persona p=new Persona();
		p.setNombre("Pedro");
		p.setDni("11111X");
		p.setEdad(25);
		Persona p2=new Persona();
		p2.setNombre("María");
		p2.setDni("22222X");
		p2.setEdad(26);
		System.out.println("Persona:"+ p.getNombre()+" "+p.getDni());
		System.out.println("Persona:"+p2.getNombre() +" "+p2.getDni());
		*/
		Cuadrado cuadrado=new Cuadrado(4.5);
		cuadrado.setLado(4.5);
		System.out.println("Cuadrado de lado:"+cuadrado.getLado());
		Cuadrado cuadrado2=new Cuadrado(3);
		System.out.println(""
				+ "Cuadrado de lado:"+cuadrado2.getLado()+
				" su área es: "+cuadrado2.getArea());
		Cuadrado.CalcularArea();
		cuadrado.CalcularArea();
		
		Producto producto=new Producto("Silla",45.90);
		System.out.printf("Producto: %s vale %.2f total: %.2f\n",
						producto.getNombre(),producto.getPrecio(),
						producto.getPrecioImpuesto(0.21));
		//Producto otroProducto=producto;
		Producto otroProducto=new Producto(producto);
		otroProducto.setNombre("Mesa");
		System.out.printf("Producto: %s vale %.2f total: %.2f\n",
				producto.getNombre(),producto.getPrecio(),
				producto.getPrecioImpuesto(0.21));
		System.out.printf("Producto: %s vale %.2f total: %.2f\n",
				otroProducto.getNombre(),otroProducto.getPrecio(),
				otroProducto.getPrecioImpuesto(0.21));
		
		System.out.println("Productos: "+Producto.productosCreados);
		System.out.println(producto.productosCreados);
		producto.productosCreados=0;
		System.out.println("Productos: "+Producto.productosCreados);
		
		
		

	}

}
