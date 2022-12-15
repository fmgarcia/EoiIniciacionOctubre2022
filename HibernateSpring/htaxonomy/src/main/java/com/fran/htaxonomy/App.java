package com.fran.htaxonomy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fran.htaxonomy.entidades.Family;
import com.fran.htaxonomy.entidades.Species;

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
    
    public static void mostrarSpecies() {
    	abrirConexion();
    	List<Species> species = (List<Species>) session.createQuery("From Species").list();
    	species.forEach(e->System.out.println(e));
    	cerrarConexion();
    }
    
    public static void mostrarFamilias() {
    	abrirConexion();
    	List<Family> families = (List<Family>) session.createQuery("From Family").list();
    	families.forEach(e->System.out.println(e));
    	cerrarConexion();
    }
	
	
    public static void main( String[] args )
    {
    	Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    	//mostrarSpecies();
    	mostrarFamilias();
    }
}
