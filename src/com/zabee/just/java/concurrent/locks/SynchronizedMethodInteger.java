package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMethodInteger {

	public static void main(String[] args) {
		SynchedIntegerResource synchedInt = SynchedIntegerResource.valueOf(0);
		ExecutorService execServ = Executors.newFixedThreadPool(50);  //At max create 50 threads and reuse the completed ones.
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(50)//
				.forEach(i -> { // Warning: This is anti-lambda pattern
					execServ.submit(new IncWorker(synchedInt));
					if (i % 2 == 0) {
						execServ.submit(new DecWorker(synchedInt));
					}

				});
		System.out.println("Final result expected : 25 | Actual :" + synchedInt);
		execServ.shutdown();
	}

	private static class IncWorker extends Thread {
		SynchedIntegerResource synchedInt;

		public IncWorker(SynchedIntegerResource synchedInt) {
			this.synchedInt = synchedInt;
		}

		@Override
		public void run() {
			synchedInt.increment();
		}
	}

	private static class DecWorker extends Thread {
		SynchedIntegerResource synchedInt;

		public DecWorker(SynchedIntegerResource synchedInt) {
			this.synchedInt = synchedInt;
		}

		@Override
		public void run() {
			synchedInt.decrement();
		}
	}

	private static class SynchedIntegerResource {
		private int value;

		public synchronized void increment() {
			value++;
		}

		public synchronized void decrement() {
			value--;
		}

		public SynchedIntegerResource(int argValue) {
			this.value = argValue;
		}

		public static SynchedIntegerResource valueOf(int argValue) {
			int finalValue = 0;
			if (argValue < Integer.MIN_VALUE && argValue > Integer.MAX_VALUE) {
				finalValue = Integer.MIN_VALUE + argValue;
			} else {
				finalValue = argValue;
			}
			return new SynchedIntegerResource(finalValue);
		}

		public String toString() {
			return String.valueOf(value);
		}
	}
}
/** Output
	Final result expected : 25 | Actual :25
**/
