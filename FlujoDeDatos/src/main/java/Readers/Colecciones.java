package Readers;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Colecciones {

	
	public Colecciones() {
		PrintStream ps = new PrintStream(System.out);
		
		
		//ArrayList
        ArrayList<String> frutas2 = new ArrayList<String>();

        //List
        //     de general a   =>    especifico
        List<String> verduras = new ArrayList<String>();
        List<String>   verdu  = new LinkedList<String>();
        
        
        //LinkedList
        //Guardar - elimiar
        LinkedList<String> animales = new LinkedList<String>();
        
        //Diccionarios
        //   new HashMap<K, V>();    key , value
        Map< String , String > InglesEspañol = new HashMap<String, String>();
       
        
        
        //le paso una KEY devuelve su VALUE
        InglesEspañol.put( "hello" , "hola");
        InglesEspañol.put( "hi"    , "hola");
        InglesEspañol.put( "HELLO" , "hola");
        
        InglesEspañol.get("");
        
        
        
        frutas2.add("Frutilla");
        frutas2.add("Manzana");
        frutas2.add("Banana");
	
		
        //for tradicional
        ps.println("FOR TRADICIONAL");
        for( int i = 0 ; i < frutas2.size() ; i++ )
        {
        	ps.println(  frutas2.get( i )  );
        }
		
        
        //for each
        ps.println("FOR EACH");
        for(  String elemento : frutas2  )
        {
        	ps.println(  elemento  );
        }
        
        //while iterador
        ps.println("ITERATOR");
        Iterator i = frutas2.iterator();
        while( i.hasNext() )
        {
        	String aux = (String)i.next();
        	
        	ps.println( aux );
        }
        
        
        //HASHMAP - MAP ->  ITERATOR
        Iterator element = InglesEspañol.keySet().iterator();
        while( element.hasNext() )
        {
        	String key   = (String)element.next();    	
        	String value = InglesEspañol.get( key );
        }
        
        
        
	}
	
}
