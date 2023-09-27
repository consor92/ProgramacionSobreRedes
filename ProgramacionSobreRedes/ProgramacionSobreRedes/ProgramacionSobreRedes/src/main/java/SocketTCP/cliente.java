package SocketTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliente extends conexion {

	InputStreamReader isrCli = null;
	BufferedReader read = null;

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
			isrCli = new InputStreamReader(sock.getInputStream());
			read = new BufferedReader(isrCli);

			ps.println("enviando mensaje");
			dosCli.writeUTF("truco");
			dosCli.writeUTF("truco");
			dosCli.flush();

			while ((msg = read.readLine()) != null) {
				ps.println("nos canto retrucooo x.x");
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
