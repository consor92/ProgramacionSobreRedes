package PlaneFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class main {

	public static void main(String[] args) {

		file archivo = new file();
		
		try {
			System.setErr(  new PrintStream( new File("crash.log") )     ) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.err.println("Esto es un error");
		
	}

}
