package com.zabee.just.java.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WorkStrealingPoolExecServiceDemo {

	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool execService = (ForkJoinPool) Executors.newWorkStealingPool(4);
		Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> execService.submit(() -> System.out.println("Doing some random task" + i)));
		execService.awaitTermination(5, TimeUnit.SECONDS);
		execService.shutdown();
	}

}
