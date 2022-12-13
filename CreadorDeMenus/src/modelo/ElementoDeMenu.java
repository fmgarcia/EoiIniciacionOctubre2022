package modelo;

public abstract class ElementoDeMenu {
	String nombre;
	String descripcion;
	
	public ElementoDeMenu(){
		this("","");
	}
	
	public ElementoDeMenu(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	
	@Override
	public String toString() {
		return nombre+" "+descripcion;
		
	}
	
	abstract double getCalorias();
	abstract double getGrasas();
	abstract double getCarbohidratos();
	abstract boolean tieneLeche();
	abstract boolean tieneFrutosSecos();
	abstract boolean tieneGluten();
	abstract boolean tieneHuevos();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ElementoDeMenu))
			return false;
		ElementoDeMenu other = (ElementoDeMenu) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
}
