package com.zabee.just.java.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class SynchronizedBlockInteger {

	public static void main(String[] args) throws InterruptedException {
		SynchedBlockInteger synchedBlockInteger = new SynchedBlockInteger(0);
		ExecutorService execService = Executors.newFixedThreadPool(100);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(50)//
				.forEach(i -> {
					execService.submit(new IncThread(synchedBlockInteger));
					execService.submit(new DecThread(synchedBlockInteger));
				});
		execService.awaitTermination(5, TimeUnit.SECONDS);
		execService.shutdown();
		System.out.println("Final result is:" + synchedBlockInteger.getValue());
	}

	private static class IncThread extends Thread {
		private SynchedBlockInteger synchedBlockInteger;

		public IncThread(SynchedBlockInteger synchedBlockInteger) {
			this.synchedBlockInteger = synchedBlockInteger;
		}

		@Override
		public void run() {
			synchedBlockInteger.increment();
		}
	}

	private static class DecThread extends Thread {
		private SynchedBlockInteger synchedBlockInteger;

		public DecThread(SynchedBlockInteger synchedBlockInteger) {
			this.synchedBlockInteger = synchedBlockInteger;
		}

		@Override
		public void run() {
			synchedBlockInteger.decrement();
		}
	}

	private static class SynchedBlockInteger {
		private int value;
		private Object lock = new Object();

		public int getValue() {
			return value;
		}

		public SynchedBlockInteger(final int argValue) {
			this.value = argValue;
		}

		public void increment() {
			System.out.println(
					"Inside increment() method I am not bound to any thread. I am free to access by anyone anytime");
			synchronized (lock) {
				value++;
			}
		}

		public void decrement() {
			System.out.println(
					"Inside decrement() method I am not bound to any thread. I am free to access by anyone anytime");
			synchronized (lock) {
				value--;
			}
		}
	}
}
