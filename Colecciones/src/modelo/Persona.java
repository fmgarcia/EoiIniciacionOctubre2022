package modelo;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String dni;
	private int edad;
	private String telefono;
	
	public Persona() {
		this.nombre="";
		this.dni="";
		this.edad=0;
	}
	
	public Persona(String nombre) {
		this.nombre=nombre;
	}
	
	public Persona(String nombre,String dni,int edad) {
		this.nombre=nombre;
		this.dni=dni;
		this.edad=edad;
	}
	
	public Persona(String nombre,String dni,int edad,String telefono) {
		this(nombre,dni,edad);
		this.setTelefono(telefono);
		
	}
	
	public Persona(Persona p) {
		this.nombre=p.nombre;
		this.dni=p.dni;
		this.edad=p.edad;
	}
	
	
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad>=0)
			this.edad = edad;
	}
	
	public void saluda() {
		System.out.printf("%s tiene %d años\n",
				nombre,edad);
	}
	
	@Override
	public String toString() {
		return dni+": "+nombre+" "+edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public int compareTo(Persona o) {
		return Integer.compare(this.edad, o.edad);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
	

}
