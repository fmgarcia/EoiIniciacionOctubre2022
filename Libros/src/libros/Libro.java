package libros;

public class Libro {
	String titulo;
	String autor;
	int ejemplares;
	int ejemplaresPrestados;
	
	public Libro() {
		titulo="";
		autor="";
		ejemplares=0;
		ejemplaresPrestados=0;
	}

	public Libro(String titulo, String autor, int ejemplares, int ejemplaresPrestados) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.ejemplaresPrestados = ejemplaresPrestados;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	public int getEjemplaresPrestados() {
		return ejemplaresPrestados;
	}

	public void setEjemplaresPrestados(int ejemplaresPrestados) {
		this.ejemplaresPrestados = ejemplaresPrestados;
	}
	
	public boolean prestamo() {
		boolean resultado=false;
		if(ejemplares>ejemplaresPrestados)
		{
			ejemplaresPrestados++;
			resultado=true;
		}
		return resultado;
	}
	
	public boolean devolucion() {
		boolean resultado=false;
		if(ejemplaresPrestados>0) {
			ejemplaresPrestados--;
			resultado=true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ejemplares=" + ejemplares + ", ejemplaresPrestados="
				+ ejemplaresPrestados + "]";
	}
	
	

}
