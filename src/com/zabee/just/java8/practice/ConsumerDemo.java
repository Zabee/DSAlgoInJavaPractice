package com.zabee.just.java8.practice;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String []args) {}
	
	private void okay() {

		Consumer<String> strConsumer = str -> System.out.println(str);
		strConsumer.accept("Print this!!");
	
	}
}
