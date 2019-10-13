package com.zabee.just.java.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationUsingLocks {

	public static void main(String[] args) {
		ItemBox itemBox = new ItemBox();
		Producer producer = new Producer(itemBox);
		Consumer consumer = new Consumer(itemBox, producer);

		producer.start();
		consumer.start();
	}

	private static class ItemBox {
		private String item;
		private boolean isEmpty = true;
		private ReentrantLock reentrantLock = new ReentrantLock();
		private Condition condition = reentrantLock.newCondition();

		public synchronized String getItem() {
			reentrantLock.lock();
			try {
				if (isEmpty) {
					try {
						condition.await();
					} catch (InterruptedException e) {
//					e.printStackTrace();
					}
				}
				isEmpty = true;
				return item;
			} finally {
				condition.signalAll();
				reentrantLock.unlock();
			}
		}

		public void putItem(String item) {
			reentrantLock.lock();
			try {
				if (!isEmpty) {
					try {
						condition.await();
					} catch (InterruptedException e) {
//						e.printStackTrace();
					}
				}
				this.item = item;
				isEmpty = false;
			} finally {
				condition.signalAll();
				reentrantLock.unlock();
			}
		}
	}

	private static class Producer extends Thread {
		private List<String> items = Arrays.asList("Water", "ToothBrush", "Toothpaste", "Soap", "Shampoo", "Towel",
				"Clothes", "Breakfast");
		private ItemBox itemBox;

		public Producer(ItemBox argItemBox) {
			this.itemBox = argItemBox;
		}

		@Override
		public void run() {
			for (String item : items) {
				itemBox.putItem(item);
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
//					e.printStackTrace();
				}
			}
		}
	}

	private static class Consumer extends Thread {
		private ItemBox itemBox;
		private Producer producer;

		public Consumer(ItemBox argItemBox, Producer argProducer) {
			itemBox = argItemBox;
			producer = argProducer;
		}

		@Override
		public void run() {
			while (producer.isAlive()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
//					e.printStackTrace();
				}
				System.out.println(itemBox.getItem());
			}
		}
	}
}
