package numerosComplejos;

public class NumeroComplejo {
	double real;
	double imaginaria;
	
	public NumeroComplejo(double real, double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}
	
	@Override
	public String toString() {
		return ""+real+ (imaginaria>0?"+":"")+imaginaria+"i";
	}
	
	public double getMagnitud() {
		return Math.sqrt(Math.pow(real, 2)+
				Math.pow(imaginaria, 2));
	}
	
	public static NumeroComplejo suma(NumeroComplejo n1,
									  NumeroComplejo n2) {
		return new NumeroComplejo(n1.real+n2.real,
								   n1.imaginaria+n2.imaginaria);
		
	}

}
