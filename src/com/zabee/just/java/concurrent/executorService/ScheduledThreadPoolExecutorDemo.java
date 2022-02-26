package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Available processors are :  " + Runtime.getRuntime().availableProcessors());
//		ExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors());
		Future<?> voidFuture = scheduledThreadPoolExecutor
				.scheduleAtFixedRate(() -> System.out.println("This is gonna be runnable"), 1, 1, TimeUnit.SECONDS);
		Future<Integer> intFuture = scheduledThreadPoolExecutor.schedule(() -> //
		{//
			System.out.println("This is gonna be callable");
			return 10;
		}//
				, 1, TimeUnit.SECONDS);//
		
		scheduledThreadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
		if (voidFuture.isDone()) {
			System.out.println("Runnable finished. No return value: " + voidFuture.get());
		}
		if (intFuture.isDone()) {
			System.out.println("Callable finished. Return value: " + intFuture.get());
		}
		scheduledThreadPoolExecutor.shutdown();
	}

}
