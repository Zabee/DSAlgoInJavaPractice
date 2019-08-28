package com.zabee.just.java8.practice;

import java.util.*;

public class Java8FewMore {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		// Given an ordered list find the double of the first even number greater than
		// 3.
		int doubledRes = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) > 3 && numbers.get(i) % 2 == 0) {
				doubledRes = numbers.get(i) * 2;
				break;
			}
		}

		doubledRes = numbers.stream()//
				.filter(n -> n > 3)//
				.filter(n -> n % 2 == 0)//
				.map(n -> n * 2)//
				.findFirst()//
				.get();//
		
		//To demonstrate lazy aka efficient performance. Nothing executes unless termination function executed 
		doubledRes = numbers.stream()//
				.filter(Java8FewMore::isGT3)//
				.filter(Java8FewMore::isEven)//
				.map(Java8FewMore::doubleIt)//
				.findFirst()//
				.get();//

		System.out.println(doubledRes);
	}

	public static boolean isGT3(int number) {
		System.out.println("isGT3" + number);
		return number > 3;
	}

	public static boolean isEven(int number) {
		System.out.println("isEven" + number);
		return number % 2 == 0;
	}

	public static int doubleIt(int number) {
		System.out.println("doubleIt" + number);
		return number * 2;
	}

}
