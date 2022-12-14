package electrodomesticos;

import java.util.Scanner;

public class Main {
	
	public static void mostrarMenu() {
		System.out.println("--- INVENTARIO ELECTRODOMÉSTICOS ---");
		System.out.println("------------------------------------");
		System.out.println("1.- Crear nuevo electrodométicos");
		System.out.println("2.- Borrar electrodoméstico");
		System.out.println("3.- Modificar");
		System.out.println("4.- Mostrar gama ordenados por nombre");
		System.out.println("5.- Mostrar precio inferior");
		System.out.println("6.- Mostrar precio compra inferior");
		System.out.println("7.- Recalcular precios");
		System.out.println("8.- Añadir cantidad electrodoméstico");
		System.out.println("9.- Añadir cantidad por texto");
		System.out.println("S.- Salir");
		System.out.println();
		System.out.print("Introduzca una opción:");
	}
	
	public static void crear(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		String codigo,nombre,descripcion,cEnergetica;
		double precioVenta,precioCoste;
		int cantidad;
		String gama;
		System.out.print("Codigo: ");
		codigo=sc.nextLine();
		System.out.print("Nombre: ");
		nombre=sc.nextLine();
		System.out.print("Descripcion: ");
		descripcion=sc.nextLine();
		System.out.print("Precio de Coste: ");
		precioCoste=sc.nextDouble();
		System.out.print("Precio de Venta: ");
		precioVenta=sc.nextDouble();
		System.out.print("Categoría energética: ");
		cEnergetica=sc.next();
		System.out.print("Cantidad: ");
		cantidad=sc.nextInt();
		System.out.print("Gama:(G)ris (B)lanca (P)AE (M)arrón: ");
		gama=sc.next();
		switch(gama) {
		case "G":
			inventario.add(new Gris(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica,cantidad));
			break;
		case "B":
			inventario.add(new Blanca(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica,cantidad));
			break;
		case "P":
			inventario.add(new Pae(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica,cantidad));
			break;	
		case "M":
			inventario.add(new Marron(codigo,nombre,descripcion,
									precioCoste,precioVenta,cEnergetica,cantidad));
			break;
			default:
				System.out.println("Gama incorrecta");
				break;
		}		
	}
	
	public static void borrar(Inventario inventario) {
		Scanner sc =new Scanner(System.in);
		String codigo;
		System.out.print("Introduzca código a borrar");
		codigo=sc.next();
		inventario.borrar(codigo);
		
	}
	
	public static void modificar(Inventario inventario) {
		Scanner sc =new Scanner(System.in);
		String codigo,nombre,descripcion,cEnergetica;
		String texto;
	
		System.out.print("Introduzca código a modificar");
		codigo=sc.nextLine();
		Electrod elemento=inventario.getElemento(codigo);
		System.out.printf("Nombre: %s\n",elemento.getNombre());
		System.out.print("Nuevo nombre:");
		nombre=sc.nextLine();
		if(nombre.length()>0)
			elemento.setNombre(nombre);
		System.out.printf("Descripcion: %s\n",elemento.getDescripcion());
		System.out.print("Nuevo descripción:");
		descripcion=sc.nextLine();
		if(descripcion.length()>0)
			elemento.setDescripcion(descripcion);
		System.out.printf("Categoría energética: %s\n",elemento.getcEnergetica());
		System.out.print("Nuevo categoría energética:");
		cEnergetica=sc.nextLine();
		if(cEnergetica.length()>0)
			elemento.setcEnergetica(cEnergetica);
		System.out.printf("Precio de Coste: %s\n",elemento.getPrecioCompra());
		System.out.print("Nuevo precio de Coste:");
		texto=sc.nextLine();
		if(texto.length()>0)
			elemento.setPrecioCompra(Double.parseDouble(texto));
		System.out.printf("Precio de Venta: %s\n",elemento.getPrecioVenta());
		System.out.print("Nuevo precio de Venta:");
		texto=sc.nextLine();
		if(texto.length()>0)
			elemento.setPrecioVenta(Double.parseDouble(texto));	
		System.out.printf("Cantidad: %s\n",elemento.getCantidad());
		System.out.print("Nueva cantidad:");
		texto=sc.nextLine();
		if(texto.length()>0)
			elemento.setCantidad(Integer.parseInt(texto));	
	}
	
	public static void mostrarGamaNombre(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		Electrod elemento;
		System.out.print("Gama:(G)ris (B)lanca (P)AE (M)arrón:");
		String gama=sc.nextLine();
		inventario.mostrarGamaNombre(gama);
		
	}
	
	public static void mostrarPrecioInferiorOrdenado(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Precio de Venta:");
		double precio=sc.nextDouble();
		inventario.mostrarPrecioVentaInferior(precio);
	}
	
	public static void mostrarPrecioCompraInferior(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Precio de Compra:");
		double precio=sc.nextDouble();
		inventario.mostrarPrecioCompraInferior(precio);
	}
	
	public static void recalculaPrecios(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Texto:");
		String texto=sc.nextLine();
		System.out.print("Porcentaje:");
		double porcentaje=sc.nextDouble();
		inventario.recalculaPrecio(texto, porcentaje);
		
	}
	public static void addCantidad(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Código");
		String codigo=sc.nextLine();
		System.out.print("Cantidad:");
		int cantidad=sc.nextInt();
		inventario.addCantidad(cantidad, codigo);
		
	}
	public static void addCantidadTexto(Inventario inventario) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Texto");
		String texto=sc.nextLine();
		System.out.print("Cantidad:");
		int cantidad=sc.nextInt();
		inventario.addCantidadTexto(cantidad, texto);
		
	}

	public static void main(String[] args) {
		Inventario inventario=new Inventario();
		Scanner sc=new Scanner(System.in);
	//	System.out.println(inventario);
		boolean salir=false;
		String opcion;
		while(!salir) {
		//	System.out.println(inventario);
			mostrarMenu();
			opcion=sc.next();
			switch(opcion) {
			case "1":
				crear(inventario);
				break;
			case "2":
				borrar(inventario);
				break;
			case "3":
				modificar(inventario);
				break;
			case "4":
				mostrarGamaNombre(inventario);
				break;
			case "5":
				mostrarPrecioInferiorOrdenado(inventario);
				break;
			case "6":
				mostrarPrecioCompraInferior(inventario);
				break;
			case "7":
				recalculaPrecios(inventario);
				break;
			case "8":
				addCantidad(inventario);
				break;
			case "9":
				addCantidadTexto(inventario);
				break;
			case "S":
				salir=true;
				inventario.guardar();
				break;
			}
		}

	}

}
