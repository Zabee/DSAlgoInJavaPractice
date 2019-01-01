package com.zabee.dsalgo.recursion;

import java.util.Scanner;

public class RecursionArthematicUsing {
	private static Scanner scanner;

	/**
	 * Time Complexity : 
	 * Upper bound and worst or expected case time complexity i.e. rate of increase is O(1)
	 * Let's calculate O(1+1+1+1+1+1+1) = O(7). 
	 * So let's drop the constants and say O(1)
	 * 
	 * Space complexity:
	 * O(1) because at any given time only one variable is in use atmost
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Please enter a 'n' value for arthmatic operation  ");
		scanner = new Scanner(System.in);
		Integer integerNValue = Integer.valueOf(scanner.nextLine());
		System.out.println("Sum of 'n' number is " + sum(integerNValue));
		System.out.println("Sub of 'n' number is (doesn't make sense but let's practice) " + subtract(integerNValue));
		System.out.println("Multiplication of 'n' number is " + multiply(integerNValue));
		System.out.println("Division of 'n' number is (doesn't make sense but let's practice) " + divide(integerNValue));
		
	}
	/**
	 * Upper bound, worst or expected case time complexity is O(n)
	 * Space complexity is O(n) because there can only be maximum of n elements at a give time
	 * @param n
	 * @return
	 */
	private static int sum(int n) {
		if (n ==  0) 
			return 0;
		return n + sum(n-1);
	}

	/**
	 * Upper bound, worst or expected case time complexity is O(n)
	 * Space complexity is O(n) because there can only be maximum of n elements at a give time
	 * @param n
	 * @return
	 */
	private static int subtract(int n) {
		if (n ==0)
			return 0;
		return n - sum(n-1);
	}

	/**
	 * Upper bound, worst or expected case time complexity is O(n)
	 * Space complexity is O(n) because there can only be maximum of n elements at a give time
	 * @param n
	 * @return
	 */
	private static int multiply(int n) {
		if (n == 0)
			return 0;
		return n * (n-1);
	}

	/**
	 * Upper bound, worst or expected case time complexity is O(n)
	 * Space complexity is O(n) because there can only be maximum of n elements at a give time
	 * @param n
	 * @return
	 */
	private static int divide(int n) {
		if( n == 1)
			return 1;
		return n / divide (n-1);
	}

}
