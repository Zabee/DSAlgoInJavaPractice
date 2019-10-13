package com.zabee.just.java.concurrent;

import java.util.Arrays;
import java.util.List;

/**
 * Message lookup prints the message until few time limit. If counldn't complete
 * within given time it should be interrupted
 */
public class ThreadProblem2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting main");
		Thread msgLookupThread = new Thread(new MessageLookupThread());
		msgLookupThread.start();
		System.out.println("In main!!");
		long startTime = System.currentTimeMillis();
		long time = 6_000;
		while (msgLookupThread.isAlive()) {
			if (System.currentTimeMillis() - startTime > time) {
				msgLookupThread.interrupt();
				msgLookupThread.join();
				break;
			}
		}
		System.out.println("Main treminated!!");

	}
}


class MessageLookupThread extends Thread {

	@Override
	public void run() {
		List<String> messages = Arrays.asList("Message", "lookup", "prints", "the", "message", "until", "few",
				"time", "limit.", "If", "counldn't", "complete", "within", "given", "time", "it", "should", "be",
				"interrupted");
		try {

			for (String msg : messages) {
				System.out.println("Printing message : " + msg);
				Thread.sleep(4000);
			}
		} catch (InterruptedException e) {
			System.out.println("I am interrupted. Time out for me " + Thread.currentThread().getName());
		}
	}
}