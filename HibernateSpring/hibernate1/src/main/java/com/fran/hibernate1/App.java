package com.fran.hibernate1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fran.hibernate1.entidades.Empleados;

public class App 
{
	
	static SessionFactory sessionFactory;
	static Session session;
		
	public static void probarConexion() {
		if(session!=null) {
			System.out.println("Sesión abierta correctamente");
		} else {
			System.out.println("Fallo al conectar con la base de datos");
		}
	}
	
    public static void abrirConexion() {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    	session = sessionFactory.openSession();
    }
    
    public static void cerrarConexion() {
    	if(session!=null) {
    		session.close();
    	}
    	if(sessionFactory!=null) {
    		sessionFactory.close();
    	}
    }
    
    public static void mostrarEmpleados() {
    	abrirConexion();
    	List<Empleados> empleados = (List<Empleados>) session.createQuery("From Empleados").list();
    	empleados.forEach(e->System.out.println(e));
    	cerrarConexion();
    }
    
    public static void mostrarEmpleadosQueEmpiecenPor(String comienzoCadena) {
    	abrirConexion();
    	List<Empleados> empleados = (List<Empleados>)session.createQuery("FROM Empleados WHERE nombre LIKE '" + comienzoCadena + "%'").list();
    	empleados.forEach(e->System.out.println(e));
    	cerrarConexion();
    }
    
    public static void anyadirEmpleados() {
    	abrirConexion();
    	Transaction trans = null;
    	try {
    		trans = session.beginTransaction();
    		Empleados empleadoAnyadir1 = new Empleados(10011,"Francisco García",45,100,1,new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-14"));
    		//Empleados empleadoAnyadir2 = new Empleados(10003,"Francisco García",45,100,1,new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-14"));
			session.save(empleadoAnyadir1);
			//session.save(empleadoAnyadir2);
			trans.commit();
			System.out.println("Empleado guardado en la base de datos correctamente.");
    	} catch (ParseException e) {
    		trans.rollback();
			e.printStackTrace();
		}   	
    	cerrarConexion();
    }
    
    public static void anyadirEmpleados(Empleados empleado) {
    	abrirConexion();
    	Transaction trans = null;
    	try {
    		trans = session.beginTransaction();
			session.save(empleado);
			trans.commit();
			System.out.println("Empleado guardado en la base de datos correctamente.");
    	} catch (Exception e) {
    		trans.rollback();
			e.printStackTrace();
		}   	
    	cerrarConexion();
    }
    
    public static void borrarEmpleados() {
    	Transaction trans = null;
    	int codigoMinimo = 10003;
    	abrirConexion();
    	try {			
			trans = session.beginTransaction();
			List<Empleados> empleadosABorrar = session.createQuery("FROM Empleados WHERE num>=" + codigoMinimo).list();
			empleadosABorrar.forEach(e->session.delete(e));
			trans.commit();
			System.out.println("Empleado/s borrado/s en la base de datos correctamente.");
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}   	
    	cerrarConexion();
    }
    
    public static void borrarUnEmpleado() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduzca el código a borrar: ");
    	int codigoBorrar = Integer.parseInt(sc.nextLine());
    	Transaction trans = null;
    	abrirConexion();
    	try {			
			trans = session.beginTransaction();
			List<Empleados> empleadosABorrar = session.createQuery("FROM Empleados WHERE num=" + codigoBorrar).list();
			empleadosABorrar.forEach(e->session.delete(e));
			trans.commit();
			System.out.println("Empleado/s borrado/s en la base de datos correctamente.");
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}   	
    	cerrarConexion();
    	sc.close();
    }
    
    public static void borrarGenerico(String clase, String nombreClavePrimaria, int codigoBorrar) {
    	Transaction trans = null;
    	abrirConexion();
    	try {			
			trans = session.beginTransaction();
			List<Object> empleadosABorrar = session.createQuery("FROM " + clase + " WHERE " + nombreClavePrimaria + "=" + codigoBorrar).list();
			empleadosABorrar.forEach(e->session.delete(e));
			trans.commit();
			System.out.println("Elemento borrado en la base de datos correctamente.");
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}   	
    	cerrarConexion();
    }
    
    public static void actualizar() {
    	Transaction trans = null;
    	int codigoActualizar = 10000;
    	abrirConexion();
    	try {			
			trans = session.beginTransaction();
			List<Empleados> empleadosActualizar = session.createQuery("FROM Empleados WHERE num=" + codigoActualizar).list();
			empleadosActualizar.forEach(e->{
				Empleados empleadoActualizar = e;
				//empleadoActualizar.setNum(10010);  // No actualizar clave primaria
				empleadoActualizar.setNombre("Nombre actualizado");
				empleadoActualizar.setEdad(20);
				session.update(empleadoActualizar);
			});
			trans.commit();
			if(empleadosActualizar.size()>0)
				System.out.println("Empleado actualizado en la base de datos correctamente.");
			else
				System.out.println("No se encontró el empleado");
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}   	
    	cerrarConexion();
    }
	
	public static void main( String[] args )
    {
		// Mostrar solo problemas de funcionamiento del programa
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    	//probarConexion();
		//mostrarEmpleados();
		//mostrarEmpleadosQueEmpiecenPor("A");
		//anyadirEmpleados();
		/*Empleados nuevo = null;
		try {
			nuevo = new Empleados(10011,"Francisco García",45,100,1,new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-14"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		anyadirEmpleados(nuevo);*/
		//borrarEmpleados();
		//borrarUnEmpleado();
		//borrarGenerico("Empleados","num",10001);
		//actualizar();
    }
}
