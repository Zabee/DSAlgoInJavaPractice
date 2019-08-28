package com.zabee.just.java.concurrency.synchronization;

public class CounterExample {

	private static Counter counter = new Counter();

	private static Thread thread1 = new Thread() {
		public void run() {
			for (int i = 0; i < 10; i++) {
				counter.increment();
			}
			for (int i = 0; i < 10; i++) {
				counter.decrement();
			}
		}
	};
	
	private static Thread thread2 = new Thread() {
		public void run() {
			for (int i = 0; i < 10; i++) {
				counter.increment();
			}
			for (int i = 0; i < 10; i++) {
				counter.decrement();
			}
		}
	};
	
	public static void main(String[] args) {
		thread1.start();
		thread2.start();
	}
	
	private static class Counter {
		private int count;

		public void increment() {
			count++;
			System.out.println("Count incremented: " + count);
		}

		public void decrement() {
			count--;
			System.out.println("Count decremented: " + count);
		}
	}
}