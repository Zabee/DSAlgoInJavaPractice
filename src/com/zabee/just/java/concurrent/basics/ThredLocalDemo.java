package com.zabee.just.java.concurrent;

/**
 * Don't use ThreadLocal with ExecutorService for the fact that the values that
 * ThreadLocal holds may gets shared and mixed-up as there is no control over
 * thread creation and its lifecycle in your hand
 * 
 * @author Zabee
 *
 */
public class ThredLocalDemo {

	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		threadLocal.set(19);
		System.out.println(threadLocal.get());
		threadLocal.remove();
		System.out.println(threadLocal.get());
	}
}
