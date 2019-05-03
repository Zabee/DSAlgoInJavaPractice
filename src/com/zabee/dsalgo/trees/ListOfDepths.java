package com.zabee.dsalgo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

	public static void main(String[] args) {
		List<LinkedList<Node>> linkedLists = new ArrayList<LinkedList<Node>>();
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		createLinkedLists(root, linkedLists, 0);

		for (LinkedList<Node> linkedList : linkedLists) {
			for (Node node : linkedList) {
				System.out.print(node.data);
			}
			System.out.println();
		}
	}

	/**
	 * O(n) runtime i.e. upper bound worst case
	 * 
	 * @param node
	 * @param lists
	 * @param level
	 */
	private static void createLinkedLists(Node node, List<LinkedList<Node>> lists, int level) {
		if (node == null) {
			return;
		}
		LinkedList<Node> linkedList = null;
		if (lists.size() == level) {
			linkedList = new LinkedList<Node>();
		} else {
			linkedList = lists.get(level);
		}
		linkedList.add(node);
		lists.add(linkedList);
		createLinkedLists(node.left, lists, level + 1);
		createLinkedLists(node.right, lists, level + 1);
	}

	/**
	 * This method takes and builds a list with Integer lists where as the new
	 * method takes and build Node lists that looks more appropriate to me
	 */
//	private static void createLinkedLists(Node root, List<LinkedList<Integer>> linkedLists, int level) {
//		if (root == null) {
//			return;
//		}
//		LinkedList<Integer> list = null;
//		if (linkedLists.size() == level) {
//			list = new LinkedList<Integer>();
//		} else {
//			list = linkedLists.get(level);
//		}
//		list.add(root.data);
//		linkedLists.add(list);
//		createLinkedLists(root.left, linkedLists, level + 1);
//		createLinkedLists(root.right, linkedLists, level + 1);
//	}

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(final int argData) {
			data = argData;
			left = right = null;
		}
	}
}
