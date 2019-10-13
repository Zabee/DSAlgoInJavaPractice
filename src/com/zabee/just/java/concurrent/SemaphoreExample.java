package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreExample {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		AtomicInteger atomicInteger = new AtomicInteger();
		Resource resource = new Resource(atomicInteger);
		WorkerThread worker1 = new WorkerThread(resource, semaphore);
		WorkerThread worker2 = new WorkerThread(resource, semaphore);
		WorkerThread worker3 = new WorkerThread(resource, semaphore);
		WorkerThread worker4 = new WorkerThread(resource, semaphore);

		ExecutorService execSerivce = Executors.newFixedThreadPool(4);
		execSerivce.submit(worker1);
		execSerivce.submit(worker2);
		execSerivce.submit(worker3);
		execSerivce.submit(worker4);
		execSerivce.awaitTermination(20, TimeUnit.SECONDS);
		execSerivce.shutdown();
	}

	private static class WorkerThread extends Thread {
		Resource resource;
		Semaphore semaphore;

		public WorkerThread(Resource argResource, Semaphore argSemaphore) {
			this.resource = argResource;
			this.semaphore = argSemaphore;
		}

		@Override
		public void run() {
			while (!semaphore.tryAcquire()) {
				System.out.println("Waiting.." + Thread.currentThread().getName());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Aquired lock. Now working.." + Thread.currentThread().getName());
			semaphore.release();
			System.out.println("********Thread " + Thread.currentThread().getName() + " just finished.");
		}
	}

	private static class Resource {
		private AtomicInteger atomicInteger;

		public Resource(AtomicInteger argAtomicInteger) {
			atomicInteger = argAtomicInteger;

		}

	}

}
