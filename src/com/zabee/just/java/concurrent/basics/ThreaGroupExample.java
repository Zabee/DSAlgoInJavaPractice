package com.zabee.just.java.concurrent;

// (are obsolete as per Effective Java) see https://stackoverflow.com/questions/3265640/why-threadgroup-is-being-criticised 

public class ThreaGroupExample {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");
		MyThread t1 = new MyThread(threadGroup);
		MyThread t2 = new MyThread(threadGroup);
		t1.start();
		t2.start();
		Thread.sleep(1000);
		
		System.out.println("threadGroup.isDaemon(): " + threadGroup.isDaemon());
	}

	private static class MyThread extends Thread {
		public MyThread(ThreadGroup argThreadGroup) {
			super(argThreadGroup, argThreadGroup.getName());
		}

		@Override
		public void run() {
			System.out.println("Thread is running!!");
		}
	}
}
