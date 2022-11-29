package modelo;

public class Tarea {
	private String descripcion; 
	private boolean acabada;
	
	public Tarea(String descripcion) { 
		this.descripcion = descripcion;
		this.acabada = false; 
	}
	public boolean isAcabada() { 
		return acabada;
	}
	public void setAcabada(boolean acabada) {
		this.acabada = acabada; 
		}
	@Override
	public String toString() {
		return descripcion + " (" + 
				(acabada? "finalizada" : "pendiente") + ")"; 
	}

}
