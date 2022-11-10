package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejemplos {

	public static void leerFicheroJava5() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			//archivo = new File("C:\\Users\\Fran\\Documents\\EOI2022\\06_OctubreJavaIniciacionValenciaTarde\\EoiIniciacionOctubre2022\\ficheros\\funciones.txt");  // ruta absoluta
			//archivo = new File("funciones.txt");  // ruta relativa
			//archivo = new File("..\\padre.txt");  // ruta relativa
			//archivo = new File("files\\hijo.txt");  // ruta relativa
			archivo = new File("files" + File.separator + "hijo.txt");  // ruta relativa con el separador
			//StringJoiner archivo = new StringJoiner(File.separator);
			//archivo.add("files").add("hijo.txt");
			
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void leerFicheroJava8(String directorio, String nombreArchivo) throws IOException {
		Files.readAllLines(Paths.get(directorio, nombreArchivo),Charset.defaultCharset())
		.forEach(l->System.out.println(l));
	}
	
	public static void main(String[] args) throws IOException {
		//leerFicheroJava5();
		//leerFicheroJava8("files","segundo.txt");
		
		leerFicheroJava8("","funciones.txt");  // para acceder a la carpeta del proyecto
		leerFicheroJava8("files","hijo.txt");  // para acceder al hijo con ruta relativa
		leerFicheroJava8("..","padre.txt");  // para acceder al padre con ruta relativa
		File fichero = new File("C:\\Users\\Fran\\Documents\\EOI2022\\06_OctubreJavaIniciacionValenciaTarde\\EoiIniciacionOctubre2022\\ficheros\\funciones.txt");
		String directorio = fichero.getParent();
		String nombreArchivo = fichero.getName();
		leerFicheroJava8(directorio,nombreArchivo);  // para acceder con ruta absoluta
	}

}
