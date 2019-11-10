package com.zabee.just.java.concurrent.parallelstreamandthreads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamAndForkJoin {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Long> longList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 0L);
		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		Long result = forkJoinPool.submit(() -> longList.parallelStream().reduce(0L, Long::sum)).get(); 
		System.out.println(result);
	}

}
