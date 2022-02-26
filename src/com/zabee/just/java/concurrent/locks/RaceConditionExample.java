package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class RaceConditionExample {

	public static void main(String[] args) throws InterruptedException {
		IntWrapper a = new IntWrapper(10);
		IntWrapper b = new IntWrapper(20);
//		new RaceConditionClass().swap(a, b);
		System.out.println("Values before swapping a: " + a.getValue() + "\tb:" + b.getValue());
		ExecutorService execSerivce = Executors.newFixedThreadPool(2);
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
		execSerivce.submit(new RaceConditionClass(a, b, lock));
		execSerivce.submit(new RaceConditionClass(a, b, lock));
		execSerivce.awaitTermination(2, TimeUnit.SECONDS);
		System.out.println("Values after swapped twice - a: " + a.getValue() + "\tb:" + b.getValue());
		execSerivce.shutdown();
	}

	private static class RaceConditionClass implements Runnable {
		volatile IntWrapper a, b;
		ReentrantReadWriteLock lock = null;

		public RaceConditionClass(IntWrapper argA, IntWrapper argB, ReentrantReadWriteLock argLock) {
			this.a = argA;
			this.b = argB;
			lock = argLock;
		}

		public void run() {
			WriteLock writeLock = null;
			try {
				Thread.sleep(1000);
				writeLock = lock.writeLock();
				writeLock.lock();
				int x = a.getValue();
				a.setValue(b.getValue());
				b.setValue(x);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				writeLock.unlock();
			}

		}
	}

	private static class IntWrapper {
		private int value;

		public IntWrapper(int argValue) {
			this.value = argValue;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
