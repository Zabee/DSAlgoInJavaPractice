package com.zabee.dsalgo.myexperiments;

public class ArraryToBTreeViceVersa {

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7/* , 8, 9, 10, 11, 12, 13, 14 */ };
		Node root = generateBST(array, 0, array.length-1);
//		Node root = generateBinaryTree(null, array, 0, true);
//		array = convertTreeValuesToArray(root);
		preOrderTraversal(root);
		System.out.println();
		inOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);

	}

	private static void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.print("|" + root.data + "|");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print("|" + root.data + "|");
		inOrderTraversal(root.right);
	}

	private static void postOrderTraversal(Node root) {

		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print("|" + root.data + "|");

	}

	private static Node generateBinaryTree(Node node, int[] array, int index, boolean alternate) {
		if (index >= array.length) {
			return null;
		}

		node = new Node(array[index]);
		if (alternate) {
			node.left = generateBinaryTree(node.left, array, ++index, false);
		} else {
			node.right = generateBinaryTree(node.right, array, ++index, true);
		}
		return node;
	}

	private static Node generateBST(int[] array, int low, int high) {
		if (high < low) {
			return null;
		}
		int mid = (low + high) / 2;
		Node root = new Node(array[mid]);
		root.left = generateBST(array, low, mid - 1);
		root.right = generateBST(array, mid + 1, high);
		return root;
	}
//
//	private static int[] convertTreeValuesToArray(Node root) {
//
//	}

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int argData) {
			data = argData;
		}
	}
}
