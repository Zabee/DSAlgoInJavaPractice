package com.zabee.dsalgo.myexperiments.stackandqueues;

/**
 * Please see FixedMutliStack for better implementation of the problem
 * 
 * @author Zabee
 *
 */

public class ThreeStackInAnArray {

	int[] array;
	int top1, top2, top3, division, top2IntVlaue;

	public ThreeStackInAnArray(int size) {
		if (size < 6) {
			System.out.println("Minium size expected is 6");
			System.exit(-1);
		}
		array = new int[size];
		division = (int) (array.length - 1) / 3;

		top1 = -1;
		top2 = division;
		top2IntVlaue = top2;
		top3 = division + top2IntVlaue + 1;
	}

	public void push(int element, int sIndex) {
		boolean hasPushed = false;
		if (sIndex == 0 && top1 < division) {
			array[++top1] = element;
		} else if (sIndex == 1 && top2 >= division && top2 < division + top2IntVlaue + 1) {
			array[++top2] = element;
		} else if (sIndex == 2 && top3 >= division + top2IntVlaue + 1 && top3 < array.length - 1) {
			array[++top3] = element;
		}
	}

	public int pop(int sIndex) {
		int poppedValue;
		if (sIndex == 0 && top1 <= division && top1 > -1) {
			poppedValue = array[top1];
			array[top1--] = -1;
			return poppedValue;
		} else if (sIndex == 1 && top2 > division && top2 <= division * 2 + 1) {
			poppedValue = array[top2];
			array[top2--] = -1;
			return poppedValue;
		} else if (sIndex == 2 && top3 > division * 2 + 1 && top3 < array.length) {
			poppedValue = array[top3];
			array[top3--] = -1;
			return poppedValue;
		}

		return -1;
	}

	public void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ThreeStackInAnArray threeStackInAnArray = new ThreeStackInAnArray(6);
		threeStackInAnArray.push(11, 0);
		threeStackInAnArray.push(12, 0);
		threeStackInAnArray.push(13, 0);

		System.out.println("\nBefore popping");
		threeStackInAnArray.printArray();
		System.out.println(threeStackInAnArray.pop(0));
		System.out.println("\nAfter popping");
		threeStackInAnArray.printArray();

		threeStackInAnArray.push(21, 1);
		threeStackInAnArray.push(22, 1);
		threeStackInAnArray.push(23, 1);

		System.out.println("\nBefore popping");
		threeStackInAnArray.printArray();
		System.out.println(threeStackInAnArray.pop(1));
		System.out.println("\nAfter popping");
		threeStackInAnArray.printArray();

		threeStackInAnArray.push(31, 2);
		threeStackInAnArray.push(32, 2);
		threeStackInAnArray.push(33, 2);

		System.out.println("\nBefore popping");
		threeStackInAnArray.printArray();
		System.out.println(threeStackInAnArray.pop(2));
		System.out.println(threeStackInAnArray.pop(2));
		System.out.println("\nAfter popping");
		threeStackInAnArray.printArray();

		threeStackInAnArray.printArray();
	}

}