package com.zabee.dsalgo.trees.sucessorAndPredecessors;

import com.zabee.dsalgo.trees.sucessorAndPredecessors.TreeUtils.Node;

public class InOrder {
	public static void main(String[] args) {
		Node root = TreeUtils.generateTree();
		System.out.println("\ninOrder");
		inOrder(root);
		Node node = inOrderPredecessor(root);
		System.out.println("InOrder Predecessor is :" + node != null ? node.data : null);
		node = inOrderSuccessor(root.right);
		System.out.println("InOrder Successor is :" + node != null ? node.data : null);

	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print("|" + root.data + "|");
		inOrder(root.right);
	}

	/**
	 * Left|Root|Right
	 * 
	 * @param node
	 * @return
	 */
	private static Node inOrderSuccessor(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return leftMostInOrderSuccessor(node.right);
		}
		Node temp = node;
		Node parent = node.parent;
		while (parent != null && parent.left != temp) {
			temp = parent;
			parent = parent.parent;
		}
		return parent;
	}

	private static Node leftMostInOrderSuccessor(Node node) {
		if (node == null) {
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	private static Node inOrderPredecessor(Node node) {
		if (node == null) {
			return null;
		}

		return null;
	}
}
