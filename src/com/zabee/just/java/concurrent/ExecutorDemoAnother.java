package com.zabee.just.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemoAnother {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService execSerivce = Executors.newFixedThreadPool(10);
		Future<?> runnableFuture = execSerivce.submit(() -> System.out.println("Doing some task here"));
		Future<Integer> callableIntFuture = execSerivce.submit(() -> 10);
		Future<String> callableStringFuture = execSerivce.submit(() -> "Blah blah black sheep");
		System.out.println("Output:");
		System.out.println("Return value of runnable: " + runnableFuture.get());
		System.out.println("Return value of callable: " + callableIntFuture.get());
		System.out.println("Return value of callable: " + callableStringFuture.get());
		execSerivce.awaitTermination(1, TimeUnit.SECONDS);
		execSerivce.shutdown();

	}

}
