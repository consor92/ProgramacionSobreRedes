package SocketTCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class conexion {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";	
	
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
				sock = new Socket(IP, port);
			} else if (tipo.equals("servidor")) {
				servSock = new ServerSocket(port);
				sock = new Socket();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public InetAddress getIP() {
		return IP;
	}

	public int getPort() {
		return port;
	}
	
}
