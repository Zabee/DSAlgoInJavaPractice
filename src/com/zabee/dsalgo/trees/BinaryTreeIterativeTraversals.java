package com.zabee.dsalgo.trees;

import java.util.Stack;

/**
 * Using an external Stack
 * Below are form of DFS - Depth first traversal.
 * PreOrder traversal [1 2 4 8 9 5 3 6 7] InOrder traversal [2 4 8 9 5 1 3 6 7]
 * PostOrder traversal [2 4 8 9 5 3 6 7 1]
 * 
 * @author Zabee
 *
 */
public class BinaryTreeIterativeTraversals {

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

		System.out.println("\nPreOrder traversal");
		preOrderTraversal(binaryTree.root);

		System.out.println("\nInOrder traversal");
		inOrderTraversal(binaryTree.root);

		System.out.println("\nPostOrder traversal");
		postOrderTraversal(binaryTree.root);

	}

	/**
	 * Root, Left and Right
	 * 
	 * @param argRoot
	 */
	public static void preOrderTraversal(Node argRoot) {
		if (argRoot == null) {
			return;
		}
		Stack<Node> aStack = new Stack<>();
		aStack.push(argRoot);
		while (!aStack.isEmpty()) {
			Node node = aStack.pop();
			if (node != null) {
				System.out.print(node.getValue() + " ");
			}
			if (node.right != null) {
				aStack.push(node.right);
			}
			if (node.left != null) {
				aStack.push(node.left);
			}
		}
	}

	/**
	 * Left, Root and Right
	 * 
	 * @param argRoot
	 */
	public static void inOrderTraversal(Node argRoot) {
		if (argRoot == null) {
			return;
		}
		Stack<Node> aStack = new Stack<>();
		while (true) {
			if (argRoot != null) {
				aStack.push(argRoot);
				argRoot = argRoot.left;
			} else {
				if (aStack.isEmpty()) {
					break;
				}
				argRoot = aStack.pop();
				System.out.print(argRoot.getValue() + " ");
				argRoot = argRoot.right;
			}
		}
	}

	/**
	 * Left, Right and Root
	 * 
	 * @param argRoot
	 */
	public static void postOrderTraversal(Node argRoot) {
	}
}
