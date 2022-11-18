package contar;

public class Contador {
	int cont;
	
	public Contador() {
		cont=0;
	}
	public Contador(int cont) {
		this.cont=cont;
	}
	public Contador(Contador c) {
		cont=c.cont;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public void incrementar() {
		cont++;
	}
	
	public void decrementar() {
		if(cont>0)
			cont--;
	}
	
	
	

}
