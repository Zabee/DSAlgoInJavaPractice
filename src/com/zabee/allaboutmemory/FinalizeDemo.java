package com.zabee.allaboutmemory;

import java.util.stream.Stream;

public class FinalizeDemo {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			Customer customer = new Customer();
		}
		System.gc();
	}

	private static class Customer {
		private String name;
		private Integer rollNo;
		public void finalize() {
			System.out.println("You called me in customer!!");
		}
	}
}
