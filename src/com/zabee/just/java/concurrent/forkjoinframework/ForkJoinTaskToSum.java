package com.zabee.just.java.concurrent.forkjoinframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinTaskToSum {

	public static void main(String[] args) {
		System.out.println("Sum of first 25 numbers : " + IntStream.iterate(1, i -> ++i)//
				.limit(25)//
				.sum());
		ForkJoinPool forkJoinPool = new ForkJoinPool(5);
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(25);
		System.out.println("Sum of first 25 numbers : " + forkJoinPool.invoke(myRecursiveTask));
	}

}

class MyRecursiveTask extends RecursiveTask<Integer> {
	private int workLoad;
	private final int workThreshold;

	public MyRecursiveTask(final int argWorkLoad) {
		this.workLoad = argWorkLoad;
		workThreshold = 5;
	}

	@Override
	public Integer compute() {
		int intermediateSum = 0;
		if (workLoad > workThreshold) {
			MyRecursiveTask myRT = new MyRecursiveTask(this.workLoad / 2);
			try {
				intermediateSum += myRT.fork().get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return intermediateSum;
		} else {
			intermediateSum = IntStream.iterate(0, i -> ++i)//
					.limit(this.workLoad)//
					.sum();
			return intermediateSum;
		}

	}
}