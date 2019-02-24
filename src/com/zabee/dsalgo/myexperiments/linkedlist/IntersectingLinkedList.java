package com.zabee.dsalgo.myexperiments.linkedlist;

public class IntersectingLinkedList {

	public static void main(String[] args) {}

	public Node getIntersectingNode(Node s1, Node s2) {
		Result r1 = getEndNodeWithLength(s1);
		Result r2 = getEndNodeWithLength(s2);
		// According to problem definition this end nodes will be same otherwise no
		// intersection
		if (r1 != r2) {
			return null;
		}
		
//		Node longer = 
//				Node shorter = 

		return null;
	}

	private Result getEndNodeWithLength(Node s1) {
		int len = 0;
		while (s1.next != null) {
			s1 = s1.next;
			len++;
		}
		return new Result(s1, len);
	}

	private class Result {
		private Result(final Node argEnd, final int len) {
			endNode = argEnd;
			length = len;
		}

		private Node endNode;
		private int length;
	}

}
