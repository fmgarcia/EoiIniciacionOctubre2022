package main;

import java.util.Scanner;

import modelo.Aspirador;
import modelo.Calefaccion;
import modelo.Dispositivo;
import modelo.Horno;
import modelo.IEncenderApagar;
import modelo.ISubirBajar;
import modelo.Luz;
import modelo.Persiana;
import modelo.Puerta;
import modelo.PuertaDeGaraje;
import modelo.Toldo;
import modelo.Ventana;

public class SistemaDomotico {

	public static Dispositivo[] rellenaDispositivos() {
		Dispositivo[] dispositivos=new Dispositivo[10];
		dispositivos[0]=new Ventana(new Persiana(10));
		dispositivos[0].setNombre("Ventana comedor 1");
		((Ventana)dispositivos[0]).
					getPersiana().setNombre("Persiana 1");
		dispositivos[1]=new Ventana(new Persiana(0));
		dispositivos[1].setNombre("Ventana comedor 2");
		((Ventana)dispositivos[1]).
					getPersiana().setNombre("Persiana 2");
		dispositivos[2]=new Puerta(false);
		dispositivos[2].setNombre("Puerta de entrada");
		dispositivos[3]=new PuertaDeGaraje(false);
		dispositivos[3].setNombre("Puerta del garaje");
		((PuertaDeGaraje)dispositivos[3]).subir();
		dispositivos[4]=new Luz(true);
		dispositivos[4].setNombre("Luz del comedor");
		dispositivos[5]=new Calefaccion(24);
		dispositivos[5].setNombre("Calefacción planta 1");
		dispositivos[6]=new Horno(200);
		dispositivos[6].setNombre("Horno");
		dispositivos[7]=new Aspirador(100,false);
		dispositivos[7].setNombre("Aspirador");
		dispositivos[8]=new Calefaccion(20);
		dispositivos[8].setNombre("Calefaccion dormitorio");
		dispositivos[9]=new Toldo(20);
		dispositivos[9].setNombre("Toldo comedor");
		return dispositivos;
		
		
	}
	public static String opcionMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("**Control de casa**");
		System.out.println("1.- Subir todas las persianas");
		System.out.println("2.- Encender todo");
		System.out.println("3.- Encender las calefacciones y ponerlas a 23 grados");
		System.out.println("4.- Bloquear todas la puertas");
		System.out.println("5.- Mostrar dispositivos");
		System.out.println("6.- Bajar todo");
		System.out.println("7.- Encender aspiradores");
		System.out.println("S.- Salir");
		System.out.println();
		System.out.print("Introduzca una opcion:");
		return sc.next().toUpperCase();
		
		
	}
	
	public static void mostrarDispositivos(Dispositivo[] dispositivos) {
		for(Dispositivo d:dispositivos) {
			System.out.println(d);
		}
	}
	
	public static void subirPersianas(Dispositivo[] dispositivos) {
		for(Dispositivo d:dispositivos) {
			if(d instanceof Ventana) {
				((Ventana)d).getPersiana().subir();
			}
		}
	}
	
	public static void encenderTodo(Dispositivo[] dispositivos) {
		for(Dispositivo d:dispositivos) {
			if(d instanceof IEncenderApagar) {
				((IEncenderApagar)d).encender();
			}
		}
		
	}
	
	public static void encenderCalefaccion(Dispositivo[] dispositivos) {
		for(Dispositivo d:dispositivos) {
			if(d instanceof Calefaccion) {
				((Calefaccion)d).encender();
				((Calefaccion)d).setTemperatura(23);
			}
		}
	}
	
	public static void bloquearTodasLasPuertas(Dispositivo[] dispositivos) {
		for(Dispositivo d:dispositivos) {
			if(d instanceof Puerta &&
					!(d instanceof PuertaDeGaraje)) {
				((Puerta)d).bloquear();
			}
		}
	}
	
	public static void bajarTodo(Dispositivo[] dispositivos) {
		for(Dispositivo d: dispositivos) {
			if(d instanceof ISubirBajar) {
				((ISubirBajar)d).bajar();
			}
			else if(d instanceof Ventana) {
				((Ventana)d).getPersiana().bajar();
			}
		}
	}
	public static void encenderAspirador(Dispositivo[] dispositivos) {
		for(Dispositivo d: dispositivos) {
			if(d instanceof Aspirador) {
				if(((Aspirador)d).getBateria()>=50) {
					((Aspirador)d).encender();
				}
			}
		}
	
	}
	
	public static void main(String[] args) {
		Dispositivo[] dispositivos=rellenaDispositivos();
		String opcion;
		boolean salir=false;
		while(!salir) {
			opcion=opcionMenu();
			switch (opcion){
			case "1":
				subirPersianas(dispositivos);
				break;
			case "2":
				encenderTodo(dispositivos);
				break;
			case "3":
				encenderCalefaccion(dispositivos);
			case "4":
				bloquearTodasLasPuertas(dispositivos);
			case "5":
				mostrarDispositivos(dispositivos);
				break;
			case "6":
				bajarTodo(dispositivos);
				break;
			case "7":
				encenderAspirador(dispositivos);
				break;
			case "S":
				salir=true;
				break;
			}
		}
		
		
		
		

	}

}
