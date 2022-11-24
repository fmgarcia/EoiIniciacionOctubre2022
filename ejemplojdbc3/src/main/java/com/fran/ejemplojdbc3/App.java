package com.fran.ejemplojdbc3;

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
	
	
	public static void consultaSql30() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
			int trieniosTotales = 0;
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT categorias.categoria, categorias.titulo, SUM(TRUNCATE(TIMESTAMPDIFF(YEAR, empleados.contrato, CURRENT_DATE())/3, 0)) AS trienios FROM empleados, categorias WHERE empleados.categoria=categorias.categoria GROUP BY categorias.categoria, categorias.titulo HAVING trienios>30 ORDER BY trienios DESC");
        	System.out.println("Categoria              Título   Trienios");
        	String formateo = "%9d%20s%11d\n";
        	while(rs.next()) {  // recorre todas las filas de los resultados
        		//System.out.println(rs.getInt("categoria") + "  " + rs.getString("titulo") + "   " + rs.getInt("trienios"));
        		System.out.printf(formateo,rs.getInt("categoria"),rs.getString("titulo"),rs.getInt("trienios"));
        		trieniosTotales += rs.getInt("trienios");
        	}
        	
        	System.out.println("Los trienios totales son: " + trieniosTotales);
			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void consultaSql31() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
	    {
	    	Statement st = con.createStatement();
	    	ResultSet rs = st.executeQuery("select dep.DEPTNO, dep.nombre, count(*) AS numeroEmpleados from DEPARTAMENTOS dep, DPTOFICINAS dpof, empleados emp where dep.deptno = dpof.departamento and dpof.codigo = emp.departamento group by dep.DEPTNO, dep.nombre having count(*) >5");
	    	while(rs.next()) { // recorre todas las filas de los resultados
	    		System.out.println(rs.getString("nombre") + " " + rs.getInt("numeroEmpleados"));
	    	}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void consultaSql32() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT empleados.nombre, categorias.salario FROM empleados, categorias WHERE empleados.categoria=categorias.categoria AND categorias.salario<(SELECT avg(categorias.salario) as MediaSalarios FROM empleados,categorias where empleados.categoria=categorias.categoria)");
        	System.out.println("Fila Nombre                 Salario");
        	String formateo = "%-5d%-20s%10d\n";
        	while(rs.next()) {  // recorre todas las filas de los resultados
        		System.out.printf(formateo,rs.getRow(),rs.getString("nombre"),rs.getInt("salario"));
        	}			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ejemploInsert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el código de la categoría: ");
		int categoria = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca el título de la categoría: ");
		String titulo = sc.nextLine();
		System.out.println("Introduzca el salario de la categoría: ");
		int salario = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca el trienio de la categoría: ");
		int trienio = Integer.parseInt(sc.nextLine());
				
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	String sql = "INSERT INTO categorias VALUES (" + categoria + ", '" + titulo + "', " + salario + ", " + trienio + ")";
        	System.out.println(sql);
        	int filasInsertadas = st.executeUpdate(sql);
        	System.out.println("Se ha insertado " + filasInsertadas + (filasInsertadas==1?"fila":"filas") );    				
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
	
	public static void ejemploDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el código de la categoría a borrar: ");
		int categoria = Integer.parseInt(sc.nextLine());
		
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
		{
			Statement st = con.createStatement();
			String sql = "DELETE FROM categorias WHERE categoria = " + categoria;
			System.out.println(sql);
			int filasBorradas = st.executeUpdate(sql);
			System.out.println("Se ha insertado " + filasBorradas + (filasBorradas==1?"fila":"filas") );    				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
	
    public static void main( String[] args )
    {
    	//consultaSql30();
    	//consultaSql31();
    	//consultaSql32();
    	//ejemploInsert();
    	ejemploDelete();
    }
}
