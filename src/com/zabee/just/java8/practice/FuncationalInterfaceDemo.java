package com.zabee.just.java8.practice;

/**
 * Looks like the () -> is implicit way of creating object of an interface by
 * providing its only undefined but declared method thus
 * called @FunctionalInerface
 * 
 *
 */

public class FuncationalInterfaceDemo {

	public static void main(String[] args) {
		Work work = () -> {
			System.out.println("Doing some work");
		};

		work.dontWork();
		work.gotoWork();
		work.doWork();
	}

}

@FunctionalInterface
interface Work {
	public void doWork();

	default public void dontWork() {
		System.out.println("You lazy bugger");
	}

	default public void gotoWork() {
		System.out.println("Going to go to work place");
	}
}
