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
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class FileBinari.
 */
public class FileBinari implements Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID =  -123456L  ;
	final Logger LOG =  Logger.getLogger(FileBinari.class.getName());
	
	public FileBinari() throws SecurityException, IOException
	{
		FileHandler fileXml = new FileHandler("Logging.xml");
		LOG.addHandler(fileXml);
		
		
		LOG.log(Level.SEVERE , "Mensaje");
		
		SimpleFormatter formatterTxt = new SimpleFormatter();
		fileXml.setFormatter(formatterTxt);
		
		LOG.log(Level.ALL , "Otro mensaje");
	}
	
	/**
	 * Serializar.
	 *
	 * @param ruta the ruta
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
	
	
	/**
	 * De serializar.
	 *
	 * @param url the url
	 * @return the file binari
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
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
	
	/** The numero. */
	String numero ;
	
	/**
	 * Ejecutar programa.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void ejecutarPrograma() throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("la variable guardo anteriormente:" + numero);
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		System.out.println("\tIngrese un valor para guardar");
		numero = br.readLine();
	}
	
	
}
