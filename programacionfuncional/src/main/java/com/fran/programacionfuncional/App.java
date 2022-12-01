package com.fran.programacionfuncional;

import java.util.ArrayList;
import java.util.List;

import com.fran.programacionfuncional.entidades.Usuario;


public class App 
{
	
	static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void ejemplosConstructores() {
		Usuario fran = new Usuario();
        System.out.println(fran);
        fran.setId(10);
        fran.setNombre("Francisco García");
        System.out.println(fran);
        Usuario fran2 = new Usuario(fran);
        fran2.setId(1234);
        System.out.println(fran2);
        Usuario fran3 = new Usuario(15,"Fran","1234",1000);
        Usuario fran4 = new Usuario(15,"Fran","1234");
	}
	
	public static void cargarDatosIniciales() {  // tearUp
		usuarios.clear();  // vaciar una lista
		usuarios.add(new Usuario(1,"Fran","1234",1000.0));
		usuarios.add(new Usuario(2,"Antonella","1234",15000));
		usuarios.add(new Usuario(3,"Esther","1234",18000));
		usuarios.add(new Usuario(4,"Jhojar","1234",9000.50));
		usuarios.add(new Usuario(1,"Francisco","1234",-3000));
		usuarios.add(new Usuario(5,"Theodros","1234",1000.0));
		usuarios.add(new Usuario(6,"Néstor","1234",2000.0));
		usuarios.add(new Usuario(6,"Álvaro","1234",3000.0));
	}
	
	public static void forEach() {
		
		// 1. For clásico
		for(int i=0;i<usuarios.size();i++) {
			System.out.println(usuarios.get(i));
		}
		
		// 2. For-Each
		for(Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
		
		// Formas funcionales
		// 3. lambda
		usuarios.forEach(e->System.out.println(e));
		
		// 4. Método a aplicar
		usuarios.forEach(System.out::println);
		
		// 5. Uso de Stream
		usuarios.stream().forEach(e->System.out.println(e));
	}
	
    public static void main( String[] args )
    {
    	cargarDatosIniciales();
    	forEach();
    }
}
