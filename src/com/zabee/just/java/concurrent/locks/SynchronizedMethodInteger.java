package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedMethodInteger {

	public static void main(String[] args) {
		SynchedInteger synchedInt = SynchedInteger.valueOf(0);
		ExecutorService execServ = Executors.newFixedThreadPool(50);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(50)//
				.forEach(i -> { // Warning: This is anti-lambda pattern
					execServ.submit(new IncWorker(synchedInt));
					execServ.submit(new DecWorker(synchedInt));
				});
		System.out.println("Final result expected : 0 | Actual :" + synchedInt);
		execServ.shutdown();
	}

	private static class IncWorker extends Thread {
		SynchedInteger synchedInt;

		public IncWorker(SynchedInteger synchedInt) {
			this.synchedInt = synchedInt;
		}

		@Override
		public void run() {
			synchedInt.increment();
		}
	}

	private static class DecWorker extends Thread {
		SynchedInteger synchedInt;

		public DecWorker(SynchedInteger synchedInt) {
			this.synchedInt = synchedInt;
		}

		@Override
		public void run() {
			synchedInt.decrement();
		}
	}

	private static class SynchedInteger {
		private int value;

		public synchronized void increment() {
			value++;
		}

		public synchronized void decrement() {
			value--;
		}

		public SynchedInteger(int argValue) {
			this.value = argValue;
		}

		public static SynchedInteger valueOf(int argValue) {
			int finalValue = 0;
			if (argValue < Integer.MIN_VALUE && argValue > Integer.MAX_VALUE) {
				finalValue = Integer.MIN_VALUE + argValue;
			} else {
				finalValue = argValue;
			}
			return new SynchedInteger(finalValue);
		}

		public String toString() {
			return String.valueOf(value);
		}
	}
}
