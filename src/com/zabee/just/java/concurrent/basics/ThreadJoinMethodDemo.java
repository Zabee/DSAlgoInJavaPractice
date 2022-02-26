package com.zabee.just.java.concurrent;

public class ThreadJoinMethodDemo {

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread(10);
		myThread.start();
		myThread.join(); // Asking this main() thread to wait till myThread completes
		System.out.println("My thread is alive? " + myThread.isAlive());
	}

	private static class MyThread extends Thread {
		int count = 0;

		public MyThread(final int argCount) {
			count = argCount;
		}

		@Override
		public void run() {
			while (count > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Counting down : " + count);
			}

		}
	}
}
