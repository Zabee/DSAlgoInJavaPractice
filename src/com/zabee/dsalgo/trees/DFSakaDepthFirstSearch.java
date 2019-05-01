package com.zabee.dsalgo.trees;

/**
 * PreOrder, InOrder and PostOrder traversals are form of DFS - Depth First
 * Search
 * 
 * 
 * DFS for a Graph needs to a flag/tag/indicator indicating whether or not the
 * node is visited or not otherwise it might end up with infinite loop
 * 
 * @author Zabee
 *
 */
public class DFSakaDepthFirstSearch {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(8);

		root.left.left = new Node(2);
		root.left.right = new Node(4);

		root.right.left = new Node(7);
		root.right.right = new Node(9);
		
		System.out.println("PreOrder traversal");
		preOrder(root);
		System.out.println("\nInOrder traversal");
		inOrder(root);
		System.out.println("\nPostOrder traversal");
		postOrder(root);

	}

	private static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print("|" + root.data + "|");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print("|" + root.data + "|");
		inOrder(root.right);
	}

	private static void postOrder(Node root) {
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
