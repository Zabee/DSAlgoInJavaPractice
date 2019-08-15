package com.zabee.just.java8.practice;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Java8PredicateUnaryBinaryOperatorDemo {

	public static void main(String[] args) {

		Predicate<Integer> intPredicate = x -> x != null;
		System.out.println(intPredicate.test(10));
		System.out.println(intPredicate.test(null));

		UnaryOperator<Double> unaryDoubleOperator = (doubleNum) -> ++doubleNum;
		System.out.println(unaryDoubleOperator.apply(10.00d));

		BinaryOperator<String> strBinOperator = (str1, str2) -> str1;
		System.out.println(strBinOperator.apply("Zabee", "Ulla"));

		Function<String, String> strBinAddressOperator = (str1) -> str1 + " ";
		strBinOperator.andThen(strBinAddressOperator);

		// Functional composition
		Predicate<String> startsWith = (str1) -> str1.startsWith("A");
		Predicate<String> endsWith = (str2) -> str2.endsWith("x");

		Predicate<String> startsAndEndsWith = (str) -> startsWith.test(str) && endsWith.test(str);

		System.out.println(startsAndEndsWith.test("A hardworking person should cool down his brain and relax"));

		Predicate<String> andComposed = (str) -> startsWith.and(endsWith).test(str);
		System.out.println(andComposed.test("A hardworking person should cool down his brain and relax"));

		Predicate<String> orComposed = (str) -> startsWith.and(endsWith).test(str);
		System.out.println(orComposed.test("A hardworking person should cool down his brain and relax"));

		Predicate<String> negatePred = startsWith.negate().negate();
		System.out.println(negatePred.test("A hardworking person should cool down his brain and relax"));

		Function<String, Integer> strToInt = (intStr) -> Integer.valueOf(intStr);
		Function<Integer, Integer> intPlus20 = (integer) -> integer + 20;

		Function<String, Integer> intToStringPlus20 = strToInt.andThen(intPlus20);

		System.out.println(intToStringPlus20.apply("10"));

		Function<Integer, String> intToStr = (someInt) -> String.valueOf(someInt);
		Function<String, String> addCurrencySymbol = (str) -> str.concat("RS/-");

		Function<Integer, String> intToStrThenAddCurrencySymbol = addCurrencySymbol.compose(intToStr);
		System.out.println(intToStrThenAddCurrencySymbol.apply(10));
	}
}
