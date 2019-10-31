package com.zabee.just.java.concurrent.forkjoinframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinToSumAnIntegerTree {

	public static void main(String[] args) {
		Node treeRoot = new Node(1);
		treeRoot.left = new Node(2);
		treeRoot.right = new Node(3);
		treeRoot.left.left = new Node(4);
		treeRoot.left.right = new Node(5);
		treeRoot.right.left = new Node(6);
		treeRoot.right.right = new Node(7);
		int expectedResult = IntStream.iterate(1, i -> ++i)//
				.limit(7)//
				.sum();
		System.out.println("Expected result is : " + expectedResult);
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		MyRecursiveTask myRecursiveTask  = new MyRecursiveTask(treeRoot);
		int finalSum = forkJoinPool.invoke(myRecursiveTask);
		System.out.println("Final sum is : " + finalSum);

	}

	private static class MyRecursiveTask extends RecursiveTask<Integer> {
		private Node node;

		public MyRecursiveTask(Node node) {
			this.node = node;
		}

		public Integer compute() {
			if(node == null) {
				return 0;
			}
			int partialSum = 0;
			try {
				partialSum = node.nodeValue + new MyRecursiveTask(node.left).fork().get()
						+ new MyRecursiveTask(node.right).fork().get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return partialSum;
		}
	}

	private static class Node {
		private int nodeValue;
		private Node left, right;

		public Node(int argNodeValue) {
			nodeValue = argNodeValue;
			// This is not needed but still to pacify the minds of readers
			left = right = null;

		}

	}
}
