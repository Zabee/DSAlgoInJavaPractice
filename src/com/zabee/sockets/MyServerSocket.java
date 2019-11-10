package com.zabee.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServerSocket {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9090);
		ExecutorService execService = Executors.newCachedThreadPool();
		MyServerSocket myServerSocket = new MyServerSocket();
		while (true) {
			Socket clientSocket = serverSocket.accept();
			System.out.println("A new client connected. Let's server that");
			execService.submit(myServerSocket.new MyWorker(clientSocket));
		}

	}

	private class MyWorker extends Thread {
		private Socket clientSocket;

		public MyWorker(Socket argClientSocket) {
			clientSocket = argClientSocket;
		}

		public void run() {
			try {
				byte[] bytes = new byte[512];
				clientSocket.getOutputStream().write(("Hi, client. Your request id is " + getName()).getBytes());
				clientSocket.getOutputStream()
						.write("You must be tierd after all that long journey. So, sleep for half a second".getBytes());
				sleep(500);
				clientSocket.getOutputStream().flush();
				clientSocket.getOutputStream()
						.write(("Farewell client : " + getName() + ". Any last word from you?").getBytes());
				sleep(1000);
				while (clientSocket.getInputStream().read(bytes) != -1) {
					System.out.println("Client said : " + new String(bytes, "UTF-16"));
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
