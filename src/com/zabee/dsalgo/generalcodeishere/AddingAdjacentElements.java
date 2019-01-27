package com.zabee.dsalgo.generalcodeishere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddingAdjacentElements {

	/**
	 * Time Complexity : Upper Bound and Worst or Expected case i.e. rate of increase
	 * O(n/2) ==>  O(n . 1/2) ==>drop the constant O(n)
	 * 
	 * Space Complexity: 
	 * O(1). Please note that the value '1' don't represent 1 but instead it says it is constant.
	 * So, at any given time it needs constant number of space in memory 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Enter 'n' value: ");
		Scanner scanner = new Scanner(System.in);
		Integer intNValue = Integer.valueOf(scanner.nextLine());
		int sumOfAdjacentNumbers = 0;
		for(int i=0; i<intNValue; i++) {
			sumOfAdjacentNumbers = sumOfAdjacentNumbers + pairSum(i, i++);
		}
		System.out.println("Sum of Adjacent Numbers:" + sumOfAdjacentNumbers);
	}
	
	/**
	 * O(1)
	 * @param x
	 * @param y
	 * @return
	 */
			
	private static int pairSum(int x, int y) {
		return x+y;
	}

}
