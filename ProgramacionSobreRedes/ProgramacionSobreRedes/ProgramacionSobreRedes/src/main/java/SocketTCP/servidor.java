package SocketTCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class servidor extends conexion {

	DataInputStream disSer = null;

	public servidor() {
		super("servidor");
	}

	@SuppressWarnings("deprecation")
	public void serverOn() {
		try {
			ps.println("Esperando a un cliente ...");

			// congela programa
			sock = servSock.accept();
			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			dosSer = new DataOutputStream(sock.getOutputStream());
			disSer = new DataInputStream(sock.getInputStream());

			ps.println("Cliente conectado con exito :) !!!");

			ps.println("Esperando mensaje del cliente ...");

			while (true) {
				ps.println("--" + disSer.readUTF());
			}
			/*
			 * while( (msg = read.readLine()) != null ) { //aca recibi un mensaje seguro
			 * ps.println( "mensaje recibido: " + msg );
			 * 
			 * dosSer.writeUTF("quiero !"); dosSer.flush(); }
			 */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();

				

				if (disSer != null)
					disSer.close();

				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
