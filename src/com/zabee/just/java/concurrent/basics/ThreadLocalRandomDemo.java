package com.zabee.just.java.concurrent;

import java.util.concurrent.ThreadLocalRandom;

import javax.naming.LimitExceededException;

/***
 * ThredLocalRandom is a combination of ThreadLocal and Random. ThreadLocal keep
 * the variable to the current thread where Random is a random generator.
 *
 */
public class ThreadLocalRandomDemo {

	public static void main(String[] args) {
		
		//Just threadlocal
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		threadLocal.set(10);
		System.out.println("Thread local vlaue: " + threadLocal.get());
		threadLocal.remove();
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> System.out.println(ThreadLocalRandom.current().nextInt(100)));
	}

}
