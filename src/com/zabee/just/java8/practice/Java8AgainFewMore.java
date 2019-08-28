package com.zabee.just.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8AgainFewMore {

	private static class Employee {
		public Employee(int argEmpId, String argEmpName) {
			empId = argEmpId;
			empName = argEmpName;
		}

		private int empId;
		private String empName;

		@Override
		public String toString() {
			return empId + ":" + empName;
		}
	}

	public static void main(String[] args) {
		
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

	    List<Integer> collect = infiniteStream
	      .skip(3)
	      .limit(5)
	      .collect(Collectors.toList());
	    collect.forEach(System.out::println);
	    System.exit(0);
	    
		List<List<String>> namesNested = Arrays.asList(//
				Arrays.asList("Zabee", "Zabi"), //
				Arrays.asList("ZAB", "ZB"), //
				Arrays.asList("JB", "ZABEE"), //
				Arrays.asList("ZABI", "ZAB")//
		);

		Stream<String> allNamesStream = namesNested.stream().flatMap(list -> list.stream());
		List<String> allNamesList = Arrays.asList(allNamesStream.toArray(String[]::new));
		for(String name : allNamesList) {
			System.out.println(name);
		}
		System.exit(0);
		
		Stream.Builder<Employee> streamBuilder = Stream.builder();
		streamBuilder.accept(new Employee(1, "Zabee"));
		streamBuilder.accept(new Employee(2, "Zabi"));
		streamBuilder.accept(new Employee(3, "ZB"));
		streamBuilder.accept(new Employee(4, "JB"));
		streamBuilder.accept(new Employee(5, "ZABEE"));
		Stream<Employee> streamEmployee = streamBuilder.build();

		System.out.println(//
				streamEmployee.distinct()//
						.findFirst()//
						.get()//
		);
		Employee[] empArray = { new Employee(1, "Zabee"), new Employee(2, "Tom"), new Employee(3, "John"),
				new Employee(4, "Daniel") };
		streamEmployee = Stream.of(empArray);
		System.out.println(//
				streamEmployee.distinct()//
						.min((emp1, emp2) -> Integer.valueOf(emp1.empName.length()).compareTo(emp2.empName.length()))//
						.get()//
		);

		Stream<Employee> strEmp = Stream.of(empArray);
		strEmp.forEach(System.out::println);
		List<String> someNames = Arrays.asList("Zabee", "Tom", "John", "Daniel", "Charles", "Andrew", "Aimee", "Zabee");
		someNames.stream().distinct().forEach(System.out::println);

		List<String> otherNames = Arrays.asList("Zabee", "Tom", "John", "Daniel", "Charles", "Andrew", "Aimee",
				"Zabee");
		Stream<String> allNames = Stream.concat(someNames.stream(), otherNames.stream());
		Optional<String> oneName = allNames.reduce((value, accumulator) -> value + accumulator);
		System.out.println("Reduced i.e. concatinated: " + oneName.get());

		System.out.println("*************************************");
		String[] nameArray = someNames.stream().toArray(String[]::new);
		Stream.of(nameArray).forEach(System.out::println);
		System.exit(0);

		Optional<String> oneStr = someNames.stream().reduce((value, accumulator) -> value + accumulator);
		System.out.println(oneStr.get());

		Optional<String> shortestName = someNames.stream()
				.min((name1, name2) -> Integer.valueOf(name1.length()).compareTo(name2.length()));
		System.out.println("Shortest Name: " + shortestName.get());

		Optional<String> longestName = someNames.stream()
				.max((name1, name2) -> Integer.valueOf(name1.length()).compareTo(name2.length()));
		System.out.println("Longest Name: " + longestName.get());

		if (someNames.stream().anyMatch(name -> name.equals("Zabee"))) {
			System.out.println("Yes, there is Zabee");
		}

		if (someNames.stream().allMatch(name -> name.contains("a") || name.contains("o") || name.contains("e"))) {
			System.out.println("Yes");
		}

		if (someNames.stream().noneMatch(name -> name.charAt(0) == 'X')) {
			System.out.println("Yes, there no one's name starting with X");
		}

		String[] names = { "Zabee", "Tom", "John", "Daniel", "Charles", "Andrew", "Aimee", "Zabee" };
		final String vowels = "AEIOU";
		// FlatMap
		String[][] firstAndListname = { { "Zabee", "Ulla" }, { "Thomas", "Edison" }, { "Aimee", "Thomson" },
				{ "Charles", "Babbage" }, { "Andrew", "Giant" } };

		Stream<String[]> streamStr = Stream.of(firstAndListname);
		Stream<String[]> streamStr2 = streamStr.filter(str -> str.equals("Zabee"));
		streamStr2.forEach(System.out::println);

		streamStr = Stream.of(firstAndListname);
		Stream<String> someStream = streamStr.flatMap(str -> Arrays.stream(str));
		someStream.forEach(System.out::println);

		Stream<String> strStream = Stream.of(names);
		// Filter, Map, Distinct,
		Optional<String> isFound = strStream.map(str -> str.toUpperCase())//
				.filter(str -> str.equals("ZABEE"))//
				.findAny();
		System.out.println(isFound.orElse("Not found"));

		strStream = Stream.of(names);
		System.out.println("Total distinct names: " + strStream.distinct().count());

		strStream = Stream.of(names);
		long namesWithVowels = strStream.map(str -> str.charAt(0))//
				.filter(ch -> vowels.indexOf(ch) != -1)//
				.count();
		System.out.println(namesWithVowels);
		// Limit
		strStream = Stream.of(names);
		strStream.limit(2).forEach(System.out::println);

		System.out.println("=======================");
		// Print and collect at the same time then PEEK is the answer
		strStream = Stream.of(names);
		List<String> nameList = strStream.filter(str -> vowels.indexOf(str.charAt(0)) == -1)// Get only consonant names
				.peek(System.out::println)//
				.collect(Collectors.toList());
		System.out.println("Total consonant names :" + nameList.stream().count());
	}

}
