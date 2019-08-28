package com.zabee.just.java8.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8SomeNewThingsToday {

	public static void main(String[] args) {
		BiFunction<String, String, String> biFunc = (firstName, lastName) -> new String("Mr. " + firstName + lastName);
		System.out.println(biFunc.apply("Zabee ", "Ulla"));
		
		Function<String, Function<String, String>> nestedFunc = str1 -> str2 -> new String("Mr." + str1 + str2);
		System.out.println(nestedFunc.apply("Zabee ").apply("Ulla"));
		System.exit(0);

		Optional<String> emptyOpt = Optional.ofNullable("g");
		System.out.println(emptyOpt.orElseGet(() -> "Take this"));
		emptyOpt.ifPresent(System.out::println);

		System.out.println("==============================");
		System.out.println(Optional.ofNullable(null).orElse("Take this"));
		System.out.println(Optional.ofNullable(null).orElseGet(() -> "Take this"));

		System.out.println(Optional.ofNullable("G").orElse("Take this"));
		System.out.println(Optional.ofNullable("G").orElseGet(() -> "Take this"));
		System.out.println("===============================");

		Optional<String> predator = Optional.ofNullable("Loin is here!!").map(str -> str.replace("Loin", "Tiger"));
		Employee employeee = new Employee(1234, "SomeName", 12.0);
		Optional<String> position = Optional.ofNullable(employeee).flatMap(u -> Optional.of(u.empName));
		Optional<String> outputStr = Optional.ofNullable("Some String").filter(str -> str != null);
		System.out.println(outputStr.get());
		System.out.println(predator.get());

		Optional.ofNullable(null).orElseThrow(() -> new IllegalArgumentException());
		Optional.ofNullable(null).orElseThrow(() -> new UnsupportedOperationException());
		System.exit(0);
		// IntStream.of(0, 1).forEach(System.out::println);
//		IntStream.range(0, 10).forEach(System.out::println);
		Stream.of(1, 2, 3, 5, 6).mapToInt(i -> i).forEach(System.out::println);
		System.out.println(Stream.of(1, 2, 3, 4, 5, 6).mapToInt(i -> i).max().getAsInt());
		System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).sum());
		System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).average());
		System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).min());
		System.out.println(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max());
		// Stream.iterate(0, i->++i)//
//		.limit(10)//
//		.forEach(i-> System.out.println(i));
		Stream.iterate(0, i -> ++i)//
				.limit(10)//
				.skip(3).forEach(i -> System.out.println(i));

		List<Employee> empList = Arrays.asList(new Employee(99, "Zabee", 1.0), new Employee(1, "Abu", 1.0),
				new Employee(2, "Umer", 3.0), new Employee(3, "Udan", 5.0), new Employee(4, "Amy", 5.0),
				new Employee(0, "Someone", 0.0));
		empList.sort((e1, e2) -> Integer.valueOf(e1.empId).compareTo(e2.empId));

		empList.stream()//
				.sorted((e1, e2) -> Integer.valueOf(e1.empId).compareTo(e2.empId))//
				.filter(e -> e.empId > 0)//
				.forEach(System.out::println);

		empList.stream().forEach(System.out::println);

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
		boolean someItemIsLT10 = integers.stream().anyMatch(i -> i < 10);
		boolean allAreLT10 = integers.stream().allMatch(i -> i < 10);
		boolean nonIsLessThan10 = integers.stream().noneMatch(i -> i > 10);

		System.out.println("At least one item is less than 10? :" + someItemIsLT10);
		System.out.println("Every item is less than 10? :" + allAreLT10);
		System.out.println("None is greater than 10? :" + nonIsLessThan10);
		double sumOfSalaries = empList.stream()//
				.map(e -> e.salary)//
				.reduce(0.0, (salary, carrySal) -> salary + carrySal)//
				.doubleValue();
		System.out.println("Sum of all employee salaries : " + sumOfSalaries);

		String allEmpNames = empList.stream()//
				.map(emp -> String.valueOf(emp.salary))//
				.collect(Collectors.joining("	:	"));//
		System.out.println("allEmpNames: " + allEmpNames);

		Set<String> salaries = empList.stream()//
				.map(emp -> String.valueOf(emp.salary))//
				.collect(Collectors.toCollection(HashSet::new));//
		salaries.stream().forEach(System.out::println);

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		Map<Boolean, List<Integer>> evenNumList = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println("Even numbers");
		evenNumList.get(Boolean.TRUE).stream().forEach(System.out::println);

		System.out.println("odd numbers");
		evenNumList.get(Boolean.FALSE).stream().forEach(System.out::println);

	}

	private static class Employee {
		private int empId;
		private String empName;
		private double salary;

		public Employee(int empId, String empName, double salary) {
			this.empId = empId;
			this.empName = empName;
			this.salary = salary;
		}

		@Override
		public String toString() {
			return empId + ":" + empName;
		}
	}
}
