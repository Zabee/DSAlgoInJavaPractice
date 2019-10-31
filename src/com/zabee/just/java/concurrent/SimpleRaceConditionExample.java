package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class SimpleRaceConditionExample {

	public static void main(String[] args) throws InterruptedException {
		Incrementer inc = new Incrementer();
		ExecutorService execService = Executors.newFixedThreadPool(1030);
		Stream.iterate(0, i -> ++i)//
				.limit(1000)//
				.forEach(i -> execService.submit(new MyThread(inc)));
		Stream.iterate(0, i->++i)//
		.limit(30)//
		.forEach(i->execService.submit(new MyOtherThread(inc)));
		Thread.sleep(1000);
		System.out.println("Expected sum: 1000: " + inc.getSum());
		execService.shutdown();

	}

	private static class MyOtherThread extends Thread {
		Incrementer inc;

		public MyOtherThread(Incrementer argInc) {
			this.inc = argInc;
		}

		@Override
		public void run() {
			System.out.println("Intermeditate sum is: " + inc.getSum());
		}
	}

	private static class MyThread extends Thread {
		Incrementer inc;

		public MyThread(Incrementer argInc) {
			this.inc = argInc;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(100);
				inc.increment();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static class Incrementer {
		private int sum;

		public synchronized int increment() {
			int tempSum = sum;
			tempSum = tempSum - 1;
			tempSum = tempSum + 1;
			tempSum = tempSum + 1;
			sum = tempSum;
			return sum;
		}

		public synchronized int getSum() {
			return sum;
		}
	}
}
