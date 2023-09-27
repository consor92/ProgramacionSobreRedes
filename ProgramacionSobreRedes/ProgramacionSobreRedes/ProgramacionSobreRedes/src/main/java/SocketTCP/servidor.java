package SocketTCP;

import java.io.IOException;

public class servidor extends conexion {

	public servidor() {
		super("servidor");
	}

	public void serverOn()
	{
		try {
			ps.println("Esperando a un cliente ...");
			
			//congela programa
			sock = servSock.accept();
			
			ps.println( sock.getInetAddress().getHostAddress() );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
