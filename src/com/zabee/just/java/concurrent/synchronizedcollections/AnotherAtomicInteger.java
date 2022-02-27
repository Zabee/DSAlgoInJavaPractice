

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class AnotherAtomicInteger {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		ExecutorService execService = Executors.newFixedThreadPool(50);
		Stream.iterate(0, i -> ++i)//
				.limit(50)//
				.forEach(i -> {
					execService.submit(new IncrementWorker(resource));
					if(i % 2 == 0){
					    execService.submit(new DecrementWorker(resource));    
					}
					
				});
		execService.awaitTermination(5, TimeUnit.SECONDS);
		execService.shutdown();
		//See the beauty here. Without synchronized methods or blocks or without doing wait(), notify() without using any locks
		//So these type of Datastructures comes with out of the box synchronization. So, enjoy without worrying
		System.out.println("Expected result: 25. Final result : " + resource.getValue());

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
/** Output
        Expected result: 25. Final result : 25
 **/
