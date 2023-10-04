package SocketTCP;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class cliente extends conexion {

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
				disCli.close();
				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
