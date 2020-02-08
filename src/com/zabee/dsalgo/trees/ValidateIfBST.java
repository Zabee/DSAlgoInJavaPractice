package com.zabee.dsalgo.trees;

/**
 *					50
 *		30 						80 
 *	20 		40 			70				90
 *					60		76		88		100
 */
public class ValidateIfBST {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(80);
//		3
		root.left.left = new Node(2);
		root.left.right = new Node(4);
//		80
		root.right.left = new Node(70);
		root.right.right = new Node(90);
//		70
		root.right.left.left = new Node(60);
		root.right.left.right = new Node(76);
//		90		
		root.right.right.left = new Node(40);
		root.right.right.right = new Node(100);
		System.out.println(checkBST(root, null, null));
	}

	private static boolean checkBST(Node root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		if ((min != null && root.data <= min) || (max != null && root.data > max)) {
			return false;
		}

		if (!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)) {
			return false;
		}
		return true;
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
