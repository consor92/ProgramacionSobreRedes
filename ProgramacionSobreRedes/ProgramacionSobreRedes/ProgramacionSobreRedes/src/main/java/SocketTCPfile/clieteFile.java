package SocketTCPfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import SocketTCP.conexion;

public class clieteFile extends conexion {

	BufferedOutputStream buffCli = null;
	DataInputStream disCli = null;
	FileInputStream fis = null;
	BufferedInputStream buff = null;

	public clieteFile() {
		super("cliente");
	}

	public void clienteOn() {
		try {
			

			
			ps.println("Cliente conectado con: " 
					  + sock.getInetAddress().getHostAddress()
					  );
			
			//ACA OBTENEMOS LOS CANALES DE COMUNICACION DE ENTRADA 
			//Y SALIDA TANTO PARA BYTES COMO DATOS COMUNES
			dosCli = new DataOutputStream(sock.getOutputStream());
			disCli = new DataInputStream(sock.getInputStream());

			buffCli = new BufferedOutputStream(sock.getOutputStream());

			// ACA CONFIGURACION PARA EL FILE
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif" , "*");
			
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			
			File archivo = null;
			if(returnVal == JFileChooser.APPROVE_OPTION) 
				archivo = new File(chooser.getSelectedFile().getAbsolutePath() );
			
			if (archivo.exists()) {
				// creamos el canal de comunicacion de escritura
				// con el archivo, para poder escribir
				fis = new FileInputStream(archivo);
				buff = new BufferedInputStream(fis);

				DecimalFormat df = new DecimalFormat("#.00");

				ps.println("se prepara el archivo: " + archivo.getName() + " (" + archivo.length() + " / "
						+ df.format(archivo.length()) + "Kb)");

				dosCli.writeFloat(archivo.length());
				Thread.sleep(200);
				dosCli.writeUTF(archivo.getName());
				Thread.sleep(200);

				// transformamos un FILE en un cunjuto de byte
				//aca mandamos todo el archivo de golpe
					/*byte b[] = new byte[(int) archivo.length()];
									
					buff.read(b);
					buffCli.write(b);
					*/
				//aca dividimos el arvhivos en partes mas chicas antes de enviarlo
				// envio de byte paso a paso
				byte c[] = new byte[8192];
				int in = 0;
				while ((in = buff.read(c)) != -1){
					buffCli.write(c,0,in);
				}

				Thread.sleep(500);
				ps.println(conexion.ANSI_GREEN 
						+ "El archivo: " 
						+ archivo.getName() 
						+ " se ha envio exitosamente."
						+ conexion.ANSI_RESET);
				
			} else {
				ps.println(conexion.ANSI_PURPLE + "Archivo inexistente." + conexion.ANSI_RESET);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				buffCli.close();
				buff.close();
				fis.close();
				dosCli.close();
				disCli.close();
				sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
