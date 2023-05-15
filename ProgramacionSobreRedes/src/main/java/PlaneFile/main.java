/*
 * 
 */
package PlaneFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.System.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class main.
 *
 * @author Redes-Profesor
 */
public class main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		file archivo = new file();
		PrintStream ps = new PrintStream(System.out);

		try {
			System.setErr(new PrintStream(new File("crash.log")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.err.println("Esto es un error");

		
		
		/*
		 * aca archivos binarios
		 */
		
		
		
		
		FileBinari escribirEnBinario = new FileBinari(); // el programa
		String bin = "DumpMemory.bin"; // archivo

		// se abre un archivo de memoria
		try {
			escribirEnBinario = escribirEnBinario.deSerializar(bin);
			ps.println("Se esta ejecutando un programa BACKUP");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			ps.println("PROGRAMA NUEVO");
		} finally {
			
			
			// se corre el progama y se empieza a trabajar
			//este TRY controla si mi PROGRAMA PRINCIPAL tiene algun error
			try {
				escribirEnBinario.ejecutarPrograma();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

		// aca en teoria se esta ejecutando el programa
		// ejemple de un salir del programaVA A LLEGAR HASTA ESTE PUNTO

		try {
			escribirEnBinario.serializar(bin);
			System.out.println( "\tGRACIAS POR USAR EL PROGRAMA" );
		} catch (IOException ex) {
			PrintStream er = new PrintStream(System.err);

			// System.err.println( ex.getMessage() );
			er.println(ex.getMessage());
		}

	}

}
