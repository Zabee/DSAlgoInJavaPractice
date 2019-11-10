package com.zabee.just.java.concurrent.parallelstreamandthreads;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.lang.Integer;
public class ParallelStreamExample {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		Stream<Integer> parallelStream = intList.parallelStream();
		if(parallelStream.isParallel()) {
			System.out.println("The stream is parallel");
		}
		Stream<Integer> someStream = Stream.of(new Integer(0));
		if(someStream.isParallel()) {
			//This is never be true!!
			System.out.println("Stream.of() returns parallel stream by default");			
		}else {
			System.out.println("Stream.of() returns normal stream by default");
		}
	}

}
