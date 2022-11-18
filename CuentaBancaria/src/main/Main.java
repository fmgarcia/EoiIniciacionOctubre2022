package main;

import modelo.Cuenta;

public class Main {

	public static void main(String[] args) {
		Cuenta miCuenta=new Cuenta("Mari Chelo",
						"1234567890",2,3000);
		
		miCuenta.ingreso(1200);
		
		miCuenta.ingreso(-100);
		miCuenta.reintegro(2000);
		miCuenta.reintegro(-100);
		System.out.println(miCuenta.reintegro(3000));
		System.out.println(miCuenta.getSaldo());
		
		Cuenta otraCuenta=new Cuenta("Jesús","0987654321",2,5000);
		
		miCuenta.transferencia(otraCuenta, 2500);
		System.out.println(miCuenta.getSaldo());
		System.out.println(otraCuenta.getSaldo());
	}

}
