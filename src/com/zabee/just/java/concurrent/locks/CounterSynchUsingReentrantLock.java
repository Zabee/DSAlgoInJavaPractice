package com.zabee.just.java.concurrent.counterresourcesynch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CounterSynchUsingReentrantLock {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		CounterResource cntResource = new CounterResource();
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(100)//
				.forEach(i -> executorService.submit(new MyThread(cntResource)));
		executorService.awaitTermination(3, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println("Final output is : " + cntResource.getCounter());
	}

	private static class MyThread extends Thread {
		private CounterResource cntResource;

		public MyThread(CounterResource argCNTResource) {
			this.cntResource = argCNTResource;
		}

		@Override
		public void run() {
			try {
				cntResource.incrementCounter();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class CounterResource {
		private int counter;
		private ReentrantLock reentrantLock = new ReentrantLock(true);

		private synchronized void incrementCounter() throws InterruptedException {
			reentrantLock.lock();
			counter++;
			reentrantLock.unlock();
		}

		private synchronized void decrementCounter() throws InterruptedException {
			try {
				wait();
				counter--;
			} finally {
				notify();
			}

		}

		public int getCounter() {
			return counter;
		}

	}

}
