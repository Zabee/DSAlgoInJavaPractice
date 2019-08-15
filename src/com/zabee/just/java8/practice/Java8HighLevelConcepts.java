package com.zabee.just.java8.practice;

import java.io.File;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

@FunctionalInterface
interface SimpleStringOp {
	public String strConcat(String s1, String s2);
}

@FunctionalInterface
interface MyFunction<T, R> {
	R apply(T t);
}

class Employee {
	private String salary;

	public Employee(String argSalary) {
		salary = argSalary;
	}

	public String getSalary() {
		return salary;
	}
}

public class Java8HighLevelConcepts {

	private static <T, R> R tryMe(MyFunction myFunc, T argT) {
		return (R) myFunc.apply(argT);

	}

	public static void main(String[] args) {
//		someRandomRelatedTBasichings();
//		higherOrderFunctions(()->20000.0);
//		lambdaExamples();
		List<String> numsStr = Arrays.asList("One", "Two", "Three", "One");
		Stream<String> numsStrStream =  numsStr.stream();

		numsStrStream.peek(System.out::println);
		System.exit(0);
		
		numsStr.stream()//
			.map(String::toUpperCase)//
			.distinct()//
			.forEach(str -> System.out.println(str));
		
		numsStr.stream()//
			.map(String::toUpperCase)//
			.map(String::trim)//
			.map(str -> str.subSequence(0, 2))//
			.forEach(System.out::println);
		System.out.println("================================================");
		numsStr.stream()
		.limit(1)
		.forEach(System.out::println);
//		System.out.println(lowerCaseStream.count());
		System.exit(0);
		

		List<Employee> empList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			empList.add(new Employee(String.valueOf(++i)));
		}
		Stream<Employee> empListStream = Stream.of(empList.get(0), empList.get(1), empList.get(2), empList.get(3));

		int sumOfSalaries = empListStream//
				.map(emp -> emp.getSalary())//
				.map(strSalary -> Integer.valueOf(strSalary + "1"))//
				.reduce(0, (tempSum, actualValue) -> tempSum + actualValue);

		System.out.println(sumOfSalaries);
		System.exit(0);

		List<Character> lowerChars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
		Stream<Character> lowerCharsStream = lowerChars.stream();
		Stream<Character> upperCharsStream = lowerCharsStream.map(ch -> Character.toUpperCase(ch));
		upperCharsStream.forEach(System.out::print);

		System.out.println();
		lowerChars.stream().map(Character::toUpperCase).map(Character::toLowerCase).map(Character::toUpperCase)
				.forEach(System.out::print);

		System.exit(0);

		List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6, 3, 7, 8, 1, 2, 6);
		Stream<Integer> intStream = intList.stream();
		intStream.forEach(System.out::println);
		System.out.println(intStream.allMatch(num -> num < 10));

		Function<Integer, Integer> bitCntFn = Integer::bitCount;
		System.out.println(bitCntFn.apply(3));

		System.exit(-1);
		String name = "Zabee";
		Consumer<String> nameConsumer1 = String::new;
		Consumer<String> nameConsumer2 = (s) -> new String(s);
		Function<Integer, Integer> func = name::codePointBefore;

		System.out.println(func.apply(3));

		Integer result1 = tryMe(x -> Integer.valueOf(x.toString()) * 2, 2);
		System.out.println(result1);
		Integer result2 = tryMe(x -> Integer.valueOf(x.toString()) * 2, 3);
		System.out.println(result2);

		List<String> nameList = Arrays.asList("Zabee", "York", "Woods", "Xavier", "Sabrina", "Linda", "Laura");
		Comparator<String> nameComparator = String::compareTo;
		nameList.sort(nameComparator);
		nameList.forEach(System.out::println);
		// Above statement is equals to the below one. But the above one is shortest
		// hand :D
		nameList.sort(nameComparator.reversed());
		nameList.forEach(System.out::println);

		IntStream.range(0, 20).mapToObj(i -> "=").forEach(System.out::print);
		System.out.println();
		IntStream.range(0, 10).forEach(System.out::println);
	}

	private static void lambdaExamples() {
		SimpleStringOp sso1 = (s1, s2) -> s1 + s2;
		SimpleStringOp sso2 = (s1, s2) -> s1.concat(s2);
		SimpleStringOp sso3 = String::concat;
		System.out.println(sso3.strConcat("Blah ", "Black"));
		higherOrderFn(() -> System.out.println("This is thread"));
		File file = new File(System.getProperty("user.dir"));
		File[] files = file.listFiles(pathName -> pathName.toString().contains(".xml"));
		Arrays.asList(files).stream().map(f -> f.getName()).forEach(System.out::println);
	}

	private static void higherOrderFn(Runnable obj) {
		obj.run();
		// Below statement you right!! You are passing an anonymous object of Runnable
		// interface
		new Thread(() -> System.out.println("Wah wah wah")).run();
	}

	private static void higherOrderFunctions(SomeOtherStuff SOS) {
		List<String> nameList = Arrays.asList("Zabee", "Rocky", "Elon", "Mike", "John", "Andy", "Abdul", "Bret");
//		Collections.sort(nameList, null);
		Comparator<String> strComparator = (name1, name2) -> name1.compareTo(name2);
		nameList.sort(strComparator.reversed());
		nameList.forEach(System.out::println);
//		Collections.sort(list, null);
		System.out.println("Your payment is :" + SOS.doSomethingElseAndPaid());
	}

	private static void someRandomRelatedTBasichings() {

		List<Integer> integerList = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1);
		Collections.sort(integerList);
		integerList.forEach(i -> System.out.println(i));
		Comparator<Integer> intComparator = (x, y) -> x.compareTo(y);
		Comparator<Integer> intReversed = intComparator.reversed();
		Collections.sort(integerList, intReversed);
		integerList.forEach(i -> System.out.println(i));
		List<Character> characters = Arrays.asList('z', 'a', 'b', 'e', 'e');
		characters.stream().map(Java8HighLevelConcepts::transformToUpper)
				.forEach(character -> System.out.println(character));

		integerList.stream().reduce((i1, i2) -> i1 + i2).ifPresent(System.out::println);

		getTheWorkDone(() -> 20.0);

	}

	private static Character transformToUpper(Character argChar) {
		return Character.toUpperCase(argChar);
	}

	private static void getTheWorkDone(SomeStuff argSomeStuff) {
		System.out.println("Work done and paid $ " + argSomeStuff.doSomethingAndPaid());
	}
}

@FunctionalInterface
interface SomeOtherStuff {
	// Impure function
	public static String state = "Open";

	public double doSomethingElseAndPaid();
}

@FunctionalInterface
interface SomeStuff {
	public double doSomethingAndPaid();
}
