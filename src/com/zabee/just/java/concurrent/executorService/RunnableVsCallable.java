package com.zabee.just.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.activity.InvalidActivityException;


public class RunnableVsCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService execService = Executors.newFixedThreadPool(2);
		Future<Integer> callableFuture = execService.submit(new MyCallable());
		Future<?> threadFuture = execService.submit(new MyThread());
		try {
			System.out.println("Value returned from callable is : " + callableFuture.get());
		} catch (Exception e) {
			System.out.println("Something has gone wrong with callable. Please check!!");
		}
		execService.awaitTermination(2, TimeUnit.SECONDS);
		execService.shutdown();
	}

	private static class MyThread implements Runnable {
		@Override
		public void run() {
			System.out.println("Just running a thread");
		}
	}

	private static class MyCallable implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			if (true) {
				throw new InvalidActivityException();
			}
			return Integer.valueOf(10);
		}
	}
}
