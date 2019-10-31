package com.zabee.just.java.concurrent.locks;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import java.util.stream.Stream;

public class ReentrantReadWriteLockExample extends ReentrantLockExample {

	public static void main(String[] args) throws InterruptedException {
		ReentrantReadWriteLock reentrantRWLock = new ReentrantReadWriteLock(true);
		ConcurrentLinkedQueue<Integer> resourceQueue = new ConcurrentLinkedQueue<>();
		Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> resourceQueue.add(i));
		ExecutorService workerThreadsexecService = Executors.newFixedThreadPool(6);
		MyWriterThread myWriterThread1 = new MyWriterThread(reentrantRWLock, resourceQueue);
		MyWriterThread myWriterThread2 = new MyWriterThread(reentrantRWLock, resourceQueue);
		MyWriterThread myWriterThread3 = new MyWriterThread(reentrantRWLock, resourceQueue);
		MyWriterThread myWriterThread4 = new MyWriterThread(reentrantRWLock, resourceQueue);
		MyWriterThread myWriterThread5 = new MyWriterThread(reentrantRWLock, resourceQueue);
		MyWriterThread myWriterThread6 = new MyWriterThread(reentrantRWLock, resourceQueue);
		MyReaderThread myReaderThread1 = new MyReaderThread(reentrantRWLock, resourceQueue);
		MyReaderThread myReaderThread2 = new MyReaderThread(reentrantRWLock, resourceQueue);

		List<Thread> workers = Arrays.asList(myWriterThread1, myWriterThread2, myWriterThread3, myWriterThread4,
				myWriterThread5, myWriterThread6, myReaderThread1, myReaderThread2);
		workers.forEach(worker -> workerThreadsexecService.submit(worker));
		for (Thread worker : workers) {
			worker.join();
		}
		Thread.sleep(40000);
		System.out.println("Final output::");
		resourceQueue.forEach(i -> System.out.print(i));
		workerThreadsexecService.shutdown();
	}

	private static class MyReaderThread extends Thread {
		private final ReentrantReadWriteLock reentrantRWLock;
		private final ConcurrentLinkedQueue<Integer> thisResourceQueue;
//		private static int threadCnt = 0;

		private MyReaderThread(final ReentrantReadWriteLock argReentrantRWLock,
				final ConcurrentLinkedQueue<Integer> argResourceQueue) {
			this.thisResourceQueue = argResourceQueue;
			reentrantRWLock = argReentrantRWLock;
		}

		@Override
		public void run() {
			ReadLock readLock = reentrantRWLock.readLock();
			readLock.lock();
			System.out.println("No write lock found. So, reading the resource");
			System.out.println("====================================================");
			thisResourceQueue.forEach(System.out::print);
			System.out.println("\n====================================================");
		}
	}

	private static class MyWriterThread extends Thread {
		private final ReentrantReadWriteLock reentrantRWLock;
		private final ConcurrentLinkedQueue<Integer> thisResourceQueue;
//		private static int threadCnt = 0;

		private MyWriterThread(final ReentrantReadWriteLock argReentrantRWLock,
				final ConcurrentLinkedQueue<Integer> argResourceQueue) {
			this.thisResourceQueue = argResourceQueue;
			reentrantRWLock = argReentrantRWLock;
		}

		@Override
		public void run() {
			WriteLock writeLock = null;
			try {
				// Rest for 4 seconds
				Thread.sleep(4000);
//				System.out.println("Before acquiring the lock");
				writeLock = reentrantRWLock.writeLock();
				writeLock.lock();
				ConcurrentLinkedQueue<Integer> myQueue = new ConcurrentLinkedQueue<>();
				thisResourceQueue.forEach(i -> myQueue.add(++i));
				thisResourceQueue.clear();
				myQueue.forEach(i -> thisResourceQueue.add(i));
//				System.out.println("Updated the queue" + ++threadCnt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				writeLock.unlock();
			}

		}
	}
}
