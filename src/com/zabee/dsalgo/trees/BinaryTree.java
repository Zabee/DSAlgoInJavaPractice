package com.zabee.dsalgo.trees;

public class BinaryTree {
	Node root;

	public BinaryTree(int value) {
		root = new Node(value);
		root.left = root.right = null;
	}

}

class Node {
	private int value;
	Node left;
	Node right;

	public Node(int argValue) {
		value = argValue;
	}
	
	public int getValue() {
		return value;
	}
}