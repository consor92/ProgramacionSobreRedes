package Class.System;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class colecciones {

	public colecciones()
	{
		
		PrintStream ps = new PrintStream(System.out);
		String[] nombre;
		String[] nombres = new String[5];
		String[] apellidos = { "" , "" , "" };
		
		ArrayList<String> frutas = new ArrayList();
		//    interface   =    new   class    
		List<String> verduras = new ArrayList();
		
		//Agregar
		frutas.add("Manzana");
		frutas.add("banana");
		frutas.add("naranja");
		frutas.add("sandia");
		
		verduras.add("Tomate");
		
		ps.println( frutas.size() );
		
		frutas.get(0); // devuelve manzana
	
		ps.println( frutas.get(  frutas.size()-1 ) );
		
		//elimina
		//frutas.remove( 0 );
		
		ps.println( frutas.get(  frutas.size()-1 ) );
		
		
		frutas.contains("Melon");
		frutas.indexOf("frutilla");
		frutas.isEmpty();
		//frutas.clear();
		frutas.toArray(); //frutas[] = { "" , "" , ...}
		
		for( int i = 0 ; i < frutas.size() ; i++ )
		{
			frutas.get(i);
		}
		
		// https://programmerclick.com/article/6805919575/
		

		
		
	}
	
}
