package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AnotherAtomicInteger {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		ExecutorService execService = Executors.newFixedThreadPool(100);
		Stream.iterate(0, i -> ++i)//
				.limit(50)//
				.forEach(i -> {
					execService.submit(new IncrementWorker(resource));
					execService.submit(new DecrementWorker(resource));
				});
		execService.awaitTermination(5, TimeUnit.SECONDS);
		execService.shutdown();
		System.out.println("Final result is : " + resource.getValue());

	}

	private static class IncrementWorker extends Thread {
		private Resource resource;

		public IncrementWorker(Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			resource.atomicInteger.incrementAndGet();
		}
	}

	private static class DecrementWorker extends Thread {
		private Resource resource;

		public DecrementWorker(Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			resource.atomicInteger.decrementAndGet();
		}
	}

	private static class Resource {
		private AtomicInteger atomicInteger = new AtomicInteger();

		public void increment() {
			atomicInteger.incrementAndGet();
		}

		public void decrement() {
			atomicInteger.decrementAndGet();
		}

		public int getValue() {
			return atomicInteger.get();
		}
	}
}
