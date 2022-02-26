package com.zabee.just.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample2 {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cntDL = new CountDownLatch(4);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		java.util.stream.Stream.iterate(0, i->++i)//
		.limit(10)//
		.forEach(i -> executorService.submit(new  MyThread(cntDL, String.valueOf(i), i)));
		cntDL.await();
//		executorService.awaitTermination(5, TimeUnit.SECONDS);
		executorService.shutdown();
	}
	

	private static class MyThread extends Thread {
		private CountDownLatch cntDL;
		private String name;
		private ThreadLocal<Integer> someNumber = new ThreadLocal<Integer>();

		public MyThread(final CountDownLatch argCNTDL, String argName, int threadNum) {
			this.cntDL = argCNTDL;
			this.name = argName;
			someNumber.set(threadNum);
		}

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(name + someNumber.get() + ": \t I am done :");
			cntDL.countDown();
		}
	}

}
