package com.zabee.just.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cntDownLatch = new CountDownLatch(2);
		Resource resource = new Resource();
		Worker worker1 = new Worker(resource, cntDownLatch);
		Worker worker2 = new Worker(resource, cntDownLatch);
		worker1.start();
		worker2.start();
		cntDownLatch.await();
		System.out.println(resource.getProgramCounterValue());
	}

	private static class Resource {
		private Integer programCounter = new Integer(0);

		public synchronized int getProgramCounterValue() {
			return programCounter;
		}

		public synchronized void incrementProgramCounter(int programCounter) {
			this.programCounter++;
		}

	}

	private static class Worker extends Thread {
		private Resource resource;
		private CountDownLatch cntDownLatch;

		public Worker(Resource argResource, CountDownLatch argCntDownLatch) {
			this.resource = argResource;
			this.cntDownLatch = argCntDownLatch;
		}

		@Override
		public void run() {
			Stream.iterate(0, i -> ++i)//
					.limit(3000)//
					.forEach(i -> this.resource.incrementProgramCounter(1));
			cntDownLatch.countDown();
		}
	}
}
// class AnotherWorker extends Thread {
//		private Resource resource;
//
//		public AnotherWorker(Resource argResource) {
//			this.resource = argResource;
//		}
//
//		@Override
//		public void run() {
//			Stream.iterate(0, i -> ++i)//
//					.limit(3000)//
//					.forEach(i -> this.resource.incrementProgramCounter(1));
//		}
//
// }
//}
