package com.zabee.just.java.practice;

import java.lang.reflect.Method;

public class Operations {
	
	public double publicSum(int a, double b) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		try {
			System.out.println(stackTraceElements[0].getMethodName());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a + b;
		
	}

	public static double publicStaticMultiply(float a, long b) {
		return a * b;
	}

	private boolean privateAnd(boolean a, boolean b) {
		return a && b;
	}

	protected int protectedMax(int a, int b) {
		return a > b ? a : b;
	}
}
