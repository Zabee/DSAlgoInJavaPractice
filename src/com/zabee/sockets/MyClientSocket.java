package com.zabee.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClientSocket {
	private static int serverPortNumber = 9090;

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket = new Socket(InetAddress.getLocalHost(), serverPortNumber);
		byte[] bytes = new byte[1024];
		while (!socket.isConnected()) {
			;
		}
		System.out.println("Client: connected to server socket");
		InputStream serverInputStream = socket.getInputStream();
		readFromServer(bytes, serverInputStream);
		Thread.sleep(500);
		readFromServer(bytes, serverInputStream);
		socket.getOutputStream().write("Good bye server!!".getBytes());
		System.out.println("End of client life");
	}

	private static void readFromServer(byte[] bytes, InputStream serverInputStream)
			throws IOException, UnsupportedEncodingException {
		serverInputStream.read(bytes);
		System.out.println(new String(bytes, "UTF-8"));
	}

}
