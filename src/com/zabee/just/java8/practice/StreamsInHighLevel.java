package com.zabee.just.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsInHighLevel {

	public static void main(String... args) {
//		List<String> nameList = Arrays.asList("Now","Then","Before","After","Later","Lately with British accent");
//		Stream<String> stringStream = Stream.of(new String("Blah"), new String("BlahBlah"), new String("BlahBlahBlah"));
//		
//		nameList.stream().forEach(new Consumer<String>() {
//			public void accept(String str) {
//				System.out.println(str);
//			}
//		});
//		
//		stringStream.forEach(new Consumer<String>() {
//			public void accept(String s) {
//				System.out.println(s);
//			}
//		});
//		stringStream = Stream.of(new String("Blah"), new String("BlahBlah"), new String("BlahBlahBlah"));
//		stringStream.forEach((s) -> System.out.println(s));
//
//		nameList.stream().forEach((s) -> System.out.println(s));
//		System.out.println("===================================");
//		
//		Consumer<String> consumer = (str)-> {
//				System.out.println(str);
//			};
//			
//		nameList.forEach(consumer);
		
		
//		List<String> nameList1 = Arrays.asList("Tom", "Dick", "Harry", "John", "James", "Goerge");
//		Optional<String> found =  nameList1.stream().filter(name -> name.startsWith("Z")).findAny();
//		String notFound = found.orElse("No ones name start with 'Z' ");
//		System.out.println(notFound);
//		
//		String[] names = nameList1.stream().toArray(String[]::new);
//		Arrays.asList(names).stream().forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				
//			}
//
//		});
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		numberList.stream().skip(6).limit(7).forEach(System.out::println);
	}
	
}
