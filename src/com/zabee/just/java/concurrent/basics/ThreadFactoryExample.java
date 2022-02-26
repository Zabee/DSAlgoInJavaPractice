package com.zabee.just.java.concurrent;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {

	public static void main(String[] args) {
		MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
		myThreadFactory.newThread(() -> System.out.println("Simple thread" +  Thread.currentThread().getName())).start();;
	}

	private static class MyThreadFactory implements ThreadFactory {
		private String threadFactName;
		private int id;

		public MyThreadFactory(String argThreadFactName) {
			this.threadFactName = argThreadFactName;
		}

		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, threadFactName + "_Thread_" + id++);
		}
	}
}
