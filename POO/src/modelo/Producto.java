package modelo;

public class Producto {
	String nombre;
	double precio;
	public static int productosCreados=0;
	
	public Producto(String nombre,double precio) {
		this.nombre=nombre;
		this.precio=precio;
		productosCreados++;
		
	}
	
	public Producto(Producto p) {
		this.nombre=p.nombre;
		this.precio=p.precio;
		productosCreados++;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecioImpuesto(double impuesto) {
		return precio * (1+impuesto);
	}

}
