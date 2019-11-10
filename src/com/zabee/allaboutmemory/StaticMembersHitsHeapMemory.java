package com.zabee.allaboutmemory;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.math.BigInteger;

public class StaticMembersHitsHeapMemory {
	private List<BigInteger> bigIntsList = new ArrayList<>();

	public void populateStaticList() {
		Stream.iterate(0, i -> ++i)//
				.limit(1_00_000)//
				.forEach(i -> bigIntsList.add(BigInteger.valueOf(i)));
	}

	public static void main(String[] args) {
		System.out.println("Populating the big ints list");
		new StaticMembersHitsHeapMemory().populateStaticList();
		System.out.println("populated and done");
		System.out.append("Ending the main method!!");
	}

}
