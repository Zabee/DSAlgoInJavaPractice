package com.zabee.just.java.concurrent.counterresourcesynch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class CounterSynchUsingReentrantReadWriteLock {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		CounterResource cntResource = new CounterResource();
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(100)//
				.forEach(i -> {
					executorService.submit(new MyIncThread(cntResource));
					executorService.submit(new MyDecThread(cntResource));
				});
		executorService.awaitTermination(3, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println("Final output is : " + cntResource.getCounter());
	}

	private static class MyDecThread extends Thread {
		private CounterResource cntResource;

		public MyDecThread(CounterResource argCNTResource) {
			this.cntResource = argCNTResource;
		}

		@Override
		public void run() {
			try {
				cntResource.decrementCounter();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class MyIncThread extends Thread {
		private CounterResource cntResource;

		public MyIncThread(CounterResource argCNTResource) {
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
		private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock(true);
		private final WriteLock writeLock = reentrantLock.writeLock();
		private final ReadLock readLock = reentrantLock.readLock();

		private synchronized void incrementCounter() throws InterruptedException {
			writeLock.lock();
			counter++;
			writeLock.unlock();
		}

		private synchronized void decrementCounter() throws InterruptedException {
			writeLock.lock();
			counter--;
			writeLock.unlock();
		}

		public int getCounter() {
			readLock.lock();
			try {
				return counter;
			} finally {
				readLock.unlock();
			}
		}
	}

}
