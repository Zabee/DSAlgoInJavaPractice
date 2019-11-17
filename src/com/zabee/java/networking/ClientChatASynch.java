package com.zabee.java.networking;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ClientChatASynch {

	private static Socket clientSocket;
	private static Scanner keyBoardRead;
	private static BufferedInputStream serverInputStream;
	private static BufferedOutputStream serverOutputStream;

	public static void main(String[] args) throws IOException {
		ClientChatASynch clientChatASynch = new ClientChatASynch();
		clientSocket = new Socket();
		InetSocketAddress socketAddress = new InetSocketAddress(8767);
		clientSocket.connect(socketAddress);
		serverInputStream = new BufferedInputStream(clientSocket.getInputStream());
		serverOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());
		keyBoardRead = new Scanner(System.in);
		ExecutorService executorSerivce = Executors.newFixedThreadPool(2);
		executorSerivce.submit(clientChatASynch.new WriterThread());
		executorSerivce.submit(clientChatASynch.new ReaderThread());

	}

	private class WriterThread extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.print("Server: ");
				try {
					System.out.print("Client: ");
					serverOutputStream.write(keyBoardRead.nextLine().getBytes());
					serverOutputStream.flush();
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
					serverInputStream.read(bytes);
					System.out.println("Server:" + new String(bytes));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
