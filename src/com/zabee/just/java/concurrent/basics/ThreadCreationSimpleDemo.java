package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCreationSimpleDemo {

	private static class MyThreadRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("MyThreadRunnable doing some work here!!");
		}
	}

	private static class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println("MyThread doing some work here!!");
		}
	}

	private static Thread thread2 = new Thread() {
		@Override
		public void run() {
			System.out.println("My thread2!!");
		}
	};
	// Runnable thread cannot run by itslef. Wrap it inside a Thread before calling
	// start() method
	private static Runnable threadRunnable3 = new Runnable() {
		@Override
		public void run() {
			System.out.println("My thread3!! Runnable one");
		}
	};

	private static class MyInfiniteThread extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("Running foreover. Cancel it using future and executorService");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThreadRunnable mrt = new MyThreadRunnable();
		Thread t1 = new Thread(mrt);
		t1.start();

		MyThread mt = new MyThread();
		mt.start();

		Runnable r = () -> System.out.println("Lambda thread doing some work here!");
		Thread t2 = new Thread(r);
		t2.start();

		Thread t3 = new Thread(() -> System.out.println("Another ananymous thread doing some work here!"));
		t3.start();

		thread2.start();
		new Thread(threadRunnable3).start();

		ExecutorService execService = Executors.newFixedThreadPool(2);
		MyInfiniteThread myInfiniteThread = new MyInfiniteThread();
		Future<?> future = execService.submit(myInfiniteThread);
		Thread.sleep(3000);

		if (future.isDone() == false) {
			System.out.println("Infinite thread is is not done");
			future.cancel(true);
		}
		if (future.isCancelled() == false) {
			System.out.println("Cancel infinite running thread");
		} else {
			System.out.println("Unable to cancel infinite thread as it is already running");
			System.out.println("So interrupting it and in that thread catch making it to stop");
			myInfiniteThread.interrupt();
		}
		System.out.println("********************* End of main");
		System.exit(0); // For some unknown reason
	}
}

/**
	MyThreadRunnable doing some work here!!
	MyThread doing some work here!!
	Lambda thread doing some work here!
	Another ananymous thread doing some work here!
	My thread2!!
	My thread3!! Runnable one
	Running foreover. Cancel it using future and executorService
	Running foreover. Cancel it using future and executorService
	Running foreover. Cancel it using future and executorService
	Infinite thread is is not done
	Unable to cancel infinite thread as it is already running
	So interrupting it and in that thread catch making it to stop
	********************* End of main

 **/
