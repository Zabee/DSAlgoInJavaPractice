package com.zabee.just.java.concurrent;

public class DaemonThreadExample {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Some random thread. Am I daemon? ");
		})

		;
		t.setDaemon(true);
		t.start();
//		t.join();
		System.out.println("Is alive? : " + t.isAlive());
		if (t.isAlive()) {
			System.out.println("Is daemon? " + t.isDaemon());
		} else {
			System.out.println("Was daemon? " + t.isDaemon());
		}
	}

}
