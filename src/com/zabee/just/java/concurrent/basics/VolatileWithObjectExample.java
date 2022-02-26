package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileWithObjectExample {

	private static class Resource {
		// Volatile alone not handling race condition. Sometime result is 97 or 98 or 99
		// So, let's use AtomicInteger
		volatile private AtomicInteger counter = new AtomicInteger();
	}

	private static class MyThread extends Thread {
		private Resource resource;

		public MyThread(Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			this.resource.counter.getAndIncrement();
			this.resource.counter.getAndIncrement();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();

		System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());

		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(50)//
				.forEach(i -> executorService.submit(new MyThread(resource)));

		executorService.awaitTermination(2, TimeUnit.SECONDS);

		executorService.shutdown();

		System.out.println("Updated final value expected - 100. Actual - " + resource.counter);
	}
}
/** Output
	Available Processors: 16
	Updated final value expected - 100. Actual - 100
**/
