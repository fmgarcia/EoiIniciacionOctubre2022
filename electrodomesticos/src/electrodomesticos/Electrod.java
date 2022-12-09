package electrodomesticos;

public abstract class Electrod {
	String codigo;
	String nombre;
	String descripcion;
	double precioCompra;
	double precioVenta;
	String cEnergetica;
	
	public Electrod(String codigo, String nombre, String descripcion, double precioCompra, double precioVenta,
			String cEnergetica) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cEnergetica = cEnergetica;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getcEnergetica() {
		return cEnergetica;
	}

	public void setcEnergetica(String cEnergetica) {
		this.cEnergetica = cEnergetica;
	}
	
	@Override
	public String toString() {
			return 
					String.format("%-10s: %-20s - %-30s -> %6.2f %6.2f %-6s",codigo,nombre,
									descripcion,precioCompra,precioVenta,cEnergetica);
	}

}
