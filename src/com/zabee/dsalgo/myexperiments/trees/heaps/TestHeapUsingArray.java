package com.zabee.dsalgo.myexperiments.trees.heaps;

import junit.framework.TestCase;

public class TestHeapUsingArray extends TestCase {

	public void testMinHeapInsertion() {
		MinHeapTreeOfCourseUsingArray heapTreeOfCourseUsingArray = new MinHeapTreeOfCourseUsingArray();
		heapTreeOfCourseUsingArray.insertToHeap(1);
		heapTreeOfCourseUsingArray.insertToHeap(2);
		heapTreeOfCourseUsingArray.insertToHeap(3);
		heapTreeOfCourseUsingArray.insertToHeap(4);
		heapTreeOfCourseUsingArray.insertToHeap(5);
		heapTreeOfCourseUsingArray.insertToHeap(6);
		heapTreeOfCourseUsingArray.insertToHeap(7);
		System.out.println(heapTreeOfCourseUsingArray.toString());
		
		heapTreeOfCourseUsingArray = new MinHeapTreeOfCourseUsingArray();
		heapTreeOfCourseUsingArray.insertToHeap(7);
		heapTreeOfCourseUsingArray.insertToHeap(6);
		heapTreeOfCourseUsingArray.insertToHeap(5);
		heapTreeOfCourseUsingArray.insertToHeap(4);
		heapTreeOfCourseUsingArray.insertToHeap(3);
		heapTreeOfCourseUsingArray.insertToHeap(2);
		heapTreeOfCourseUsingArray.insertToHeap(1);
		System.out.println(heapTreeOfCourseUsingArray.toString());
	}

	public void testMinHeapDeletion() {

	}

	public void testExtractMin() {

	}

	public void testMaxHeapInsertion() {

	}

	public void testMaxHeapDeletion() {

	}

	public void testExtractMax() {

	}

	public void testMaxHeap() {
		int[] heapArray = { 8, 7, 6, 5, 4, 3, 2, 2 };
		assertTrue(MaxHeapTreeOfCourseUsingArray.isMaxHeap(heapArray));

		int[] nonHeapArray = { 8, 7, 6, 5, 4, 3, 4, 10 };
		assertFalse(MaxHeapTreeOfCourseUsingArray.isMaxHeap(nonHeapArray));

	}

	public void testMinHeap() {
		int[] heapArray = { 1, 2, 3, 4, 5, 6, 7, 8 };
		assertTrue(MinHeapTreeOfCourseUsingArray.isMinHeap(heapArray, 8));

		int[] nonHeapArray = { 1, 20, 3, 4, 5, 6, 7, 8 };
		assertFalse(MinHeapTreeOfCourseUsingArray.isMinHeap(nonHeapArray, 8));
	}
}
