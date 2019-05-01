package com.zabee.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 				1 
 * 		2 				3 
 * 	4 		5 		6 		7
 * 
 * Output should be 1, 2, 3, 4, 5, 6, 7
 * 
 * @author Zabee
 * 
 * Time complexity is O(n) 
 * Space complexity is O(n)
 *
 */

public class BFSakaLevelOrderTraversal {

	private static Queue<Node> queue;

	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		bfsAkaLevelOrderTraversal(root);
	}

	public static void bfsAkaLevelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.remove();
			System.out.print("|" + temp.data + "|");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int argData) {
			data = argData;
		}

	}

}
