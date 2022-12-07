package modelo;

public class CuentoDeHadas {

	String titulo;
	int numPaginas;
	
	public CuentoDeHadas(String titulo, int numPaginas) {
		super();
		this.titulo = titulo;
		this.numPaginas = numPaginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CuentoDeHadas))
			return false;
		CuentoDeHadas other = (CuentoDeHadas) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CuentoDeHadas [titulo=" + titulo + ", numPaginas=" + numPaginas + "]";
	}
	
	

}
