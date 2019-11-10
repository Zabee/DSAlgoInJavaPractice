package com.zabee.just.java.concurrent.synchronizedcollections;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		Object lock = new Object();
		ExecutorService executorSerivce = Executors.newFixedThreadPool(10);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> executorSerivce.submit(new MyThread(resource, lock)));
		executorSerivce.awaitTermination(2, TimeUnit.SECONDS);
		executorSerivce.shutdown();
		System.out.println("Final output");
		for (int number : resource.copyOnWriteArrayList) {
			if (number == 0) {
				System.out.println();
			}
			System.out.print(number + "|");
		}
		System.out.println();
	}

	private static class MyThread implements Runnable {
		private Resource resource;
		private Object lock;

		public MyThread(Resource argResource, Object argLock) {
			this.resource = argResource;
			this.lock = argLock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				java.util.stream.Stream.iterate(0, i -> ++i)//
						.limit(10)//
						.forEach(i -> resource.copyOnWriteArrayList.add(i));
			}
		}
	}

	private static class Resource {
		private CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
	}
}
