package com.zabee.dsalgo.graphs;

public class CreateTreeFromIntArray {

	private static Node root;

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		root = createBST(array, 0, array.length - 1);
		System.out.print("Pre order traversal:");
		preOrder(root);
		System.out.println();
		System.out.print("In order traversal should print sorted array");
		inOrder(root);
		System.out.println();
		System.out.print("Post order traversal should print sorted array");
		postOrder(root);
	}

	public static Node createBST(int[] array, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		Node n = new Node(array[mid]);
		n.left = createBST(array, low, mid - 1);
		n.right = createBST(array, mid + 1, high);
		return n;
	}

	public static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print("|" + root.data + "|");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print("|" + root.data + "|");
		inOrder(root.right);
	}

	public static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print("|" + root.data + "|");
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
