package com.zabee.dsalgo.trees.sucessorAndPredecessors;

import com.zabee.dsalgo.trees.sucessorAndPredecessors.TreeUtils.Node;

public class PreOrder {
	public static void main(String[] args) {
		Node root = TreeUtils.generateTree();
		System.out.println("\ninOrder");
		preOrder(root);
		Node node = preOrderPredecessor(root);
		System.out.println("PreOrder Predecessor is :" + node != null ? node.data : null);
		node = preOrderSuccessor(root.right);
		System.out.println("PreOrder Successor is :" + node != null ? node.data : null);

	}

	private static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print("|" + root.data + "|");
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * Left|Root|Right
	 * 
	 * @param node
	 * @return
	 */
	private static Node preOrderSuccessor(Node node) {
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

	private static Node preOrderPredecessor(Node node) {
		if (node == null) {
			return null;
		}

		return null;
	}
}
