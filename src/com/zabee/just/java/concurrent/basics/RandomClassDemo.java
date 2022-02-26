package com.zabee.just.java.concurrent;

import java.util.Random;

public class RandomClassDemo {

	public static void main(String[] args) {
		Random randomGenerator = new Random();
		System.out.println("Random numbers within 100");

		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.forEach(i -> System.out.println(randomGenerator.nextInt(100)));
	}

}
