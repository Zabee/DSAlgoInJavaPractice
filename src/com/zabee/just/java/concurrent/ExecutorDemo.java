package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService execService = Executors.newFixedThreadPool(1);
		CommandThread cmdThread1 = new CommandThread("This just being me!!");
		CommandThread cmdThread2 = new CommandThread("This just being me, again!!");
		CommandThread cmdThread3 = new CommandThread("This just being me, again and again!!");
		execService.submit(cmdThread1);
		execService.submit(cmdThread2);
		execService.awaitTermination(5, TimeUnit.SECONDS);
		execService.shutdown();
		System.out.println("End of Executor Service Framework task");

		System.out.println("*************Beginning what is Scheduled Executor Service");
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

	private static class CommandThread extends Thread {
		private String toRun;

		public CommandThread(String argToRun) {
			toRun = argToRun;
		}

		@Override
		public void run() {
			System.out.println(toRun);
		}
	}
}
