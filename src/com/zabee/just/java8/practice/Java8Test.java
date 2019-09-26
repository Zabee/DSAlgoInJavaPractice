package com.zabee.just.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Test {

	public static void main(String[] args) {
		IntStream.iterate(0, i -> ++i)//
		.limit(10)//
		.forEach(System.out::println);
		
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);
		List<Integer> collect = infiniteStream//
				.skip(3)//
				.limit(5)//
				.collect(Collectors.toList());
		System.out.println(collect);
		
		List<String> delimeters = Arrays.asList(" ", "//");
		String fileName = "-rwxrwxr-x. 3 dev dev 4096 May 13 2016 home/dev/tattletale.sh";
		List<String> resultFileList = new ArrayList<String>();

		Optional<String> added = delimeters.stream()//
				.filter(delim -> fileName.contains(delim))//
				.map(delim -> fileName.substring(fileName.lastIndexOf(delim) + 1, fileName.length()))//
				.peek(trimmedFileName -> resultFileList.add(trimmedFileName))//
				.findAny();
		resultFileList.stream().forEach(System.out::println);
	}

}
