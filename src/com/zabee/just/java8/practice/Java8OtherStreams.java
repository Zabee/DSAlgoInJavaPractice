package com.zabee.just.java8.practice;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Java8OtherStreams {

	public static void main(String[] args) {
		IntStream.iterate(0, i -> (i + 1) % 2)//
		.limit(10)//
		.distinct()//
		.forEach(System.out::println);
		
		System.exit(0);
		System.out.println("========================== IntStream.of(1, 20) only 1 and 20");
		IntStream intStream = IntStream.of(1, 20);
		intStream.forEach(System.out::println);

		System.out.println("========================== IntStream 0 to 10 i++ everytime");
		IntStream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(System.out::println);

		System.out.println("========================== IntStream limit(10) and then skip(4)");
		IntStream.iterate(0, i -> ++i)//
				.limit(10)//
				.skip(4)//
				.forEach(System.out::println);

		System.out.println("========================== LongStream 0 to 10 ++i");
		LongStream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(System.out::println);

		System.out.println("========================== DoubleStream 0 to 10 ++i");
		DoubleStream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(System.out::println);

		System.out.println("========================== IntStream commented infinte loop statement");
		// Danger. This is subtle infinite loop
		IntStream.iterate(0, i -> (i + 1) % 2)//
//				.distinct()//
				.limit(10)//
				.forEach(System.out::println);

		System.out.println("==========================");
//		for (int i = 0; i < 10; i = (i + 1) % 2) {

//		}
		System.out.println("========================== skip(5) then limit(10)");
		IntStream.iterate(1, i -> ++i)//
				.skip(5)//
				.limit(10)//
				.forEach(System.out::println);

		System.out.println("========================== limit(10) then skip(5)");
		IntStream.iterate(1, i -> ++i)//
				.limit(10)//
				.skip(5)//
				.forEach(System.out::println);

		System.out.println("========================== range(0, 10)");
		IntStream.range(0, 10)//
				.forEach(System.out::println);

		System.out.println("========================== range(0,10) peek(sysout).peek(..)");
		IntStream.range(0, 10)//
				.peek(System.out::println)//
				.peek(i -> {
					if (i == 5)
						throw new RuntimeException("Boom");
				})//
				.forEach(i -> i++);
	}
}