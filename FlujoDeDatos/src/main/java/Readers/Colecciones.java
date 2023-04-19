package Readers;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
        
        //ITERATION por Entry
        //   Entry -> <k,v>
        for(   Map.Entry<String, String> item : InglesEspañol.entrySet()   )
        {
        	item.getKey();
        	item.getValue();
        }
        
        //metodos del HASH MAP
        InglesEspañol.containsKey("Hello");   //una sola aparicion
        InglesEspañol.containsValue("Hola");  //varias apariciones
        InglesEspañol.replace("hi","chau");  //no cambia el KEY   cambia el Value
        
        //TREEMAP
        TreeMap<Integer, String> DNI = new TreeMap<Integer, String>();
        DNI.put(100000, "pepe");
        DNI.put(800, "lalo");
        
        //LINKEDHASHMAP
        LinkedHashMap<Integer, Integer> alumnos = new LinkedHashMap<Integer, Integer>();
        
        //HASHSET
        HashSet<Integer> conjuntoNumeros = new HashSet<Integer>();
        Set<Integer>     conjuntos2      = new HashSet<Integer>();
        
        conjuntoNumeros.add( 5 );
        conjuntoNumeros.contains( 5 );
        
        
        //conversion de Collection
        //MAP -> keyset
        Set<String> key = InglesEspañol.keySet();
        ArrayList<String> value = (ArrayList<String>)InglesEspañol.values();
  
        
        //ESTO PARA DESPUES:   Comparator vs Comparable
        
	}
	
}
