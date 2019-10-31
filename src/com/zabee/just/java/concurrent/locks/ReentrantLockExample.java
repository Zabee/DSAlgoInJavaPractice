package com.zabee.just.java.concurrent.locks;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class ReentrantLockExample {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock reentrantLock = new ReentrantLock(true);
		ConcurrentLinkedQueue<Integer> resourceQueue = new ConcurrentLinkedQueue<>();
			Stream.iterate(0, i -> ++i)//
					.limit(10)//
					.forEach(i -> resourceQueue.add(i));
		ExecutorService workerThreadsexecService = Executors.newFixedThreadPool(6);
		MyWorkerThread myWorkerThread1 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread2 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread3 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread4 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread5 = new MyWorkerThread(reentrantLock, resourceQueue);
		MyWorkerThread myWorkerThread6 = new MyWorkerThread(reentrantLock, resourceQueue);

		List<MyWorkerThread> workers = Arrays.asList(myWorkerThread1, myWorkerThread2, myWorkerThread3, myWorkerThread4,
				myWorkerThread5, myWorkerThread6);
		workers.forEach(worker -> workerThreadsexecService.submit(worker));
		for(MyWorkerThread worker : workers) {
			worker.join();
		}
		Thread.sleep(1000);
		resourceQueue.forEach(i -> System.out.print(i));
		workerThreadsexecService.shutdown();
	}

	private static class MyWorkerThread extends Thread {
		private final ReentrantLock reentrantLock;
		private final ConcurrentLinkedQueue<Integer> thisResourceQueue;
//		private static int threadCnt = 0;

		private MyWorkerThread(final ReentrantLock argReentrantLock,
				final ConcurrentLinkedQueue<Integer> argResourceQueue) {
			this.thisResourceQueue = argResourceQueue;
			reentrantLock = argReentrantLock;
		}

		@Override
		public void run() {
			try {
//				System.out.println("Before acquiring the lock");
				reentrantLock.lock();
				ConcurrentLinkedQueue<Integer> myQueue = new ConcurrentLinkedQueue<>();
				thisResourceQueue.forEach(i -> myQueue.add(++i));
				thisResourceQueue.clear();
				myQueue.forEach(i -> thisResourceQueue.add(i));
//				System.out.println("Updated the queue" + ++threadCnt);
			} finally {
				reentrantLock.unlock();
			}

		}
	}
}
