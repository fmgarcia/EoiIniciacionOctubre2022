package com.fran.ejemplojdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
    public static void main( String[] args )
    {
    	//consultaSql30();
    	consultaSql31();
    }
}
