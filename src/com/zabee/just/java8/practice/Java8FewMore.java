package com.zabee.just.java8.practice;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Java8FewMore {

	public static void main(String[] args) {
		List<String> numberList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
		CopyOnWriteArrayList<String> numbersStr = new CopyOnWriteArrayList<String>(numberList); 
		numbersStr.removeIf(num -> num.equals("5"));
		int sum1To9 = numbersStr.stream()//
		.mapToInt(Integer::valueOf)//
		.sum();
		System.out.println(sum1To9);
		
		List<String> students = Arrays.asList("Fabia", "Bob", "Doug", "Amy", "Charlse", "Emily");
		students.stream()//
				.sorted((s1, s2) -> s1.compareTo(s2))//
				.forEach(System.out::println);
		System.exit(0);

		List<Object> heterogeneousList = Arrays.asList(1, 2, " Three ", " IV", 5.0, 6.0f);

		heterogeneousList.stream()//
				.filter(String.class::isInstance)//
				.map(String.class::cast)//
				.map(String::trim)//
				.forEach(System.out::println);

		// Eager or strict evaluation example
		List<Integer> numberss = Arrays.asList(1, 2, 3 / 0, 4);
		System.out.println(numberss.size());
		System.exit(0);

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

		// To demonstrate lazy aka efficient performance. Nothing executes unless
		// termination function executed
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
