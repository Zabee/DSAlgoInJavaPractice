package com.zabee.dsalgo.trees.sucessorAndPredecessors;

import com.zabee.dsalgo.trees.sucessorAndPredecessors.TreeUtils.Node;

public class PostOrder {
	public static void main(String[] args) {
		Node root = TreeUtils.generateTree();
		System.out.println("\nPostOrder");
		postOrder(root);
		Node node = postOrderPredecessor(root);
		System.out.println("postOrder Predecessor is :" + node != null ? node.data : null);
		node = inOrderSuccessor(root.right);
		System.out.println("InOrder Successor is :" + node != null ? node.data : null);

	}

	private static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print("|" + root.data + "|");
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

	private static Node postOrderPredecessor(Node node) {
		if (node == null) {
			return null;
		}

		return null;
	}
}
