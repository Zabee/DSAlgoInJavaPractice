package com.zabee.dsalgo.trees.heaps;

public class MaxHeapTreeOfCourseUsingArray {
	private int[] heapArray = new int[10];
	private int size = -1;
	private StringBuilder strBuilder = new StringBuilder();
	private int temp;

	/**
	 * O(log n) n is the number nodes in the heap tree Only half of the nodes gonna
	 * be operated upon
	 * 
	 * @param x
	 */
	private void insertToHeap(final int x) {
		heapArray[++size] = x;
//		heapify(0); Calling heapify(0) will not work for the reason that heapify(0) has a termination condition as part of its recursion that if not leaf node
//		but I need to apply rule for all the nodes and at the same time I cannot remove that condition. If I remove then I don't have any other recursion
//		termination condition. So, different simple fix for this
		int current = size;
//		I have inserted at last. Of course I must check parent not any children.
		while (heapArray[current] > heapArray[getParentIndex(current)]) {
			swap(current, getParentIndex(current));
			current = getParentIndex(current);

		}
	}

	private void swap(int xIndex, int yIndex) {
		temp = heapArray[xIndex];
		heapArray[xIndex] = heapArray[yIndex];
		heapArray[yIndex] = temp;
	}

	private void heapify(int x) {
		if (!isLeaf(x)) {
			if (heapArray[x] < heapArray[getLeftChildIndex(x)]) {
				swap(x, getLeftChildIndex(x));
				heapify(getLeftChildIndex(x));
			} else if (heapArray[x] < heapArray[getRightChildIndex(x)]) {
				swap(x, getRightChildIndex(x));
				heapify(getRightChildIndex(x));
			}
		}
	}

	private boolean isLeaf(int x) {
		if (x >= size / 2 && x <= size) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * O(log n) Only half of the nodes will be operated upon
	 * 
	 * @return
	 */
	private int extractMax() {
		int element = heapArray[0];
		heapArray[0] = heapArray[size];
		heapArray[size] = 0;
		size--;
		heapify(0);
		return element;
	}

	/**
	 * This is utility method can be used from outside
	 * 
	 * @param argHeapArray
	 * @return
	 */
	public static boolean isMaxHeap(int[] argHeapArray) {
		MaxHeapTreeOfCourseUsingArray thiss = new MaxHeapTreeOfCourseUsingArray();
		for (int i = 1, parent = -1; i < argHeapArray.length; i++) {
			parent = thiss.getParentIndex(i);
			if (argHeapArray[parent] < argHeapArray[i]) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Parent = i-1/2
	 * 
	 * @param i
	 * @return
	 */
	private int getParentIndex(final int i) {
		return (i - 1) / 2;

	}

	/**
	 * Left child = i*2+1
	 * 
	 * @param x
	 * @return
	 */
	private int getLeftChildIndex(final int i) {
		return i * 2 + 1;
	}

	/**
	 * Right child = i*2+2
	 * 
	 * @param x
	 * @return
	 */
	private int getRightChildIndex(final int i) {
		return i * 2 + 2;
	}

	@Override
	public String toString() {
		strBuilder.delete(0, strBuilder.length());
		for (int i = 0; i < (size + 1) / 2; i++) {
			strBuilder.append(String.valueOf(heapArray[i]));
			strBuilder.append("->");
			strBuilder.append("|");
			if (heapArray[getLeftChildIndex(i)] > 0) {
				strBuilder.append(String.valueOf(heapArray[getLeftChildIndex(i)]));
			}
			strBuilder.append("|");
			if (heapArray[getRightChildIndex(i)] > 0) {
				strBuilder.append(String.valueOf(heapArray[getRightChildIndex(i)]));
			}
			strBuilder.append("|");
			strBuilder.append("\n");
		}
		return strBuilder.toString();
	}

	public static void main(String[] args) {
		MaxHeapTreeOfCourseUsingArray heapTreeOfCourseUsingArray = new MaxHeapTreeOfCourseUsingArray();
		heapTreeOfCourseUsingArray.insertToHeap(1);
		heapTreeOfCourseUsingArray.insertToHeap(2);
		heapTreeOfCourseUsingArray.insertToHeap(3);
		heapTreeOfCourseUsingArray.insertToHeap(4);
		heapTreeOfCourseUsingArray.insertToHeap(5);
		heapTreeOfCourseUsingArray.insertToHeap(6);
		heapTreeOfCourseUsingArray.insertToHeap(7);

		System.out.println(heapTreeOfCourseUsingArray);

		System.out.println(heapTreeOfCourseUsingArray.extractMax());
		System.out.println(heapTreeOfCourseUsingArray);

	}

}
