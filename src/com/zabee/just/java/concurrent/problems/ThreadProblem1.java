package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Example Use Case The following are the requirements of the use case: {@code
Make a task that prints 0 through 9 on console.
After printing a number the task should wait 1 sec before printing the next number.
The task runs on a separate thread, other than main application thread.
After starting the task the main application should wait for 3 sec and then shutdown.
On shutdown the application should request the running task to finish.
Before shutting down completely the application should, at the max, wait for 1 sec for the task to finish.
The task should respond to the finish request by stopping immediately.
}
 * 
 *
 */
public class ThreadProblem1 {

	public static void main(String[] args) throws InterruptedException {
		solveUsingBareThreads();
		solveUsingExecutorService();
		solveUsingExecutorServiceCustomSubmit();
		
		System.out.println("Main terminated!!");
	}

	private static void solveUsingExecutorServiceCustomSubmit() throws InterruptedException {
		ExecutorService execService = Executors.newSingleThreadExecutor();
		Future<?> future = execService.submit(() -> {
			printNumbers();
			printNumbers();
		});
		Thread.sleep(1);
		future.cancel(true);
		execService.shutdown();
	}

	private static void printNumbers() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}

	private static void solveUsingExecutorService() throws InterruptedException {
		ExecutorService execServ = Executors.newSingleThreadExecutor();
		execServ.submit(new NumberPrintingThread());
		Thread.sleep(3000);
		execServ.shutdown();
		execServ.awaitTermination(1, TimeUnit.SECONDS);
	}

	private static void solveUsingBareThreads() throws InterruptedException {
		NumberPrintingThread numPT = new NumberPrintingThread();
		numPT.start();
		Thread.sleep(3000);
		numPT.interrupt();
		numPT.join(1000);
	}

}

class NumberPrintingThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 9; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
