package com.fran.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App 
{
	
	public static final String URL ="jdbc:mysql://localhost:3306/eoi2";
	public static final String USUARIO = "root";
	public static final String PASSWORD = "";
	
	
	public static void listarEmpleados() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("Select * from empleados");
        	while(rs.next()) {  // recorre todas las filas de los resultados
        		System.out.println(rs.getString("nombre") + " tiene " + rs.getInt("edad") + " años");
        	}
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void listarEmpleadosPorAnyos() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el mínimo de años: ");
		int edad = Integer.parseInt(sc.nextLine());
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("Select * from empleados where edad>" + edad);
        	while(rs.next()) {  // recorre todas las filas de los resultados
        		System.out.println(rs.getString("nombre") + " tiene " + rs.getInt("edad") + " años");
        	}
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
	
	public static void listarCategorias() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("Select * from categorias");
        	while(rs.next()) {  // recorre todas las filas de los resultados
        		System.out.println(rs.getInt("categoria") + ": " + rs.getString("titulo") 
        		+ " salario: " + rs.getInt("salario") + " trienio: " + rs.getInt("trienio"));
        	}
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void gastosPorCategorias() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT categorias.categoria, categorias.titulo, sum(salario) as SumaSalarios from categorias,empleados WHERE categorias.categoria=empleados.categoria group by categorias.categoria, categorias.titulo");
        	while(rs.next()) {  // recorre todas las filas de los resultados
        		System.out.println(rs.getInt("categoria") + ": " + rs.getString("titulo") 
        		+ " Suma de los salarios: " + rs.getInt("SumaSalarios"));
        	}
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    public static void main( String[] args )
    {
        //listarEmpleados();
        //listarCategorias();
    	//listarEmpleadosPorAnyos();
    	gastosPorCategorias();
    }
}
