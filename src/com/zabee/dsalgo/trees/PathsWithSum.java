package com.zabee.dsalgo.trees;

import java.util.HashMap;

public class PathsWithSum {

	/**
	 * O(log n) for balance tree O(n^2) for unbalanced tree
	 * 
	 * @return
	 */
	private static int countPathsWithSum(Node root, int tSum, int rSum, HashMap<Integer, Integer> pathCnt) {
		if (root == null) {
			return 0;
		}
		rSum += root.data;
		int sum = rSum - tSum;
		int totalPaths = pathCnt.getOrDefault(sum, 0);

		if (rSum == tSum) {
			totalPaths++;
		}
		incrementHashMap(pathCnt, sum, 1);
		totalPaths += countPathsWithSum(root.left, tSum, rSum, pathCnt);
		totalPaths += countPathsWithSum(root.right, tSum, rSum, pathCnt);
		incrementHashMap(pathCnt, sum, -1);
		return totalPaths;

	}

	private static void incrementHashMap(HashMap<Integer, Integer> pathCnt, int key, int delta) {
		int newCnt = pathCnt.getOrDefault(key, 0) + delta;
		if (newCnt == 0) {
			pathCnt.remove(key);
		} else {
			pathCnt.put(key, newCnt);
		}

	}

	/**
	 * O(n log n)
	 * 
	 * @param root
	 * @param tSum
	 * @param sum
	 * @return
	 */
	private static int countPathsWithSumSimpleWay(final Node root, final int tSum, int sum) {
		int pathsToSum = 0;
		if (root == null) {
			return 0;
		}
		sum += root.data;
		if (sum == tSum) {
			pathsToSum++;
		}
		pathsToSum += countPathsWithSumSimpleWay(root.left, tSum, sum);
		pathsToSum += countPathsWithSumSimpleWay(root.right, tSum, sum);
		return pathsToSum;
	}

	public static void main(String[] args) {
		int tSum = 10;
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("Simple way: " + countPathsWithSumSimpleWay(root, tSum, 0));
		System.out.println(
				"Complicated but efficient way: " + countPathsWithSum(root, tSum, 0, new HashMap<Integer, Integer>()));
	}

	static class Node {
		private int data;
		Node left;
		Node right;

		public Node(int argData) {
			data = argData;
		}

		public int getData() {
			return data;
		}
	}
}