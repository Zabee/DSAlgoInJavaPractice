package com.zabee.just.java.concurrent.parallelstreamandthreads;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamAndForEachOrdered {

	private static int mapFn(int argNum) {
		System.out.println("Number " + argNum + " is processing by thread " + Thread.currentThread());
		return argNum * 1;
	}

	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println(integerList.parallelStream()//
//				.sequential()//
				.reduce(0, (tempSum, actualSum) -> sum(tempSum, actualSum)));
//		integerList.parallelStream()//
//		.filter(e -> check(e))//
//		.forEachOrdered(ParallelStreamAndForEachOrdered::printIt);

//		integerList.parallelStream()//
//				.map(ParallelStreamAndForEachOrdered::mapFn)//
//				.forEachOrdered(i -> printIt(i));
	}

	private static int sum(int tempSum, int actualSum) {
		int result = tempSum + actualSum;
		System.out.println("Values of passed arguments :" + tempSum + " and " + actualSum);
		return result;
	}

	private static boolean check(Integer e) {
		System.out.println("Checking the element : " + e + " by thread" + Thread.currentThread());
		return true;
	}

	private static void printIt(Integer i) {
		System.out.println("Final output : " + i + " by thread: " + Thread.currentThread());
	}

}
