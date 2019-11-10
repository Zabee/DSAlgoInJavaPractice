package com.zabee.dsalgo.arrays;

/**
 * 
 */
public class RoataeArray {

	public static void main(String[] args) {
		int[] integers = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println("Original array");
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(integers.length)//
				.forEach(i -> System.out.print(integers[i] + "|"));
		System.out.println();

		rotate(integers, 8, 2);
		System.out.println("Rotated array");
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(integers.length)//
				.forEach(i -> System.out.print(integers[i] + "|"));

	}

	/**
	 * Expected Time Complexity O(n)
	 */
	private static void rotate() {
		
	}
	/**
	 * Time Complexity O(n^2)
	 */
	private static void rotate(int[] array, int n, int r) {
		for (int i = 0; i < n - r; i++) {
			int lastValue = array[n - 1];
			for (int j = n - 1; j > 0; j--) {
				array[j] = array[j - 1];
			}
			array[0] = lastValue;
		}
	}
}
