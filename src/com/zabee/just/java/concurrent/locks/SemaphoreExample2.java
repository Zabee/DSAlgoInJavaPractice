package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample2 {

	public static void main(String[] args) throws InterruptedException {
		// Mutual exclusion
		Semaphore semaphore = new Semaphore(1);
		ExecutorService execService = Executors.newFixedThreadPool(4);
		Resource resource = new Resource();
		execService.submit(new MyThread(resource, semaphore)); // 1
		execService.submit(new MyThread(resource, semaphore)); // 2
		execService.submit(new MyThread(resource, semaphore)); // 3
		execService.submit(new MyThread(resource, semaphore)); // 4
		execService.submit(new MyThread(resource, semaphore)); // 5
		execService.awaitTermination(6, TimeUnit.SECONDS);
		System.out.println("Final value expected 5: " + resource.getValue());
		execService.shutdown();
	}

	private static class Resource {
		private int integer;

		private int incAutomicInteger() throws InterruptedException {
			return ++integer;
		}

		private int decAutomicInteger() throws InterruptedException {
			return --integer;
		}

		private int getValue() {
			return integer;
		}
	}

	private static class MyThread extends Thread {
		private Semaphore semaphore;
		private Resource resource;

		private MyThread(Resource argResource, Semaphore argSemaphone) {
			this.resource = argResource;
			this.semaphore = argSemaphone;
		}

		@Override
		public void run() {
			System.out.println("Running thread");
			try {
				System.out.println("Number threads waiting to acquire: " + semaphore.getQueueLength());
				while(!semaphore.tryAcquire()) {
					Thread.sleep(1000);
				}
				resource.incAutomicInteger();
				semaphore.release();			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
