package com.zabee.just.java8.practice;

import java.util.function.Consumer;
import java.util.*;

public class ConsumerFnInterfaceDemo {
	public static void main(String []args) {
		Consumer<Integer> strConsumer = str -> System.out.print(str + "\t");
		justPrint(strConsumer);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.forEach(strConsumer);
	}
	
	private static void justPrint(Consumer<Integer> strConsumer) {
	    System.out.print("Simply printing: ");
		strConsumer.accept(10);
		System.out.println();
	}
}
/** Output
	Simply printing: 10	
	1	2	3	4	5	6
**/
