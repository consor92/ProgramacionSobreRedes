package SocketTCPconsola;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import SocketTCP.conexion;

public class cliente extends conexion {

	DataInputStream disCli = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	
	public cliente() {
		super("cliente");
	}

	public void clienteOn() {
		try {

			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			dosCli = new DataOutputStream(sock.getOutputStream());
			disCli = new DataInputStream(sock.getInputStream());

			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			boolean ON = true;
			while ( ON ) {
				ps.print("Escriba su mensaje:");
				ps.print("\t->");
				while ((msg = br.readLine()) != null) {			
					ps.print("\t->");
					dosCli.writeUTF(msg);
					dosCli.flush();
					if( msg.equals("/exit"))
					{
						ON = false;
						break;
					}
				}
			}
			
			Thread.sleep( 200 );
			ps.println("\nCLIENTE DESCONECTADO");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				dosCli.close();
				disCli.close();
				sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
