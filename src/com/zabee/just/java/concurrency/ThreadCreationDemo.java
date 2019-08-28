package com.zabee.just.java.concurrency;

public class ThreadCreationDemo {
	public static void main(String[] args) {
		System.out.println("Entered main and then sleeping for 4 seconds");
		try {
			Thread.interrupted();
			Thread.sleep(1000);
			thread1.start();
			thread2.start();
			thread3Wrapper.start();
			externalThreadWrapper.start();
			extreanalThread.start();
			extreanalThread.join();
			if(thread1.isAlive()) {
				thread1.interrupt();
				thread1.join();
			}
			System.out.println("In the end, main()");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static Thread thread1 = new Thread() {
		@Override
		public void run() {
			// SEE HERE, INFINITE LOOP
			for (;;) {
//				System.out.println("My thread1!!");
			}
		};
	};

	static Thread thread2 = new Thread() {
		@Override
		public void run() {
			System.out.println("My thread2!!");
		}
	};

	static Runnable thread3 = new Runnable() {
		@Override
		public void run() {
			System.out.println("My thread3!! Runnable one");
		}
	};

	static Thread thread3Wrapper = new Thread(thread3);
	static ExternalRunnableThread externalThread = new ExternalRunnableThread();
	static Thread externalThreadWrapper = new Thread(externalThread);
	static ExtreanalThread extreanalThread = new ExtreanalThread();

}

class ExternalRunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("My thread4!! External runnable implemented one");
	}
}

class ExtreanalThread extends Thread {

	@Override
	public void run() {
		System.out.println("My thread5!! External implemented one");
	};
}

interface SomeInterface {
	public void doStuff();
}
