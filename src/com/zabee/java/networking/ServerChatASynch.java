package com.zabee.java.networking;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerChatASynch {

	private static ServerSocket serverSocket;
	private static Scanner keyBoardRead;
	private static BufferedInputStream clientInputStream;
	private static BufferedOutputStream clientOutputStream;

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerChatASynch serverChatASynch = new ServerChatASynch();
		serverSocket = new ServerSocket(8767);
		Socket clientSocket = serverSocket.accept();
		clientInputStream = new BufferedInputStream(clientSocket.getInputStream());
		clientOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
		keyBoardRead = new Scanner(System.in);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(serverChatASynch.new WriterThread());
		executorService.submit(serverChatASynch.new ReaderThread());
		executorService.awaitTermination(10, TimeUnit.MINUTES);
	}

	private class WriterThread extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.print("Server: ");
				try {
					clientOutputStream.write(keyBoardRead.nextLine().getBytes());
					clientOutputStream.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private class ReaderThread extends Thread {
		@Override
		public void run() {
			byte[] bytes = new byte[256];
			while (true) {
				try {
					clientInputStream.read(bytes);
					System.out.println("Client: " + new String(bytes));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
