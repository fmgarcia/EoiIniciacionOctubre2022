package com.fran.hibernate1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
			session.save(new Empleados(10001,"Francisco García",45,100,1,new SimpleDateFormat("yyyy-MM-dd").parse("2000-12-14")));
			trans.commit();
			System.out.println("Empleado guardado en la base de datos correctamente.");
    	} catch (ParseException e) {
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
		anyadirEmpleados();
    }
}
