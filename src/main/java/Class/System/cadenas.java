package Class.System;

public class cadenas {

	public cadenas() {
		
		String cadena = "hola mundo";
		String cadena2 = "chau";
		
		cadena.length(); //largo
		cadena.concat(cadena); // concatena cadenas
		cadena.split(","); // separador vec[]
		cadena.toLowerCase();
		cadena.toUpperCase();
		cadena.substring( 2 , 5 ); //a partir de donde empezar y desde donde empieza a agarra la cantidad de caracteres
		cadena.charAt(5); //devuelve un caracter segun la posicion
		cadena.trim();//limpia espacios
		cadena.indexOf("la");
		// devuelve la ultima aparicion
		cadena.replace("a", "b");//reemplaza 
		cadena.replaceAll("todo", "cadena");
		
		int[] a = {5,4,7,9,3};
		cadena.toCharArray();
		cadena.compareTo(cadena2);
		cadena.compareToIgnoreCase(cadena2);
		cadena.equals(cadena2);//esto es lo mismo que usar ==
		cadena.contains("ho");
		cadena.startsWith("ho");
		cadena.endsWith("do");
		
		cadena.codePointAt(4); // 4 = espacio => 32 
		cadena.isEmpty();
		//cadena.copyValueOf(a);
		// copia un array de caracteres dentro de una cadena
		cadena.split(","); // separador de vec[]
		//"Hola, chau, mundo" -> [0] hola [1] chau[2] mundo [3]
		cadena.split("<->");		
		
	}
	
}
