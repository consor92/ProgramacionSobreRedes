package SocketTCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class conexion {

	private final String direccion = "localhost"; // 127.0.0.1
	private final int port = 5050;

	private InetAddress IP;

	protected Socket sock;
	protected ServerSocket servSock;

	protected PrintStream ps;

	protected DataOutputStream dosCli, dosSer;
	protected String msg = "";

	public conexion(String tipo) {
		ps = new PrintStream(System.out);

		try {
			IP = InetAddress.getByName(direccion);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			if (tipo.equals("cliente")) {
				servSock = null;
				sock = new Socket(IP, port);
			} else if (tipo.equals("servidor")) {
				servSock = new ServerSocket(port);
				sock = new Socket();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
