package com.zabee.dsalgo.myexperiments;

public class MyArrayList {

	public /**
			 * Unusuable isn't it! I was so wanted to see capacity increasing in JDK's
			 * implementation so, I made this visible publicly!! in my implementation
			 **/
	int capacity = 10;
	
	private int oldCapacity;
	private int size = 0;
	private int[] elements = new int[capacity];

	public void add(int x) {
		ensureCapacity();
		elements[size++] = x;
	}

	/**
	 * Increase the array list by 0.5 factor as their Oracle JDK 8
	 */
	private void ensureCapacity() {
		if (size == capacity) {
			oldCapacity = capacity;
			capacity = capacity + (capacity >> 1);
			handleElementForNewCapacity();
		}
	}

	private void handleElementForNewCapacity() {
		int[] existingElements = new int[oldCapacity];
		System.arraycopy(elements, 0, existingElements, 0, oldCapacity);
		elements = new int[capacity];
		System.arraycopy(existingElements, 0, elements, 0, oldCapacity);
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer("[");
		for (int i = 0; i < size; i++) {
			strBuff.append(elements[i] + "|");
		}
		strBuff.append("]");
		return strBuff.toString();
	}
}
