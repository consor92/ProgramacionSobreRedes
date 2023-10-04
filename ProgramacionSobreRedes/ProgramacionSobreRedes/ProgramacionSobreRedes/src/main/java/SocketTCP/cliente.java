package SocketTCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliente extends conexion {

	InputStreamReader isrCli = null;
	BufferedReader read = null;
	DataInputStream disCli = null;
	
	public cliente() {
		super("cliente");
	}

	public void clienteOn() {
		try {

			ps.println("IP: " + sock.getInetAddress().getHostAddress() + 
					"\nNombre: " + sock.getInetAddress().getHostName() + 
					"\nPort: " + sock.getPort()  + 
					"\nPort Local: " + sock.getLocalPort() +
					"\n"
					);

			dosCli = new DataOutputStream(sock.getOutputStream());
			disCli = new DataInputStream(sock.getInputStream());
			isrCli = new InputStreamReader(sock.getInputStream());
			read = new BufferedReader(isrCli);

			ps.println("enviando mensaje");
			dosCli.writeUTF("truco");
			dosCli.flush();

			while (true) {
				msg = disCli.readUTF();
				ps.println("--" + msg);
				if(msg.equals("REEE TRUCO"))
					ps.println("\tnos canto retrucooo x.x");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();

				if (read != null)
					read.close();

				if (isrCli != null)
					isrCli.close();

				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
