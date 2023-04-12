package Readers;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		//menu();	
		
		ProbandoClassReader inicio = new ProbandoClassReader();
		
		
		
	}

	public static void menu() {
		
		int opt = Integer.parseInt( leer() );
		
		
		switch(opt)
		{
		case 1:
			Ejercicio1a obj = new Ejercicio1a();
			obj.correrEjercicio();
			
			//si o si la class debe ser STATIC
			Ejercicio1a.correrEjercicio(); 
			break;
			
		case 2:
			break;
			
		case 3:
			System.exit( 0 );
			break;
			
		default:
			break;
		}		
		
		menu();
	}

	
	public static String leer()
	{
		int Byte = 0;
		String cadena="";

		try {
			while ( ( Byte = System.in.read() ) != '\n' )
			{
				if ( Byte != '\r' );
					cadena += (char)Byte;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return cadena;
		
	}
	
	
	
}


