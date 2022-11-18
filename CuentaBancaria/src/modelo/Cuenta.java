package modelo;

public class Cuenta {
	String nombreCliente;
	String numero;
	double interes;
	double saldo;
	
	public Cuenta() {
		nombreCliente="";
		numero="";
		interes=0;
		saldo=0;
	}

	public Cuenta(String nombreCliente, String numero, double interes, double saldo) {
		super();
		this.nombreCliente = nombreCliente;
		this.numero = numero;
		this.interes = interes;
		this.saldo = saldo;
	}
	
	public Cuenta(Cuenta c) {
		this.nombreCliente=c.nombreCliente;
		this.numero=c.numero;
		this.interes=c.interes;
		this.saldo=c.saldo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean ingreso(double dinero) {
		boolean resultado=false;
		if(dinero>=0) {
			saldo+=dinero;
			resultado=true;
		}
		return resultado;
	}
	
	public boolean reintegro(double dinero) {
		boolean resultado=false;
		if(saldo>=dinero && dinero>=0) {
			saldo-=dinero;
			resultado=true;
		}
		return resultado;
	}
	
	public void transferencia(Cuenta destino,double dinero) {
		if(saldo>=dinero) {
			saldo-=dinero;
			destino.saldo+=dinero;
			System.out.println("Transferencia realizada de cuenta "+
			this.numero+ " a "+ destino.numero + "por "+ dinero+" importe");
		}
	}
	

}
