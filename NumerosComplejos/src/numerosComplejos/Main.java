package numerosComplejos;

public class Main {

	public static void main(String[] args) {
		NumeroComplejo miNumero=
				new NumeroComplejo(3,-2);
		NumeroComplejo otroNumero=
				new NumeroComplejo(4,9);
		NumeroComplejo resultado=
				NumeroComplejo.suma(miNumero, otroNumero);
		
		
		System.out.println(resultado);
		
		
	}

}
