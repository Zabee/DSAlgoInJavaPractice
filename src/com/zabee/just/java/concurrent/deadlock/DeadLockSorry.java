package com.zabee.just.java.concurrent.deadlock;

public class DeadLockSorry {

	public static void main(String[] args) {
		//THINK TWICE BEFORE RUNNING INFINITELY RUNNING CODE. 
		//WARNING: MAY DAY MAY DAY DEADLOCK DEADLOCK 
		Resource r1 = new Resource(10);
		Resource r2 = new Resource(20);
		MyThread1 myThread1 = new MyThread1(r1, r2);
		MyThread2 myThread2 = new MyThread2(r1, r2);
		myThread1.start();
		myThread2.start();
	}

	private static class MyThread1 extends Thread {
		Resource r1;
		Resource r2;

		public MyThread1(Resource r1, Resource r2) {
			this.r1 = r1;
			this.r2 = r2;
		}

		@Override
		public void run() {
			System.out.println("Let's wait for other resource");
			synchronized (r1) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (r2) {
				}
			}
			System.out.println("Got thre resource. Done!");
		}
	}

	private static class MyThread2 extends Thread {
		Resource r1;
		Resource r2;

		public MyThread2(Resource r1, Resource r2) {
			this.r1 = r1;
			this.r2 = r2;
		}

		@Override
		public void run() {
			System.out.println("Let's wait for other resource");
			synchronized (r2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (r1) {
				}
			}
			System.out.println("Got thre resource. Done!");
		}
	}
	private static class Resource {
		private int numValue;

		public Resource(final int argNumValue) {
			this.numValue = argNumValue;
		}

		public int getNumValue() {
			return numValue;
		}
	}
}
