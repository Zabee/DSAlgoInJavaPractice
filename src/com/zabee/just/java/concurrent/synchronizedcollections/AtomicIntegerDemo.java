

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	public static void main(String[] args) throws InterruptedException {
		AtomicCounter actCounter = new AtomicCounter();
		ExecutorService execService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				execService.submit(() -> actCounter.increment());
			} else {
				execService.submit(() -> actCounter.decrement());
			}
		}
		execService.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("Expected output: 50. Acutal output: "+actCounter.getValue());
		execService.shutdown();
	}
}

class AtomicCounter {
	AtomicInteger counter = new AtomicInteger();

	public void increment() {
		counter.incrementAndGet();
		counter.incrementAndGet();
	}

	public void decrement() {
		counter.decrementAndGet();
	}

	public int getValue() {
		return counter.get();
	}
}
/**
    Expected output: 50. Acutal output: 50
 **/
