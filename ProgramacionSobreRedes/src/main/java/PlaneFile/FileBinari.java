package PlaneFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FileBinari implements Serializable {

	
	private static final long serialVersionUID =  -123456L  ;
	
	
	public void serializar( String ruta ) throws IOException
	{
		File archivo = new File(ruta );	
		//canal de comunicaciones
		FileOutputStream fos = new FileOutputStream(archivo);
		
		//con este objeto podes escribir en el archivo binario
		ObjectOutputStream  escribir = new ObjectOutputStream( fos );
		escribir.writeObject( this );
		escribir.close();
	}
	
	
	public FileBinari deSerializar( String url ) throws IOException, ClassNotFoundException
	{
		File archivo = new File( url );
		FileInputStream fis = new FileInputStream( archivo );
		
		ObjectInputStream lector = new ObjectInputStream( fis );
		
		return (FileBinari)lector.readObject();
	}


	
	
	/*
	 * ACA EMPIEZA EL MAIN DE MI PROGRAMA
	 */
	
	String numero ;
	
	public void ejecutarPrograma() throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("la variable guardo anteriormente:" + numero);
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.println("\tIngrese un valor para guardar");
		numero = br.readLine();
	}
	
	
}
