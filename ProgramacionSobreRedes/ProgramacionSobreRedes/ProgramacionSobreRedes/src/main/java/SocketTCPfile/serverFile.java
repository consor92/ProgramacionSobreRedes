package SocketTCPfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import SocketTCP.conexion;

public class serverFile extends conexion {

	DataInputStream disServer;
	FileOutputStream fos;
	BufferedOutputStream out;
	BufferedInputStream sockIn;

	public serverFile() {
		super("servidor");
	}

	public void StartServer() {
		ps.println("Esperando a un cliente ...");

		try {
			sock = servSock.accept();


			
			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			disServer = new DataInputStream(sock.getInputStream());

			// recibimos el peso en kb del archivo
			float peso = disServer.readFloat();
			// recibimos el nombre del archivo
			String name = disServer.readUTF();

			// generamos un objeto para poner formato a numeros
			DecimalFormat df = new DecimalFormat("#.00");

			ps.println("Recibiendo un archivo: " + name + "/" + df.format(peso));


			File recibido = new File( "".concat(name));
			if( recibido.exists())
				recibido.delete();
			
			// logica para tener varios archivos con el famoso (1) (2) (3)

			// para escribir en el File
			fos = new FileOutputStream(recibido, true);
			out = new BufferedOutputStream(fos);

			// lectura del socket
			sockIn = new BufferedInputStream(sock.getInputStream());

			byte[] buff = new byte[1024];

			// esto recibe tanto el dato completo como el dato partido por peso
			int in= 0;
			while ((in = sockIn.read(buff)) != -1) {
				
				out.write(buff,0,in);
			}
			
			out.close();
			fos.close();
			
			if (recibido.length() == peso) {
				ps.println("Se recibio el archivo completo");
			} else {
				ps.println("algo fallo, archivo corruptp " + df.format(recibido.length()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sockIn.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
