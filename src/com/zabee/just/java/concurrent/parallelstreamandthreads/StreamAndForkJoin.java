package com.zabee.just.java.concurrent.parallelstreamandthreads;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class StreamAndForkJoin {

	private static int transform(int argNum) {
		System.out.println("Thread :" + Thread.currentThread() + " working on number : " + argNum);
		return argNum * 1;
	}

	public static void main(String[] args) throws InterruptedException {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		System.out.println(ForkJoinPool.commonPool());
		System.out.println(Runtime.getRuntime().availableProcessors());
		// Parallel stream by default uses ForkJoinPool
//		numbers.parallelStream()//
//				.map(StreamAndForkJoin::transform)//
//				.forEach(i -> {
//				});

		process(numbers.parallelStream()//
				.map(StreamAndForkJoin::transform));
	}

	private static void process(Stream<Integer> stream) throws InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool(100);

		forkJoinPool.submit(() -> stream.forEach(i -> {
		}));
		forkJoinPool.shutdown();
		forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
	}

}
