package com.zabee.just.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class Java8MethodReferencesDemo {

	public static void main(String[] args) {

		//1. Static method references
//		statiMethodReferences();
		//2. Instance method references
//		instanceMethodReference();
		//3. Unbound non-static methods
//		unboundNonStaticMethodReference();
		//4. Constructors
//		constructorMethodReferences();
		Java8MethodReferencesDemo java = new Java8MethodReferencesDemo();
		Consumer<Integer> multi = java::add;
		
		BiFunction<Java8MethodReferencesDemo, Integer, Integer> java8 = Java8MethodReferencesDemo::add;
		java8.apply(new Java8MethodReferencesDemo(), 10);
//		multi.apply(new Java8MethodReferencesDemo());
		Function<Java8MethodReferencesDemo, Integer> java08 = Java8MethodReferencesDemo::sub;
		java08.apply(new Java8MethodReferencesDemo());
		
	}
	
	public int sub() {
		return 0;
	}
	
	public  int add(int x) {
		return 0;
	}
	
	private static void constructorMethodReferences() {
		Supplier<String> strinConstrcotr1 = () -> new String();
		Supplier<String> strinConstrcotr2 = String::new;
		
		Supplier<int[]> intPrimArray1 = () -> new int[2];
		IntFunction<float[]> intPrimArray2 = float[]::new;
	}

	private static void unboundNonStaticMethodReference() {
		Function<String, String> unboundedNonStatic = String::trim;
		System.out.println(unboundedNonStatic.apply(" Zabee is not lier at all like others  "));
	}
	
	private static void instanceMethodReference() {
		String name = " Zabee Ulla ";
		Supplier<String> strTrimFunc = name::trim;
		System.out.println(strTrimFunc.get());
		
		
		Integer integer = Integer.valueOf(1111);
		Supplier<Byte> intByteFn =  integer::byteValue;
		System.out.println(intByteFn.get());
	
	}
	
	private static void statiMethodReferences() {
		Function<Integer, Integer> intBitCountFn =  Integer::bitCount;
		System.out.println(intBitCountFn.apply(3));
		
		
		Consumer<int[]> intArraysConsumer = Arrays::sort;
		int [] intArray = {9, 6, 5, 1, 2, 4, 3, 9};
		intArraysConsumer.accept(intArray);
		
		for(int x : intArray){
			System.out.println(x);
		}
		
		Consumer<List<String>> namesSortConsumer = (names) -> Collections.sort(names, (str1, str2) -> str1.compareTo(str2));
		List<String> names = Arrays.asList("Zabee", "Umar", "John", "Andy", "Bob", "Andrew");
		namesSortConsumer.accept(names);
		
		names.forEach((n)-> System.out.println(n)) ;
		
		names.forEach(System.out::println);
	}

}
