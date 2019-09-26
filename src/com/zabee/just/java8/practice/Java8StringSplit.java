package com.zabee.just.java8.practice;

import java.util.Arrays;
import java.util.List;

public class Java8StringSplit {

	public static void main(String[] args) {
		String name = "boo:and:foo";
		String[] names = name.split("o");
		String one = "192", two = "168", three = "0", four = "3";
		String oneName =  String.join(".",one, two, three, four);
		List<String> listOfName = Arrays.asList("Zabee", "Umar", "Abu", "Usman", "Ali");
		String someNames = String.join("|", listOfName);
		System.out.println(someNames);
		System.out.println(oneName);
		for(String s : names) {
			System.out.println(s);
		}
	}

}
