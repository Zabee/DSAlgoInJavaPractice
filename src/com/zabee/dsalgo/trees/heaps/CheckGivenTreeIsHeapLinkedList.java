package com.zabee.dsalgo.trees.heaps;

/**
 * See its test class CheckForHeapTests.java. Actually heaps are implemented and
 * suitable for array due to their random access feature. Please see the answer
 * here -
 * https://stackoverflow.com/questions/10885449/heap-sort-using-linked-lists.
 * Answer is not exactly pointing towards what you want but very much related.
 * So now switch to arrays implementation of heaps.
 * 
 * @author Zabee
 *
 */
public class CheckGivenTreeIsHeapLinkedList {

	static boolean isMinHeap(Node root) {
		boolean isHeap = true;
		if ((root != null)
				&& ((root.left == null && root.right != null) || (root.left != null && root.value > root.left.value)
						|| (root.right != null && root.value > root.right.value))) {
			return false;
		} else {
			if (root != null && isHeap == true) {
				isHeap = isMinHeap(root.left);
				if (isHeap == true) {
					isHeap = isMinHeap(root.right);
				}
			}
		}
		return isHeap;
	}

	static boolean isMaxHeap(Node root) {

		boolean isHeap = true;
		if ((root != null)
				&& ((root.left == null && root.right != null) || (root.left != null && root.value < root.left.value)
						|| (root.right != null && root.value < root.right.value))) {
			return false;
		} else {
			if (root != null && isHeap == true) {
				isHeap = isMaxHeap(root.left);
				if (isHeap == true) {
					isHeap = isMaxHeap(root.right);
				}
			}
		}
		return isHeap;

	}

	public static void main(String[] args) {
		// This is min heap
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		if (isMinHeap(root)) {
			System.out.println("Given tree is min heap");
		} else {
			System.out.println("Given tree is not min heap");
		}
	}

}

class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
	}
}