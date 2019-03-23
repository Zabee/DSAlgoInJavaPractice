package com.zabee.dsalgo.myexperiments.trees;

public class BinaryTreeRecursiveTraversals {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree(1);
		binaryTree.root.left = new Node(2);
		binaryTree.root.right = new Node(3);

		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right = new Node(5);

		binaryTree.root.left.left.left = new Node(8);
		binaryTree.root.left.left.right = new Node(9);

		binaryTree.root.right.left = new Node(6);
		binaryTree.root.right.right = new Node(7);
		System.out.println("PreOrder traversal");
		preOrderTraversal(binaryTree.root);

		System.out.println("InOrder traversal");
		inOrderTraversal(binaryTree.root);

		System.out.println("PostOrder traversal");
		postOrderTraversal(binaryTree.root);
	}

	public static void preOrderTraversal(Node argRoot) {
		if (argRoot == null) {
			return;
		}
		System.out.println(argRoot.getValue());
		preOrderTraversal(argRoot.left);
		preOrderTraversal(argRoot.right);
	}

	public static void inOrderTraversal(Node argRoot) {
		if (argRoot == null) {
			return;
		}
		preOrderTraversal(argRoot.left);
		System.out.println(argRoot.getValue());
		preOrderTraversal(argRoot.right);
	}

	public static void postOrderTraversal(Node argRoot) {
		if (argRoot == null) {
			return;
		}
		preOrderTraversal(argRoot.left);
		preOrderTraversal(argRoot.right);
		System.out.println(argRoot.getValue());
	}

}
