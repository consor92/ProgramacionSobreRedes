package hilos;

import java.io.PrintStream;
import java.util.Iterator;


public class CicloVida  extends Thread{
	
	PrintStream ps;
	public CicloVida() {
		ps = new PrintStream(System.out);
		this.setName("MultiplicaX1000");
	}
	
	@Override
	public void run() {
		//aca adentro las acciones del HILO  <-  Tarea
		
		ps.println(Thread.currentThread().getName());
		long a = 1;
		for( int i = 0 ; i < 1000 ; i++)
		{
			a = a * 50 ;	
		}
		ps.println(a);
	}
	
}
