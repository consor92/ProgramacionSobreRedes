package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Send {

	//udp
	//MultiCast
	public static void main(String[] args)
	{
		try {
			int port = 5050;
			//Rango del MultiCast
			//224.0.0.0 y 239.255.255.255
			String IP = "230.1.1.1";
			
			DatagramSocket udpSocket = new DatagramSocket();
		
			byte[] msg = ("Holaa").getBytes();
			DatagramPacket pack = new DatagramPacket( msg , msg.length );
			
			InetAddress IPaddress = InetAddress.getByName(IP);
			
			pack.setAddress( IPaddress );
			pack.setPort( port );
			
			udpSocket.send( pack );
			
			System.out.println("Enviando un saludo por MultiCast");
			
			udpSocket.close();
			System.out.println("Cerrando la conexion");
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
