package com.fran.ejemplojdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fran.ejemplojdbc3.entidades.Categoria;
import com.fran.ejemplojdbc3.entidades.Empleado;

public class App 
{
	
	public static final String URL ="jdbc:mysql://localhost:3306/eoi2";
	public static final String USUARIO = "root";
	public static final String PASSWORD = "";
	public static List<Empleado> empleados = new ArrayList<Empleado>();  // Lista de empleados vacía inicialmente
	public static List<Categoria> categorias = new ArrayList<Categoria>();  // Lista de empleados vacía inicialmente
	
	
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
	
	
	public static void cargarEmpleados() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT * FROM empleados");
        	        	
        	while(rs.next()) {  // recorre todas las filas de los resultados y guardamos los elementos en la lista
        		Empleado e = new Empleado(
        				rs.getInt("num"),
        				rs.getString("nombre"),
        				rs.getInt("edad"),
        				rs.getInt("departamento"),
        				rs.getInt("categoria"),
        				rs.getDate("contrato").toLocalDate()
        				);
        		empleados.add(e);
        	}			
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cargarCategorias() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
        {
        	Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery("SELECT * FROM categorias");
        	        	
        	while(rs.next()) {  // recorre todas las filas de los resultados y guardamos los elementos en la lista
        		Categoria c = new Categoria(
        				rs.getInt("categoria"),
        				rs.getString("titulo"),
        				rs.getInt("salario"),
        				rs.getInt("trienio")
        				);
        		categorias.add(c);
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
        	System.out.println("Se ha insertado " + filasInsertadas + (filasInsertadas==1?" fila":" filas") );    				
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
			System.out.println("Se ha borrado " + filasBorradas + (filasBorradas==1?" fila":" filas") );    				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
	
	public static void ejemploUpdate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el código de la categoría a actualizar: ");
		int categoria = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca el nuevo título de la categoría: ");
		String titulo = sc.nextLine();
		System.out.println("Introduzca el nuevo salario de la categoría: ");
		int salario = Integer.parseInt(sc.nextLine());
		System.out.println("Introduzca el nuevo trienio de la categoría: ");
		int trienio = Integer.parseInt(sc.nextLine());
		
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
		{
			Statement st = con.createStatement();
			String sql = "UPDATE categorias SET titulo = '" + titulo + "', salario = " + salario + ", trienio = " + trienio + " WHERE categoria = " + categoria;
			System.out.println(sql);
			int filasActualizadas = st.executeUpdate(sql);
			System.out.println("Se ha actualizado " + filasActualizadas + (filasActualizadas==1?" fila":" filas") );    				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

	public static void showMenu() {
		
		Scanner sc = new Scanner(System.in);
		int opcion = -1;
    	do {
    		System.out.println("1. Buscar empleado por nombre");
    		System.out.println("2. Buscar categoria por nombre");
    		System.out.println("3. Obtener años trabajado por empleado");
    		System.out.println("0. Salir");
    		System.out.println("Introduzca opción: ");
    		opcion = Integer.parseInt(sc.nextLine());
    		switch(opcion) {
    		case 1:
    			System.out.println("Introduzca el nombre:");
    			String nombre = sc.nextLine();
    			empleados.stream()
    				.filter(e->e.getNombre().toLowerCase().contains(nombre.toLowerCase()))
    				.forEach(e->System.out.println(e.getNombre()));
    			break;
    		case 2:
    			break;
    		case 3:
    			break;
    		default:
    			break;
    		}
    	}while(opcion!=0);
				
		sc.close();
	}
	
    public static void main( String[] args )
    {
    	
    	//consultaSql30();
    	//consultaSql31();
    	//consultaSql32();
    	//ejemploInsert();
    	//ejemploDelete();
    	//ejemploUpdate();
    	cargarEmpleados();
    	cargarCategorias();
    	//empleados.forEach(e->System.out.println(e));
    	//empleados.forEach(e->System.out.println(e.getNombre() + " ha trabajado " + e.anyosTrabajados() + " años"));   	
    	//categorias.forEach(c->System.out.println(c));
    	showMenu();
    	
    	
    	
    }
}
