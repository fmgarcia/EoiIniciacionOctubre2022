package com.fran.ejemplojdbc3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.fran.ejemplojdbc3.adaptadores.LocalDateAdapter;
import com.fran.ejemplojdbc3.entidades.Categoria;
import com.fran.ejemplojdbc3.entidades.Empleado;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	public static void consultaSql33() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
		{
			Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery("Select distinct titulo FROM empleados, categorias Where empleados.categoria=categorias.categoria and year(contrato)<1990");
			//ResultSet rs = st.executeQuery("Select titulo FROM categorias Where categoria IN (Select categoria from empleados where year(contrato)<1990)");
			ResultSet rs = st.executeQuery("Select titulo FROM categorias c Where EXISTS (Select 1 from empleados e where e.categoria=c.categoria AND year(contrato)<1990)");
			while(rs.next()) { // recorre todas las filas de los resultados
	    		System.out.println(rs.getString("titulo"));
	    	}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void consultaSql34() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select nombre from empleados where contrato< (Select min(contrato) FROM empleados,dptoficinas,departamentos Where empleados.departamento=dptoficinas.codigo and dptoficinas.departamento=departamentos.deptno and departamentos.nombre='Informática')");
			while(rs.next()) { // recorre todas las filas de los resultados
				System.out.println(rs.getString("nombre"));
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void consultaSql35() {
		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD))
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select ciudad, count(*) as NumeroEmpleados FROM empleados,dptoficinas,oficinas Where empleados.departamento=dptoficinas.codigo and dptoficinas.oficina=oficinas.oficina group by oficinas.oficina having count(*)> (Select avg(sub1.cuenta) from (Select count(*) as cuenta FROM empleados,dptoficinas,oficinas Where empleados.departamento=dptoficinas.codigo and dptoficinas.oficina=oficinas.oficina group by oficinas.oficina) sub1)");
			while(rs.next()) { // recorre todas las filas de los resultados
				System.out.println(rs.getString("ciudad") + " " + rs.getInt("NumeroEmpleados"));
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
    		System.out.println("4. Empleados con años trabajados");
    		System.out.println("5. Categorias en Json");
    		System.out.println("6. Empleados en Json");
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
    			System.out.println("Introduzca el título de la categoría:");
    			String titulo = sc.nextLine();
    			categorias.stream()
    		         .filter(categoria -> categoria.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
    		         .forEach(categoria -> System.out.println(categoria.getTitulo()));
    			break;
    		case 3:
    			System.out.println("Introduzca el nombre:");
    			String nombre2 = sc.nextLine();
    			empleados.stream()
				.filter(e->e.getNombre().toLowerCase().contains(nombre2.toLowerCase()))
				.forEach(e->System.out.println(e.getNombre() + " " + e.anyosTrabajados()));
    			break;
    		case 4:
    			System.out.println("Introduzca el número mínimo de años trabajados:");
    			int anyos = Integer.parseInt(sc.nextLine());
    			empleados.stream()
				.filter(e->e.anyosTrabajados()>=anyos)
				.sorted(Collections.reverseOrder())
				.limit(3)
				.forEach(e->System.out.println(e.getNombre() + " " + e.anyosTrabajados() + " contratado: " + e.fechaEspanyola()));
    			break;
    		case 5:
    			Gson gson = new GsonBuilder().setPrettyPrinting().create();
    			String json = gson.toJson(categorias);
    			//System.out.println(json);
    			try {
					Files.writeString(Paths.get("", "categorias.json"), json);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			//String json = new Gson().toJson(categorias);
    			//System.out.println(json);
    			break;
    		case 6:
    			Gson gsonEmpleados = new GsonBuilder()
    			.setPrettyPrinting()
    			.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
    			.create();
    			String jsonEmpleados = gsonEmpleados.toJson(empleados);
    			//System.out.println(json);
    			try {
					Files.writeString(Paths.get("", "empleados.json"), jsonEmpleados);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			//String json = new Gson().toJson(categorias);
    			//System.out.println(json);
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
    	//consultaSql33();
    	//consultaSql34();
    	consultaSql35();
    	//ejemploInsert();
    	//ejemploDelete();
    	//ejemploUpdate();
    	//cargarEmpleados();
    	//cargarCategorias();
    	//empleados.forEach(e->System.out.println(e));
    	//empleados.forEach(e->System.out.println(e.getNombre() + " ha trabajado " + e.anyosTrabajados() + " años"));   	
    	//categorias.forEach(c->System.out.println(c));
    	//showMenu();
    	
    	
    	
    }
}
