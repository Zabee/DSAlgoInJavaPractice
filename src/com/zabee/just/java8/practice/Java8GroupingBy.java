package com.zabee.just.java8.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8GroupingBy {

	private static List<Person> people = new ArrayList<>();

	public static void main(String[] args) {
		createPeople();
		// List all people names
		System.out.println(//
				people.stream()//
						.map(Person::getName)//
						.collect(Collectors.toList())//
		);

		// List unique names
		System.out.println(//
				people.stream()//
						.map(Person::getName)//
						.collect(Collectors.toSet())//
		);

		// List people with name and age as key and object as the value
		System.out.println(//
				people.stream()//
						.collect(Collectors//
								.toMap(//
										p -> p.getName() + p.getAge(), //
										Function.identity(), //
										(oldValue, newValue) -> newValue//
								)//
						)//
		);//

		// List people name as the key and list of objects as value. Duplicate
		// values live in that list. For e.g. Sara or Jack in our case
		System.out.println(people.stream()//
				.collect(Collectors.//
						groupingBy(p -> p.getName())));

		// List people name as the key and list of age the value. Duplicate
		// values live in that list. For e.g. Sara or Jack in our case
		System.out.println(//
				people.stream()//
						.collect(Collectors.groupingBy(Person::getName,
								Collectors.mapping(Person::getAge, Collectors.toList()))));
	}

	private static void createPeople() {
		people.add(new Person("Sara", 30, Gender.FEMALE));
		people.add(new Person("Sara", 20, Gender.FEMALE));
		people.add(new Person("Bob", 32, Gender.MALE));
		people.add(new Person("Paula", 24, Gender.FEMALE));
		people.add(new Person("Paul", 21, Gender.MALE));
		people.add(new Person("Jack", 30, Gender.MALE));
		people.add(new Person("Jack", 31, Gender.MALE));
		people.add(new Person("Jill", 19, Gender.MALE));
	}
}

class Person {
	private String name;
	private int age;
	private Gender gender;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return name + ":" + age + ":" + gender + "\n";
	}
}

enum Gender {
	MALE, FEMALE;
}