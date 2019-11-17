package com.zabee.java.networking;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientChatSynch {

	private static Socket clientSocket;
	private static Scanner keyBoard;

	public static void main(String[] args) throws IOException {
		clientSocket = new Socket();
		InetSocketAddress socketAddress = new InetSocketAddress(8767);
		clientSocket.connect(socketAddress);
		BufferedInputStream serverInputStream = new BufferedInputStream(clientSocket.getInputStream());
		BufferedOutputStream serverOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
		keyBoard = new Scanner(System.in);
		byte[] bytes = new byte[120];

		while (true) {
			serverInputStream.read(bytes);
			System.out.println("Server:" + new String(bytes));
			System.out.print("Client: ");
			serverOutputStream.write(keyBoard.nextLine().getBytes());
			serverOutputStream.flush();
		}
	}

}
