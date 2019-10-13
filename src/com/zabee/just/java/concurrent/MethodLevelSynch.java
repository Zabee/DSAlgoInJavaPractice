package com.zabee.just.java.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class MethodLevelSynch {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = Counter.getInstance();
		ExecutorService execSerivce = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 1000; i++) {
			execSerivce.submit(() -> counter.increment());
		}
		execSerivce.awaitTermination(45, TimeUnit.SECONDS);
		System.out.println("Expecting result is 1000. Actual result is : " + counter.get());
	}

	private static class Counter {
		private int c;
		private static Counter counter = new Counter();
		private final Object obj = new Object();

		private Counter() {

		}

		public static Counter getInstance() {
			return counter;
		}

		public void increment() {
			synchronized (Counter.class) {
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
}
