package com.zabee.just.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService execService = Executors.newFixedThreadPool(1);
		Callable<String> callable = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				return "Hello World!!";
			}
		}; 
		Future<String> futureee =  execService.submit(callable);
		System.out.println("ahaha:" + futureee.get());
//		System.exit(0);
		
		MyCommandThread cmdThread1 = new MyCommandThread("This just being me!!");
		MyCommandThread cmdThread2 = new MyCommandThread("This just being me, again!!");
		MyCommandThread cmdThread3 = new MyCommandThread("This just being me, again and again!!");
		Future<?> cmdThread1Future = execService.submit(cmdThread1);
		Future<?> cmdThread2Future = execService.submit(cmdThread2);
		execService.awaitTermination(5, TimeUnit.SECONDS);
		execService.shutdown();
		System.out.println("End of Executor Service Framework task");

		System.out.println("*************Beginning of what is called Scheduled Executor Service");
		ScheduledExecutorService scheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<?> scheduleFuture = scheduledThreadPool.schedule(cmdThread1, 1, TimeUnit.SECONDS);
		Future<?> future = scheduledThreadPool.scheduleAtFixedRate(cmdThread2, 5, 5, TimeUnit.SECONDS);
		scheduledThreadPool.scheduleWithFixedDelay(cmdThread3, 8, 4, TimeUnit.SECONDS);
		Thread.sleep(2000);
		if (!future.isDone()) {
//			future.cancel(true);
		}
//		scheduleFuture.cancel(true);
		scheduledThreadPool.awaitTermination(2, TimeUnit.MINUTES);
		scheduledThreadPool.shutdown();

	}

	private static class MyCommandThread extends Thread {
		private String toRun;

		public MyCommandThread(String argToRun) {
			toRun = argToRun;
		}

		@Override
		public void run() {
			System.out.println(toRun);
		}
	}
}
