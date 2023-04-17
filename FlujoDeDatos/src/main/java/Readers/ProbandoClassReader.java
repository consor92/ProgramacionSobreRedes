package Readers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;

public class ProbandoClassReader {

	
	public ProbandoClassReader() {
		/*
		System.out;
		System.err;
		
		System.in;
		
		
		System.out.println();
		System.err.println();
		*/
		PrintStream ps = new PrintStream( System.out );
		ps.println("Escriba algo: ");
		/*
		PrintStream err = new PrintStream( System.err );
		err.println();
		
		System.in.read();
		*/
		
		Reader            obj = new InputStreamReader( System.in );
		InputStreamReader isr = new InputStreamReader( System.in );
		
		try {
			ps.println( (char)isr.read() );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ps.println( this.leer() );
		
		
		BufferedReader br = new BufferedReader( isr );
		
		
		try {
			//isr.reset();
			ps.println("Esto lo lee con un BUFFERED");
			ps.println(  br.readLine()  );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String leer()
	{
		InputStreamReader obj = new InputStreamReader( System.in );
		
		int Byte = 0;
		String cadena="";

		try {
			while ( ( Byte = obj.read() ) != '\n' )
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
