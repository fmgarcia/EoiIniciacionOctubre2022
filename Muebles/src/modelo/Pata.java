package modelo;

public class Pata {
	String color;
	String material;
	
	public Pata() {
		color="marrón";
		material="madera";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	@Override
	public String toString() {
		return material+ " "+color+"\n";
	}

}
