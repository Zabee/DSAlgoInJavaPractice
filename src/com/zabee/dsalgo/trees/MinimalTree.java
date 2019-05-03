package com.zabee.dsalgo.trees;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 * 
 * @author Zabee
 *
 */

public class MinimalTree {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Node root = BinarySearchTree.createBST(array, 0, array.length - 1);
		BinarySearchTree BST = new BinarySearchTree(root);
		System.out.println("PreOrder traversal");
		BST.preOrder(root);

		System.out.println("\nInOrder traversal");
		BST.inOrder(root);

		System.out.println("\nPost traversal");
		BST.postOrder(root);
	}

	private static class BinarySearchTree {
		Node root;

		public BinarySearchTree(Node root) {
			this.root = root;
		}

		public static Node createBST(int[] array, int low, int high) {
			if (low > high) {
				return null;
			}
			int mid = (low + high) / 2;
			Node node = new Node(array[mid]);
			node.left = createBST(array, low, mid - 1);
			node.right = createBST(array, mid + 1, high);
			return node;
		}

		public void preOrder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print("|" + root.data + "|");
			preOrder(root.left);
			preOrder(root.right);
		}

		public void inOrder(Node root) {
			if (root == null) {
				return;
			}
			inOrder(root.left);
			System.out.print("|" + root.data + "|");
			inOrder(root.right);
		}

		public void postOrder(Node root) {
			if (root == null) {
				return;
			}
			postOrder(root.left);
			postOrder(root.right);
			System.out.print("|" + root.data + "|");
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
