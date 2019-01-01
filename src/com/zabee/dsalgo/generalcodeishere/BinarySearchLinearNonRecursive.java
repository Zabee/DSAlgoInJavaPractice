package com.zabee.dsalgo.generalcodeishere;

import java.lang.reflect.Array;
import java.util.*;

public class BinarySearchLinearNonRecursive {

	private static int[] n = { 1, 2, 3, 4, 5, 6, 7, 8};

	public static void main(String[] args) {
		try {
			System.out.print("What do you want to find? ");
			Scanner scanner = new Scanner(System.in);
			int x = Integer.valueOf(scanner.nextLine());
			int indexOfx = binarySearch(x, 0, Array.getLength(n)-1);
			if (indexOfx == -1) {
				System.out.println("Element doesn't present");
			} else {
				System.out.println("Element present at index (index is starting frome zero) " + indexOfx);
			}
		} catch (NumberFormatException nfe) {
			// Gracefully catch and terminate
			nfe.printStackTrace();
		}

	}

	/**
	 * Time Complexity :
	 * Upper bound, worst or expected case i.e. rate of increase in time O(log n)
	 * Explanation:
	 * 	n	n/2	n/4	n/8	n/16	n/n not increase (as in case of O(n)) but decreasing.
	 * Did I say decreasing by 2 each time 2^4 2^3 2^2 2^1 2^0 okay then it is log n
	 * For e.g. log 16 = 4. So, to find an element in a size of 16 array it takes only 4 iterations 
	 * 
	 * @param x
	 * @param low
	 * @param high
	 * @return
	 */
	private static int binarySearch(int x, int low, int high) {
		int indexOfx = -1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			System.out.println("low:" + low);
			System.out.println("middle:" + middle);
			System.out.println("high:" + high);
			int middleElement = n[middle];
			if (x == middleElement) {
				indexOfx = middle;
				break;
			} else if (x < middleElement) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return indexOfx;
	}
}
