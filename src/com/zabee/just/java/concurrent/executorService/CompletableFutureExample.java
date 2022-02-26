package com.zabee.just.java.concurrent;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class CompletableFutureExample {
	
	private static ExecutorService execService = null;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		CompletableFuture<Integer> completableFuture = calculateThisAsyncly(20);
		while (!completableFuture.isDone()) {
			System.out.println("Cacluation is in porcess. Please wait..");
			Thread.sleep(2000);
		}
		System.out.println("The output is : " + completableFuture.get());
		execService.shutdown();
	}

	public static CompletableFuture<Integer> calculateThisAsyncly(int argNumber) {
		CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

		execService = Executors.newCachedThreadPool();
		execService.submit(//
				() -> {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					completableFuture.complete(Stream.iterate(0, i -> ++i)//
							.limit(argNumber)//
							.reduce(0, Integer::sum));//

				});//
		return completableFuture;
	}
}
