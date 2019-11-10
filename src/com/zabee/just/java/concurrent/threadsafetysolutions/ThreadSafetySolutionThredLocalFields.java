package com.zabee.just.java.concurrent.threadsafetysolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ThreadSafetySolutionThredLocalFields {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService execService = Executors.newFixedThreadPool(10);
		List<ArrayList<Integer>> listOfListInteger = new ArrayList<ArrayList<Integer>>();
		java.util.stream.Stream.iterate(0, i -> i + 10)//
				.limit(10)//
				.forEach(i -> {
					try {
						listOfListInteger.add((ArrayList<Integer>) execService.submit(new MyThread(i, i + 10)).get());
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		execService.awaitTermination(5, TimeUnit.SECONDS);
		List<Integer> finalOutput = new ArrayList<>();
		listOfListInteger.forEach(intList -> finalOutput.addAll(intList));
		Collections.sort(finalOutput);
		finalOutput.forEach(i -> System.out.println(i + "\t"));
		execService.shutdown();
	}

	private static class MyThread implements Callable<List<Integer>> {
		final ArrayList<Integer> integerList = new ArrayList<>();
		private static int threadCount = 0;
		private int lowerBound, upperBound;

		public MyThread(int lowerBound, int upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
			for (int i = lowerBound; i < upperBound; i++) {
				integerList.add(i);
			}
//			integerList = (ArrayList<Integer>) java.util.stream.Stream.iterate(lowerBound, i -> ++i)//
//					.limit(upperBound)//
//					.collect(Collectors.toList());
		}

		@Override
		public ArrayList<Integer> call() {
			System.out.println("Sending back the list from " + threadCount++ + "\t Lower bound: " + lowerBound
					+ "\t Upper bound: " + upperBound);
			return integerList;
		}
	}
}
