package FlujoDeDatos;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//System.out.printf("Hola %s %c %d %f \n", "jsjs" , 64 , 5  , 6.1 );
		//System.err.println(" ERROR ");
		
		//System.out.append("fdfd \n");
		//System.out.flush();
		System.out.write(64);
		System.out.write(32);
		System.out.write(64);
		System.out.write(13);
		System.out.write(10);
		//System.out.print("");
		
		byte[] array = {72,111,108,97, 32 ,109,117,110,100,111};
		
		try {
			
			System.out.write( array);
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Logger.getLogger(main.class.getName()).log(Level.SEVERE, "Error critico en el sistema.");  ;
		
		PrintStream ps = new PrintStream( System.out );
		ps.println("hola");
		
	}

}
