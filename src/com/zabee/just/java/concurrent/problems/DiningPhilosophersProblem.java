package com.zabee.just.java.concurrent.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Dining Philosopher Problem
 *
 */
public class DiningPhilosophersProblem {

	public static void main(String[] args) throws InterruptedException {
		Philosopher[] philosopher = new Philosopher[5];
		Fork[] forks = new Fork[philosopher.length];

		Stream.iterate(0, i -> ++i)//
				.limit(5)//
				.forEach(i -> forks[i] = new Fork(i % 2 == 0));

		ExecutorService executorSerivce = Executors.newFixedThreadPool(5);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(5)//
				.forEach(i -> executorSerivce
						.submit(philosopher[i] = new Philosopher(forks[i], forks[i + 1 % forks.length - 1], i)));
		executorSerivce.awaitTermination(5, TimeUnit.SECONDS);
		executorSerivce.shutdown();
	}

	private static class Philosopher extends Thread {
		private final Fork rightFork, leftFork;
		private final int philosopherNumber;

		public Philosopher(Fork argRightFork, Fork argLeftFork, Integer argPhilosopherNumber) {
			this.rightFork = argRightFork;
			this.leftFork = argLeftFork;
			this.philosopherNumber = argPhilosopherNumber;
		}

		@Override
		public void run() {
			synchronized (rightFork) {
				synchronized (leftFork) {
					System.out.println("Philosopher :" + philosopherNumber + " is eating ");
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static class Fork {
		private boolean isRightFork;

		public Fork(final boolean argIsRightFork) {
			this.isRightFork = argIsRightFork;
		}
	}
}
