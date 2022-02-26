package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Lock will be on method or on the blocks. This is abstract. It can either on
 * the object itself or on the class based on the type of member you're
 * accessing (either class member or object member)
 * 
 *
 */
public class SimpleSynchProblem {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService execService = Executors.newFixedThreadPool(10);
		Counter counter = Counter.getInstance();
		for (int i = 0; i < 1000; i++) {
			execService.submit(() -> counter.increment());
		}
		execService.awaitTermination(30, TimeUnit.SECONDS);
		execService.shutdown();
		System.out.println("Expecting result is 0: Actual result is : " + Counter.getInstance().get());
	}

	private static class IncCounterThread extends Thread {
		@Override
		public void run() {
			Counter counter = Counter.getInstance();
			for (int i = 0; i < 2; i++)
				counter.increment();
		}
	}

	private static class DecCounterThread extends Thread {
		@Override
		public void run() {
			Counter counter = Counter.getInstance();
			for (int i = 0; i < 2; i++)
				counter.decement();

		}
	}
}

class Counter {
	private int c;
	private static Counter counter = new Counter();
	private Object obj = new Object();

	private Counter() {

	}

	public static Counter getInstance() {
		return counter;
	}

	public void increment() {
		synchronized (obj) {
			c++;
		}
	}

	public void decement() {
		c--;
	}

	public int get() {
		return c;
	}
}
