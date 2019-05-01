package com.zabee.dsalgo.trees;

public class ValidateIfBST {

	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(3);
		root.right = new Node(8);

		root.left.left = new Node(2);
		root.left.right = new Node(4);

		root.right.left = new Node(7);
		root.right.right = new Node(9);
		System.out.println(isValidBST(root));

	}

	private static boolean isValidBST(Node node) {
		if (node == null) {
			return true;
		}
		boolean isValidBST = true;
		if (node.left != null && isValidBST) {
			if (node.left.data <= node.data) {
				isValidBST = isValidBST(node.left);
			} else {
				return false;
			}

		}
		if (node.right != null && isValidBST) {
			if (node.right.data > node.data) {
				isValidBST = isValidBST(node.right);
			} else {
				return false;
			}
		}
		return isValidBST;

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
