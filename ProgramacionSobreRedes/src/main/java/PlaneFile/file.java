/*
 * 
 */
package PlaneFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class file.
 */
public class file {

	/*
	 * OUT ERR IN
	 * 
	 * //primitiva System
	 * 
	 * //avanzada PrintStream Reader
	 * 
	 * Collection String
	 */

	/** The error. */
	File error;
	
	/** The fw. */
	FileWriter fw;
	
	/** The ps. */
	PrintStream ps;

	
	/**
	 * Instantiates a new file.
	 */
	public file() {
		ps = new PrintStream(System.out );
		error = new File("errores.log");

		try {
			fw = new FileWriter( error ,true); // Trabaja como un STREAM y administra FILE que sean Escribibles
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// this.CrearConPrintStream();
		// this.CrearConPrinter();
		this.CrearConBuffered();
		
		
		ps.println( this.LeerConBuffered() );
		
	}

	/**
	 * Crear con print stream.
	 */
	public void CrearConPrintStream() {

		try {
			FileOutputStream fos = new FileOutputStream(error); // canal de comunicacion de salida
			// fos.write(null); <- System
			PrintStream ps = new PrintStream(fos, true); // true apagado - false prendido

			ps.println("esta es mi primera linia de datos escrita en un archivo.");
			ps.flush();

			ps.close();

			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Crear con printer.
	 */
	public void CrearConPrinter() {

		PrintWriter pw = new PrintWriter(fw);
		pw.println("Esto es otra linea ");

		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Crear con buffered.
	 */
	public void CrearConBuffered() {

		BufferedWriter bw = new BufferedWriter(fw);
		try {

			bw.write("chau");
			bw.newLine();

			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	/**
	 * Leer con buffered.
	 *
	 * @return the string
	 */
	public String LeerConBuffered()
	{
		String texto="";
		try {
			FileReader fr = new FileReader(error);
			BufferedReader br = new BufferedReader( fr );
			
			String linea ="";
			while( (linea = br.readLine() ) !=  null)
			{
				texto += "\n" + linea;
			}		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return texto;
	}
	
	
}

