package com.zabee.java.networking;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChatSynch {

	private static ServerSocket serverSocket;
	private static Scanner keyBoardRead;

	public static void main(String[] args) throws IOException {
		serverSocket = new ServerSocket(8767);
		Socket clientSocket = serverSocket.accept();
		BufferedInputStream clientInputStream = new BufferedInputStream(clientSocket.getInputStream());
		BufferedOutputStream clientOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());

		byte[] bytes = new byte[120];
		keyBoardRead = new Scanner(System.in);
		while (true) {
			System.out.print("Server: ");
			clientOutputStream.write(keyBoardRead.nextLine().getBytes());
			clientOutputStream.flush();
			clientInputStream.read(bytes);
			System.out.println("Client: " + new String(bytes));
		}
	}

}
