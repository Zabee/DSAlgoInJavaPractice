package com.zabee.dsalgo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		List<LinkedList<Integer>> linkedLists = new ArrayList<LinkedList<Integer>>();
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		createLinkedLists(root, linkedLists, 0);
		
		for(LinkedList<Integer> linkedList : linkedLists) {
			for(Integer integer : linkedList) {
				System.out.print(integer);
			}
			System.out.println();
		}
	}

	private static void createLinkedLists(Node root, List<LinkedList<Integer>> linkedLists, int level) {
		if (root == null) {
			return;
		}
		LinkedList<Integer> list = null;
		if (linkedLists.size() == level) {
			list = new LinkedList<Integer>();
		} else {
			list = linkedLists.get(level);
		}
		list.add(root.data);
		linkedLists.add(list);
		createLinkedLists(root.left, linkedLists, level+1);
		createLinkedLists(root.right, linkedLists, level+1);
	}

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
