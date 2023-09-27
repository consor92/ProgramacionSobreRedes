package SocketUDP_milticast;

import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Recibe {
	public static void main(String[] args) {

		PrintStream ps = new PrintStream(System.out);

		int port = 5050;
		String IP = "230.1.1.1";
		MulticastSocket socket = null;
		InetAddress IPaddress;

		try {
			socket = new MulticastSocket(port);
			IPaddress = InetAddress.getByName(IP);
			socket.joinGroup(IPaddress);
			ps.println("Esperando conexion multicast:" + socket.getInetAddress());
			
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
			
			ps.println("esperando mensaje.");
			socket.receive(packet);
			
			String msg = new String( packet.getData() , packet.getOffset() , packet.getLength() ) ;
			ps.println( ("[Multicast Recibido] - ").concat(msg)  );
			
			socket.leaveGroup(IPaddress);
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
