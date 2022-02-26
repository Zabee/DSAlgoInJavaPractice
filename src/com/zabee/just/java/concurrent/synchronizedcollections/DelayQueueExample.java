package com.zabee.just.java.concurrent;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

	public static void main(String[] args) {
		DelayQueue<Delayed> delayeQueue = new DelayQueue<>();
		new Thread(new Producer(delayeQueue)).start();
		new Thread(new Consumer(delayeQueue)).start();
	}

	private static class DelayedElement implements Delayed {
		private String element;
		private LocalDateTime activationDateTime;

		public DelayedElement(String argElement, LocalDateTime argNow) {
			this.element = argElement;
			this.activationDateTime = argNow;
		}

		public String getElement() {
			return element;
		}

		@Override
		public int compareTo(Delayed that) {
			long result = this.getDelay(TimeUnit.NANOSECONDS) - that.getDelay(TimeUnit.NANOSECONDS);
			if (result < 0) {
				return -1;
			} else if (result > 0) {
				return 1;
			}
			return 0;
		}

		@Override
		public long getDelay(TimeUnit argTimeUnit) {
			LocalDateTime now = LocalDateTime.now();
			long diff = now.until(activationDateTime, ChronoUnit.MILLIS);
			return argTimeUnit.convert(diff, TimeUnit.MILLISECONDS);
		}

	}

	private static class Producer implements Runnable {
		DelayQueue<Delayed> itemsQueue;

		public Producer(DelayQueue<Delayed> argItemsQueue) {
			itemsQueue = argItemsQueue;
		}

		@Override
		public void run() {
			try {
				LocalDateTime now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Water", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Toothpaste", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Toothbrush", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Shampoo", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Perfume", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Clothes", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Footwear", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Bike", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Road", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Traffic", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Water", now));
				now = LocalDateTime.now();
				itemsQueue.put(new DelayQueueExample.DelayedElement("Office", now));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	private static class Consumer implements Runnable {
		DelayQueue<Delayed> itemsQueue;

		public Consumer(DelayQueue<Delayed> itemsQueue2) {
			itemsQueue = itemsQueue2;
		}

		@Override
		public void run() {
			Collection<? super Delayed> events = new ArrayList<>();
			itemsQueue.drainTo(events);
	        System.out.println("\nEvent processing start **********\n");
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        events.stream().forEach(System.out::println);
	        System.out.println("\nEvent processing end **********\n");
		}

	}

}
