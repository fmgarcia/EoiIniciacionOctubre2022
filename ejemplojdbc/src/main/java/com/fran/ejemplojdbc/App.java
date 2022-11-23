package com.fran.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
	
	public static final String URL ="jdbc:mysql://localhost:3306/eoi2";
	public static final String USUARIO = "root";
	public static final String PASSWORD = "";
	
	
    public static void main( String[] args )
    {
        try {
			Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			if(con!=null) {
				System.out.println("Conexión correcta");
			}
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
