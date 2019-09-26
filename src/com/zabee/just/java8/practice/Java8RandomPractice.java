package com.zabee.just.java8.practice;

import java.util.List;
import java.util.Arrays;

public class Java8RandomPractice {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(//
				new Person("Zabee", 30, Gender.MALE), //
				new Person("Abu", 36, Gender.MALE), //
				new Person("Umar", 33, Gender.MALE), //
				new Person("Uthman", 32, Gender.MALE), //
				new Person("Aali", 3, Gender.FEMALE), //
				new Person("Sara", 28, Gender.FEMALE)//
		);
		System.out.println("Fist person with age gt 30 Imperative style: " + findFirstPersonNameAgeGt30ImperativeStyle(people));
		System.out.println("Fist person with age gt 30 Not so imperative style : " + findFirstPersonNameAgeGt30NotSoImperativeStyle(people));
		System.out.println("Fist person with age gt 30 Not so imperative style : " + findFirstPersonNameAgeGt30FnStyle(people));
	}

	private static String findFirstPersonNameAgeGt30ImperativeStyle(List<Person> argPeople) {
		for(int i=0; i<argPeople.size(); i++) {
			if(argPeople.get(i).age > 30) {
				return argPeople.get(i).name;
			}
		}
		return "";
	}
	
	private static String findFirstPersonNameAgeGt30NotSoImperativeStyle(List<Person> argPeople) {
		for(Person p : argPeople) {
			if(p.age> 30) {
				return p.name;
			}
		}
		return "";
	}
	
	private static String findFirstPersonNameAgeGt30FnStyle(List<Person> argPeople) {
		return argPeople.stream()//
		.filter(person -> person.age > 380)//
		.map(person -> person.name)//
		.findFirst()//
		.orElse("No one found");
	}

	private static class Person {
		private String name;
		private int age;
		private Gender gender;

		public Person(String argName, int argAge, Gender argGender) {
			name = argName;
			age = argAge;
			gender = argGender;
		}
	}

	private enum Gender {
		MALE, FEMALE;
	}
}