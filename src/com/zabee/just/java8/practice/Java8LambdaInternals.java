package com.zabee.just.java8.practice;

import java.util.function.Consumer;

public class Java8LambdaInternals {

	public static void main(String []args) {}
	
	private void okay() {

		Consumer<String> strConsumer = str -> System.out.println(str);
		strConsumer.accept("Print this!!");
	
	}
}
