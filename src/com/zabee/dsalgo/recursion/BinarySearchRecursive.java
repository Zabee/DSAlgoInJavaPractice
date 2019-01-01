package com.zabee.dsalgo.recursion;

import java.lang.reflect.Array;
import java.util.Scanner;

public class BinarySearchRecursive {

	private static int[] number = { 1, 2, 3, 4, 5, 6, 7, 8 };
	private static int x = 0;
	private static int indexOfx = -1;

	public static void main(String[] args) {
		System.out.println("Enter an element to find:");
		Scanner scanner = new Scanner(System.in);
		x = Integer.valueOf(scanner.nextLine());
		indexOfx = binarySearch(0, Array.getLength(number) - 1);
		if (indexOfx != -1) {
			System.out.println("Element found at index (index starts from zero) " + indexOfx);
			return;
		}
		System.out.println("Given element doesn't found");

	}

	private static int iterations = 0;

	private static int binarySearch(int low, int high) {
		if (low > high)
			return -1;
		int middleIndex = (low + high)/ 2;
		System.out.println("Iteration : " + ++iterations);
		int middleElement = number[middleIndex];
		if (x == middleElement)
			return middleIndex;
		else if (x < middleElement) {
			return binarySearch(low, middleIndex - 1);
		} else {
			return binarySearch(middleIndex + 1, high);
		}
	}

}
