package Class.System;

import java.io.IOException;
import java.io.PrintStream;

public class EntradaDeDatos {

	public EntradaDeDatos() {
		
		PrintStream ps = new PrintStream( System.out );
		
		try {
			
			ps.print("Entrada:");
			
			int Byte = 0;
			String cadena = "";
			while(   ( Byte = System.in.read() )  != '\n'  )
			{
				cadena += (char)Byte;
			}
			
			ps.println( cadena );
			//ps.println(  (char)System.in.read()  ) ;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
