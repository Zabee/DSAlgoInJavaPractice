package com.zabee.just.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatesDemo {

	public static void main(String[] args) throws InterruptedException {

		MyThread myThread = new MyThread();
		System.out.println("Thread state now expected NEW			: " + myThread.getState());
		myThread.start();
		System.out.println("Thread state now expected RUNNABLE		: " + myThread.getState());
		Thread.sleep(10);
		System.out.println("Thread state now expected TIME_WAITING		: " + myThread.getState());
		Thread.sleep(1000);
		System.out.println("Thread state now expected TERMINATED		: " + myThread.getState());

		ReentrantLock lock = new ReentrantLock(true);
		MyAnotherThread myAnotherThread1 = new MyAnotherThread(lock, "Thread1");
		MyAnotherThread myAnotherThread2 = new MyAnotherThread(lock, "Thread2");
		myAnotherThread1.start();
		myAnotherThread2.start();
		Thread.sleep(500);
		System.out.println("myAnotherThread2 state now expected WAITING : " + myAnotherThread2.getState());
		myAnotherThread1.join();
		myAnotherThread2.join();
		
		SomeResource resource = new SomeResource();
		MyAnotherAnotherThread myAnotherAnotherThread1 = new MyAnotherAnotherThread("RomanThreadI", resource);
		MyAnotherAnotherThread myAnotherAnotherThread2 = new MyAnotherAnotherThread("RomanThreadII", resource);
		Thread.sleep(1000);
		System.out.println("myAnotherAnotherThread2 state now expected BLOCKED : " + myAnotherAnotherThread2.getState());
		System.out.println("Go home nothing else here!!");
	}

	private static class SomeResource {
		private int someValue;

		public synchronized int getSomeValue() {
			try {
				wait();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return someValue;
		}

		public synchronized void setSomeValue(int someValue) {
			this.someValue = someValue;
		}
	}

	private static class MyAnotherAnotherThread extends Thread {
		SomeResource someResource;

		public MyAnotherAnotherThread(String name, SomeResource someResource) {
			super(name);
			this.someResource = someResource;
		}
		
		public void run() {
			someResource.getSomeValue();
		}
	}

	private static class MyAnotherThread extends Thread {
		ReentrantLock lock;

		public MyAnotherThread(ReentrantLock lock, String string) {
			super(string);
			this.lock = lock;
		}

		@Override
		public void run() {
			if (lock.tryLock()) {
				System.out.println("Thread " + getName() + " got the lock");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Thread " + getName() + " didn't get the lock. So, blocked!!");
				lock.lock();
			}
			lock.unlock();
		}
	}

	private static class MyThread extends Thread {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
