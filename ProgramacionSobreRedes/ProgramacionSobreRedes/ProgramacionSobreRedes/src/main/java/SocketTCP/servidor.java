package SocketTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class servidor extends conexion {

	DataInputStream disSer = null;

	public servidor() {
		super("servidor");
	}

	@SuppressWarnings("deprecation")
	public void serverOn() {
		try {
			ps.println("Esperando a un cliente ...");

			// congela programa (thread)
			sock = servSock.accept();
			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			dosSer = new DataOutputStream(sock.getOutputStream());
			disSer = new DataInputStream( sock.getInputStream());

			ps.println("Cliente conectado con exito :) !!!");
			ps.println("Esperando mensaje del cliente ..." );

			// congela programa (thread)
			while (true) {
				msg = disSer.readUTF();
				if(msg.equals("/exit"))
				{
					ps.println("cliente desconectado");
					break;
				}
					
				ps.println("--" + msg);
				dosSer.writeUTF("el envido esta primero");
				dosSer.writeUTF("REEE TRUCO");
				dosSer.flush();
			}

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
