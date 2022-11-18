package modelo;

public class Mesa {
	Pata pata;
	String material;
	double altura;
	double anchura;
	
	public Mesa() {
		pata=new Pata();
		material="";
		altura=0;
		anchura=0;
	}

	public Pata getPata() {
		return pata;
	}

	public void setPata(Pata pata) {
		this.pata = pata;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAnchura() {
		return anchura;
	}

	public void setAnchura(double anchura) {
		this.anchura = anchura;
	}
	
	@Override
	public String toString() {
		return "Mesa de "+material+" de "+altura+"m de altura y"+
				anchura+"m de anchura y pata de "+pata.toString();	
	}

}
