package Class.System;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalidaDeDatos {

	public SalidaDeDatos() {
		// TODO Auto-generated method stub

		// Flujos principales OUT ERR IN
		// System.out.printf("Hola %s %c %d %f \n", "jsjs" , 64 , 5 , 6.1 );
		System.err.println(" ERROR ");

		// System.out.append("fdfd \n");
		// System.out.flush();
		System.out.write(64);
		System.out.write(32); // espacio
		System.out.write(64);
		System.out.write(13); // fin de linea (EOF)
		System.out.write(10); // enter
		// System.out.print("");

		byte[] array = { 72, 111, 108, 97, 32, 109, 117, 110, 100, 111 };

		try {

			System.out.write(array);
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Logger.getLogger(main.class.getName()).log(Level.SEVERE, "Error critico en el sistema.");
		;

		PrintStream ps = new PrintStream(System.out);
		ps.println("hola");

		// c:\\user\\document\\errores.log

		File archivo = new File("errores.log");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(archivo, true);
			PrintStream err = new PrintStream(fos);

			System.setErr(err);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.err.println("este error esta en un archivo");
		System.err.println("error 3");
	}

}
