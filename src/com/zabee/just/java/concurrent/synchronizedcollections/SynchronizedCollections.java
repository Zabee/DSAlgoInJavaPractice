package com.zabee.just.java.concurrent.synchronizedcollections;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedCollections {

	public static void main(String[] args) throws InterruptedException {
		ResourceWithSynchedDSOnly resource = new ResourceWithSynchedDSOnly();
		Object lock = new Object();
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> {
					executorService.submit(new MyWorkerThread(resource, lock));
				});
		executorService.awaitTermination(2, TimeUnit.SECONDS);
		executorService.shutdown();
		System.out.println("Final output: ");
		for (int number : resource.synchedIntList) {
			if (number == 0) {
				System.out.println();
			}
			System.out.print(number + "|");
		}
		System.out.println();
	}

	private static class MyWorkerThread extends Thread {
		private ResourceWithSynchedDSOnly resource;
		private Object lock;

		public MyWorkerThread(ResourceWithSynchedDSOnly argResource, Object argLock) {
			this.resource = argResource;
			this.lock = argLock;
		}

		@Override
		public void run() {
			synchronized (lock) {
				java.util.stream.Stream.iterate(0, i -> ++i)//
						.limit(10)//
						.forEach(i -> this.resource.synchedIntList.add(i));
			}
		}
	}

	private static class ResourceWithSynchedDSOnly {
		private volatile List<Integer> synchedIntList = Collections.synchronizedList(new ArrayList<Integer>());
		private Set<Float> synchedSet = Collections.synchronizedSet(new HashSet<Float>());
		private Map<Float, Float> synchedMap = Collections.synchronizedMap(new HashMap<Float, Float>());
	}

}
