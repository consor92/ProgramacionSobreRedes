package SocketUDP_milticast;

import java.io.IOException;
import java.io.PrintStream;
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
			PrintStream ps = new PrintStream(System.out);
			
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
			
			ps.println( udpSocket.getInetAddress() );
			ps.println( udpSocket.getLocalAddress() );
			ps.println( udpSocket.getLocalSocketAddress() );
			ps.println( udpSocket.getPort() );
			ps.println( udpSocket.getLocalPort() );
			ps.println( udpSocket.getBroadcast() );	
			
			ps.println( pack.getSocketAddress() );
			ps.println( pack.getData() );
			ps.println( pack.getAddress() );
			ps.println( pack.getPort() );
			ps.println( pack.getLength() );
			ps.println( pack.getOffset() );
			
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
