package com.zabee.allaboutmemory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsWithStaticMembers {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorSerivce = Executors.newCachedThreadPool();
		MyThread anyOneThread = new MyThread();
		executorSerivce.submit(anyOneThread);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(999)//
				.forEach(i -> executorSerivce.submit(new MyThread()));
		executorSerivce.awaitTermination(3, TimeUnit.SECONDS);
		executorSerivce.shutdown();
		System.out.println("Expected value is 10_000. Actual values is : " + anyOneThread.counter.get());
	}

	private static class MyThread extends Thread {
		public static AtomicInteger counter = new AtomicInteger();

		public void run() {
			counter.incrementAndGet();
		}
	}
}
