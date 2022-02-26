package com.zabee.just.java.concurrent;

public class SleepAndInterrupt {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();

		MyAnotherThread t4 = new MyAnotherThread();
		MyAnotherThread t5 = new MyAnotherThread();
		MyAnotherThread t6 = new MyAnotherThread();

		t1.start();
		t2.start();
		t3.start();
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();

		t4.start();
		t5.start();
		t6.start();

		t4.interrupt();
		t5.interrupt();
		t6.interrupt();
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		try {
			synchronized (this) {
				wait(100000);
			}
		} catch (InterruptedException e) {
			System.out.println("Haha");
			e.printStackTrace();
		}
		System.out.println("MyThread Woke up!!");
	}
}

class MyAnotherThread extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MyAnotherThread Woke up!!");
	}
}
