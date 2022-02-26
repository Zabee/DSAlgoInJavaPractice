package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class VolatileExampleWithReentrantReadWriteLock {

	public static void main(String[] args) throws InterruptedException {
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
		Resource resource = new Resource(0, readWriteLock);
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(100)//
				.forEach(i -> executorService.submit(new MyThread(resource, readWriteLock)));
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println("Final result: " + resource.getSomeValue());
	}

	private static class MyThread extends Thread {
		private Resource resource;
		final private ReentrantReadWriteLock readWriteLock;
		final private WriteLock writeLock;
		final private ReadLock readLock;

		public MyThread(Resource argResource, ReentrantReadWriteLock argReadWriteLock) {
			this.resource = argResource;
			this.readWriteLock = argReadWriteLock;
			this.writeLock = readWriteLock.writeLock();
			this.readLock = readWriteLock.readLock();
		}

		@Override
		public void run() {
			try {
			this.writeLock.lock();
			resource.setSomeValue(resource.getSomeValue() + 1);
			}finally {
			this.writeLock.unlock();
			}
		}
	}

	private static class Resource {
		private String someName;
		private volatile int someValue;

		public Resource(int argSomeValue, ReentrantReadWriteLock argReadWriteLock) {
			this.someValue = argSomeValue;

		}

		public int getSomeValue() {
			return someValue;
		}

		public void setSomeValue(int someValue) {
			this.someValue = someValue;
		}

		public String getSomeName() {
			return someName;
		}

		public void setSomeName(String someName) {
			this.someName = someName;
		}
	}
}
