package com.zabee.dsalgo.myexperiments;

import java.util.Stack;

public class IterativeTreeTraversalsFromMyMind {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

//		System.out.println("Preorder Traversal");
//		preOrderTraversalBetter(root);
//		System.out.println();
		
//		System.out.println("Inorder Traversal");
//		inOrderTraversal(root);
//		System.out.println();
		
		System.out.println("Postorder Traversal");
		postOrderTraversal(root);
		System.out.println();
	}

	private static void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.peek();
			Node temp = node;
			while (temp.left != null) {
				if (!temp.left.visited) {
					stack.push(temp.left);
				}
				temp = temp.left;
			}
			node = stack.peek();
			if (node.right != null && !node.right.visited) {
				stack.push(node.right);
			} else {
 				node = stack.pop();
				node.visited = true;
				System.out.print(node.value);
			}
		}
	}

	private static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node temp = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.peek();
			temp = node.left;
			while (temp != null) {
				if (temp.visited == false) {
					stack.push(temp);
				}
				temp = temp.left;
			}
			node = stack.pop();
			System.out.print(node.value);
			node.visited = true;
			if (node.right != null) {
				stack.push(node.right);
			}
		}
	}

	private static void preOrderTraversalBetter(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.print(node.value);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}

		}
	}

	private static void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node n = stack.peek();
			if (!n.visited) {
				System.out.print(n.value);
			}
			n.visited = true;
			if (n.left != null && !n.left.visited) {
				stack.push(n.left);
			} else if (n.right != null && !n.right.visited) {
				stack.push(n.right);
			} else {
				n = stack.pop();
				n = null;
			}
			if (n != null && n.left == n.right && n.right == null) {
				n = stack.pop();
				n = null;
			}

		}
	}

}

class Node {
	int value;
	Node left, right;
	boolean visited;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Value: " + value;
	}
}
