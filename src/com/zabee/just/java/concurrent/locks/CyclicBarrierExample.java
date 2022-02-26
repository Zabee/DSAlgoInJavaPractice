package com.zabee.just.java.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier says let's wait for every other thread where CountDownLatch
 * says I am done anyone of you may start
 * 
 * @author zulla
 *
 */
public class CyclicBarrierExample {

	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("All right let's go"));
		ExecutorService execService = Executors.newFixedThreadPool(3);
		Worker worker1 = new Worker(cyclicBarrier);
		Worker worker2 = new Worker(cyclicBarrier);
		Worker worker3 = new Worker(cyclicBarrier);

		execService.submit(worker1);
		execService.submit(worker2);
		execService.submit(worker3);
		execService.awaitTermination(10, TimeUnit.SECONDS);
		execService.shutdown();

//		System.out.println("Submitting a new task");
//		execService.submit(new Worker(cyclicBarrier));
	}

	private static class Worker extends Thread {
		CyclicBarrier cyclicBarrier;

		public Worker(CyclicBarrier argCycleBarrier) {
			this.cyclicBarrier = argCycleBarrier;

		}

		@Override
		public void run() {
			System.out.println("Waiting for others to join at barrier!!");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				System.out.println("Barrier broker for :" + Thread.currentThread().getName());
			}
			System.out.println("Starting and ending thread: " + Thread.currentThread().getName());

		}
	}
}
