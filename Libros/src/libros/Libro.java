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
	
	

}
