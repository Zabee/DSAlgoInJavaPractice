package com.zabee.just.java8.practice;
import java.util.function.Supplier;

public class Java8SomeMore {

	private static void beautify(Supplier<String> supplierFunc) {
		System.out.println(supplierFunc.get());
	}
	public static void main(String[] args) {
		String uglyStr = " zabee ulla ";
		//This is closure
		beautify(() -> uglyStr.trim().replace('z', 'Z').replace('u', 'U'));
	}

}