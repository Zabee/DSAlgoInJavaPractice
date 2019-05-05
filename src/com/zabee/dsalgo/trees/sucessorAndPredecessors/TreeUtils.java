package com.zabee.dsalgo.trees.sucessorAndPredecessors;

public class TreeUtils {

	static class Node {
		int data;
		Node left;
		Node right;
		Node parent;

		public Node(int argData) {
			data = argData;
		}
	}

	/**
	 * Default scope so only within the package
	 * 
	 * @return
	 */
	static Node generateTree() {
		Node root = new Node(7);

		root.left = new Node(5);
		setParent(root.left, root);
		root.right = new Node(10);
		setParent(root.right, root);

		root.left.left = new Node(3);
		setParent(root.left.left, root.left);
		root.left.right = new Node(6);
		setParent(root.left.right, root.left);

//		root.right.left = new Node(9);
//		setParent(root.right.left, root.right);

		root.right.right = new Node(11);
		setParent(root.right.right, root.right);
		System.out.println("PreOrder");
		return root;
	}

	private static void setParent(Node child, Node parent) {
		child.parent = parent;
	}
}
