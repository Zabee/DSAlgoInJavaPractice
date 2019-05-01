package com.zabee.dsalgo.trees.heaps;

import org.junit.Ignore;

import junit.framework.TestCase;

public class TestCheckForHeapLinkedList extends TestCase {
	public void testMinHeap() {
		// This is min heap
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		assertTrue(CheckGivenTreeIsHeapLinkedList.isMinHeap(root));

		// This is not min heap. One of left root value is bigger than children
		root = new Node(1);

		root.left = new Node(21);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		assertFalse(CheckGivenTreeIsHeapLinkedList.isMinHeap(root));

		// This is not min heap. One of right root value is bigger than children
		root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(13);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		assertFalse(CheckGivenTreeIsHeapLinkedList.isMinHeap(root));

		// This is heap not heap. Left child is missing but has right child
		root = new Node(1);
		assertTrue(CheckGivenTreeIsHeapLinkedList.isMinHeap(root));

		root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(13);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.right = new Node(7);
		assertFalse(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));
	}

	public void testMaxHeap() {
		// This is max heap
		Node root = new Node(50);

		root.left = new Node(30);
		root.right = new Node(35);

		root.left.left = new Node(20);
		root.left.right = new Node(25);

		root.right.left = new Node(15);
		root.right.right = new Node(10);
		assertTrue(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));

		// This is max heap. One of right is missing
		root = new Node(50);

		root.left = new Node(30);
		root.right = new Node(35);

		root.left.left = new Node(20);
		root.left.right = new Node(25);

		root.right.left = new Node(15);
		assertTrue(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));

		// This is max heap. One of right is missing
		root = new Node(50);

		root.left = new Node(30);
		root.right = new Node(35);

		root.left.left = new Node(20);

		root.right.left = new Node(15);
		root.right.right = new Node(10);
		assertTrue(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));
		
		// This is not max heap. One left is missing
		root = new Node(50);

		root.left = new Node(30);
		root.right = new Node(35);

		root.left.right = new Node(25);

		root.right.left = new Node(15);
		root.right.right = new Node(10);
		assertFalse(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));
		
		// This is not max heap. One left is missing
		root = new Node(50);

		root.left = new Node(30);
		root.right = new Node(35);

		root.left.left = new Node(20);
		root.left.right = new Node(25);

		root.right.right = new Node(10);
		assertFalse(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));

		//This is not max heap. One of root is lesser than its children
		root = new Node(50);

		root.left = new Node(30);
		root.right = new Node(35);

		root.left.left = new Node(40);
		root.left.right = new Node(25);

		root.right.left = new Node(15);
		root.right.right = new Node(10);
		assertFalse(CheckGivenTreeIsHeapLinkedList.isMaxHeap(root));
	}
}
