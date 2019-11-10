package com.zabee.just.java.concurrent.threadsafetysolutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafetySolutionStatelessMethods {

	public static void main(String[] args) {
		ExecutorService execService = Executors.newFixedThreadPool(20);
		java.util.stream.Stream.iterate(0, i -> ++i)//
		.limit(20)//
		.forEach(i -> System.out.println(execService.submit(() -> calculateSquareSteateLess(i))));
	}

	private static long calculateSquareSteateLess(long argNum) {
		long result = 0;
		result = argNum * argNum;
		return result;
	}
}
