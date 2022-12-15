package modelo;

public class Alimento extends ElementoDeMenu{
	String frecuencia;
	double calorias;
	double carbohidratos;
	double grasas;
	boolean gluten;
	boolean huevos;
	boolean frutosSecos;
	boolean leche;
	
	public Alimento(String nombre, String descripcion, String frecuencia, double calorias, double carbohidratos,
			double grasas, boolean gluten, boolean huevos, boolean frutosSecos, boolean leche) {
		super(nombre, descripcion);
		this.frecuencia = frecuencia;
		this.calorias = calorias;
		this.carbohidratos = carbohidratos;
		this.grasas = grasas;
		this.gluten = gluten;
		this.huevos = huevos;
		this.frutosSecos = frutosSecos;
		this.leche = leche;
		
		
	}
	
	public Alimento(String nombre) {
		this(nombre,"","",0,0,0,false,false,false,false);
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

	public double getGrasas() {
		return grasas;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public boolean tieneGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean tieneHuevos() {
		return huevos;
	}

	public void setHuevos(boolean huevos) {
		this.huevos = huevos;
	}

	public boolean tieneFrutosSecos() {
		return frutosSecos;
	}

	public void setFrutosSecos(boolean frutosSecos) {
		this.frutosSecos = frutosSecos;
	}

	public boolean tieneLeche() {
		return leche;
	}

	public void setLeche(boolean leche) {
		this.leche = leche;
	}
	
	@Override 
	public String toString() {
		return super.toString()+" "+calorias+" "+carbohidratos+" "+grasas+
				(frutosSecos?"F ":" ")+ (leche?"L ":" ")+ (huevos?"H ":" ")+
				(gluten?"G ":" ");
	}
	
}
