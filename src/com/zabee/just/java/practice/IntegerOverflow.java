package com.zabee.just.java.practice;

public class IntegerOverflow {

	public static void main(String[] args) {
		boolean isGood = true;
		Boolean boolObj = Boolean.valueOf("true");
		if (isGood == boolObj) {
			System.out.println("Can be compared");
		}

		Integer integer = new Integer(Integer.MIN_VALUE);
		System.out.println(integer);
	}

}
