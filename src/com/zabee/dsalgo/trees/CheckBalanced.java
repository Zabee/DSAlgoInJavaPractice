package com.zabee.dsalgo.trees;

public class CheckBalanced {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);

		System.out.println("Tree is balanced :" + String.valueOf(isBalanced(root)).toUpperCase());
	}

	private static boolean isBalanced(Node root) {
		int delta = Math.abs(getHeight(root.left, 0) - getHeight(root.right, 0));
		return delta == 1 || delta ==0 ? true: false;
	}

	private static int getHeight(Node node, int height) {
		if (node == null) {
			return height;
		}
		return Math.max(getHeight(node.left, ++height), getHeight(node.right, ++height));
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
