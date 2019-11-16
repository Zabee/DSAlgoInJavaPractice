package com.zabee.allaboutmemory;

import java.util.ArrayList;
import java.util.List;

public class HeapErrorDemo {

	public static void main(String[] args) throws InterruptedException {
//		10000 * 100 objects and -Xmx is 10MB
//		java.util.stream.Stream.iterate(0, i -> ++i)//
//				.limit(10000)//
//				.forEach(i -> new MyClass());
		for (int i = 0; i < 10000; i++) {
			MyClass myObj = new MyClass();
		}
	}

	private static class MyClass extends Thread{
		final private List<String> intList = new ArrayList<String>();

		private MyClass() throws InterruptedException {
//			intList = java.util.stream.Stream.iterate(0, i -> ++i)//
//					.limit(10000)///
//					.collect(Collectors.toList());
			for(;;) {
//				Thread.sleep(1000);
				intList.add(new String(String.valueOf(0)));
			}
		}
	}

}
