package com.zabee.just.java.concurrent.threadsafetysolutions;

public class ThreadSafetySolutionImmutability {

	public static void main(String[] args) {
		MyImmutableInteger immInt = new MyImmutableInteger(10);
		System.out.println("The immutable integer value is : " + immInt.getValue());
	}

}

final class MyImmutableInteger {
	final private int value;

	public MyImmutableInteger(final int argValue) {
		value = argValue;
	}

	public int getValue() {
		return value;
	}
}