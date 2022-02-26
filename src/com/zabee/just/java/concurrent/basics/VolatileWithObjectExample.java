package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * When you make an object volatile. Its reference stored in the Thread Stack memory and will be volatile.
 *  Note that neither the object nor the its member variable stored on Thread stack
 */
public class VolatileWithObjectExample {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(100)//
				.forEach(i -> executorService.submit(new MyThread(resource)));
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println("Updated final value expected - 100. Actual - : " + resource.counter);
	}

	private static class MyThread extends Thread {
		private Resource resource;

		public MyThread(Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			this.resource.counter.incrementAndGet();
		}
	}

	private static class Resource {
		volatile private AtomicInteger counter = new AtomicInteger();
	}
}
