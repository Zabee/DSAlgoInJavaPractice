package com.zabee.just.java.concurrent.locks;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReentrantReadWriteLockExample extends ReentrantLockExample {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		ExecutorService workerThreadsexecService = Executors.newFixedThreadPool(6);
		// Writer threads
		MyWriterThread myWriterThread1 = new MyWriterThread(resource);
		MyWriterThread myWriterThread2 = new MyWriterThread(resource);
		MyWriterThread myWriterThread3 = new MyWriterThread(resource);
		MyWriterThread myWriterThread4 = new MyWriterThread(resource);
		MyWriterThread myWriterThread5 = new MyWriterThread(resource);
		MyWriterThread myWriterThread6 = new MyWriterThread(resource);

		// Reader threads
		MyReaderThread myReaderThread1 = new MyReaderThread(resource);
		MyReaderThread myReaderThread2 = new MyReaderThread(resource);

		List<Thread> workers = Arrays.asList(myWriterThread1, myWriterThread2, myWriterThread3,
				myWriterThread4, myWriterThread5, myReaderThread1, myReaderThread2, myWriterThread6);
		workers.forEach(worker -> workerThreadsexecService.submit(worker));
		for (Thread worker : workers) {
			worker.join();
		}
		workerThreadsexecService.awaitTermination(4, TimeUnit.SECONDS);
//		Thread.sleep(40000);
		System.out.println("Final output::");
		resource.readFromResource();
		workerThreadsexecService.shutdown();
	}

	private static class MyReaderThread extends Thread {
		private final Resource resource;

		private MyReaderThread(final Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			resource.readFromResource();
		}
	}

	private static class MyWriterThread extends Thread {
		private Resource resource;

		private MyWriterThread(final Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.updateResource();
		}
	}

	private static class Resource {
		private final ConcurrentLinkedQueue<Integer> thisResourceQueue;
		private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
		private final WriteLock writeLock = readWriteLock.writeLock();
		private final ReadLock readLock = readWriteLock.readLock();
		private int lastUpdatedValue = 1;
		private final int uniformAmountOfWork = 5;

		public Resource() {
			this.thisResourceQueue = new ConcurrentLinkedQueue<>();
		}

		public void readFromResource() {
			try {
				readLock.lock();
				System.out.println("Reading form the resource");
				thisResourceQueue.stream().forEach(i -> System.out.print(i + "|"));
				System.out.println();
			} finally {
				readLock.unlock();
			}
		}

		public void updateResource() {
			try {
				writeLock.lock();
				for (int i = lastUpdatedValue; i < lastUpdatedValue + uniformAmountOfWork; i++) {
					this.thisResourceQueue.add(i);
				}
				lastUpdatedValue = lastUpdatedValue + uniformAmountOfWork;
			} finally {
				writeLock.unlock();
			}
		}
	}
}
