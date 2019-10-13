package com.zabee.just.java.concurrent;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {

	public static void main(String[] args) {
		int x = ThreadLocalRandom.current().nextInt();
		System.out.println(x);
	}

}
