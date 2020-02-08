package com.zabee.dsalgo.trees.heaps;

public class MinHeapTreeOfCourseUsingArray {
	private int[] heapArray;
	private int size;
	private int temp;
	private StringBuilder strBuilder = new StringBuilder();

	public MinHeapTreeOfCourseUsingArray() {
		heapArray = new int[20];
		size = -1;
	}

	private void swap(int oneIndex, int otherIndex) {
		temp = heapArray[oneIndex];
		heapArray[oneIndex] = heapArray[otherIndex];
		heapArray[otherIndex] = temp;
	}

	/**
	 * O(log n) n is the number of nodes in a given heap tree Only half of the nodes
	 * gonna be operated upon, so, log n is the Upper bound Worst case run time
	 * 
	 * @param x
	 */
	void insertToHeap(final int x) {
		heapArray[++size] = x;
		int current = size;
		while (heapArray[current] < heapArray[getParentIndex(current)]) {
			swap(current, getParentIndex(current));
			current = getParentIndex(current);
		}
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

	/**
	 * This is utility method can be used from outside
	 * 
	 * @param argHeapArray
	 * @return
	 */
	public static boolean isMinHeap(final int[] argHeapArray, final int size) {
		MinHeapTreeOfCourseUsingArray minHeap = new MinHeapTreeOfCourseUsingArray();
		for (int i = 1, parent = -1; i < size; i++) {
			parent = minHeap.getParentIndex(i);
			if (argHeapArray[parent] > argHeapArray[i])
				return false;
		}
		return true;
	}

	private boolean isLeaf(int index) {
		if (index >= size / 2 && index <= size) {
			return true;
		}
		return false;
	}

	private void heapify(int index) {
		if (!isLeaf(index)) {
			if (heapArray[index] > heapArray[getLeftChildIndex(index)]) {
				swap(index, getLeftChildIndex(index));
				heapify(getLeftChildIndex(index));
			} else if (heapArray[index] > heapArray[getRightChildIndex(index)]) {
				swap(index, getLeftChildIndex(index));
				heapify(getRightChildIndex(index));
			}

		}
	}

	/**
	 * Upper bound worst case O(log n) Where n is the number of nodes in a given
	 * heap tree At any given time only hlaf of the nodes gonna be operated upon
	 * 
	 * @return
	 */
	private int extractMin() {
		int element = heapArray[0];
		heapArray[0] = heapArray[size];
		heapArray[size] = 0;
		size--;
		heapify(0);
		return element;
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
		MinHeapTreeOfCourseUsingArray heapTreeOfCourseUsingArray = new MinHeapTreeOfCourseUsingArray();
		heapTreeOfCourseUsingArray.insertToHeap(13);
		heapTreeOfCourseUsingArray.insertToHeap(12);
		heapTreeOfCourseUsingArray.insertToHeap(7);
		heapTreeOfCourseUsingArray.insertToHeap(11);
		heapTreeOfCourseUsingArray.insertToHeap(9);
		heapTreeOfCourseUsingArray.insertToHeap(8);
		heapTreeOfCourseUsingArray.insertToHeap(10);
		heapTreeOfCourseUsingArray.insertToHeap(6);
		heapTreeOfCourseUsingArray.insertToHeap(4);
		heapTreeOfCourseUsingArray.insertToHeap(3);
		heapTreeOfCourseUsingArray.insertToHeap(5);
		heapTreeOfCourseUsingArray.insertToHeap(2);
		heapTreeOfCourseUsingArray.insertToHeap(1);
		System.out.println(heapTreeOfCourseUsingArray.toString());

//		heapTreeOfCourseUsingArray.extractMin();
//		heapTreeOfCourseUsingArray.insertToHeap(9);
//		heapTreeOfCourseUsingArray.insertToHeap(99);
//		System.out.println(heapTreeOfCourseUsingArray.toString());

	}

}
