package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class VolatileExampleWithReentrantReadWriteLock {

	public static void main(String[] args) throws InterruptedException {

		Resource resource = new Resource(0);
		
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(100)//
				.forEach(i -> executorService.submit(new MyThread(resource)));
		
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println("Expected result : 100 Acutal Final result:" + resource.getSomeValue());
	}

	private static class MyThread extends Thread {
		private Resource resource;

		public MyThread(Resource argResource) {
			this.resource = argResource;
		}

		@Override
		public void run() {
			resource.setSomeValue(resource.getSomeValue() + 1);
		}
	}

	private static class Resource {
		private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
		final private WriteLock writeLock = readWriteLock.writeLock();
		final private ReadLock readLock = readWriteLock.readLock();

		private String someName;
		private volatile int someValue;

		public Resource(int argSomeValue) {
			this.someValue = argSomeValue;

		}

		public int getSomeValue() {
			try {
				readLock.lock();
				return someValue;
			} finally {
				readLock.unlock();
			}
		}

		public void setSomeValue(int someValue) {
			try {
				writeLock.lock();
				this.someValue = someValue;
			} finally {
				writeLock.unlock();
			}

		}

		public String getSomeName() {
			try {
				readLock.lock();
				return someName;
			} finally {
				readLock.unlock();
			}

		}

		public void setSomeName(String someName) {
			try {
				writeLock.lock();
				this.someName = someName;
			} finally {
				writeLock.unlock();
			}

		}
	}
}
/** Output
	Expected result : 100 Acutal Final result:100
**/
