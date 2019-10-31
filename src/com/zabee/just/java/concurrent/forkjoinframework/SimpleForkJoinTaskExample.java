package com.zabee.just.java.concurrent.forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleForkJoinTaskExample {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		MyRecursiveTask myRT = new MyRecursiveTask(25);
		forkJoinPool.invoke(myRT);
	}

	private static class MyRecursiveTask extends RecursiveTask<Integer> {
		private int workLoad;
		private final int workThreshold;

		public MyRecursiveTask(final int argWorkLoad) {
			this.workLoad = argWorkLoad;
			workThreshold = 5;
		}

		@Override
		public Integer compute() {
			System.out.println("Entered : " + this);
			if (this.workLoad > this.workThreshold) {
				MyRecursiveTask myRecursiveSubTask = new MyRecursiveTask(this.workLoad / 2);
				myRecursiveSubTask.fork();
				int returnedValueFromSubTask = myRecursiveSubTask.join();
				return returnedValueFromSubTask;
			} else {
				System.out.println("Doing work : " + this);
				return 0;
			}
		}
	}

}
