package com.zabee.just.java.concurrent.forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class SimpleForkJoinActionExample {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(5);
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(25);
		forkJoinPool.invoke(myRecursiveAction);
	}

}

class MyRecursiveAction extends RecursiveAction {
	private static final long serialVersionUID = 1L;
	private int workLoad;
	private final int workThreShold;

	public MyRecursiveAction(int argWorkLoad) {
		this.workLoad = argWorkLoad;
		workThreShold = 5;
	}

	@Override
	public void compute() {
		System.out.println("Coming to :" + this + " with workload : " + this.workLoad);
		if (this.workLoad > workThreShold) {
			MyRecursiveAction myRecursiveAction = new MyRecursiveAction(this.workLoad / 2);
			myRecursiveAction.fork();
			myRecursiveAction.join();
		}

	}
}