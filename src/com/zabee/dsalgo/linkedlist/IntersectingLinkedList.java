package com.zabee.dsalgo.linkedlist;

import java.security.GeneralSecurityException;

/**
 * This problem is specific to a case as shown below [1->2->3->4->5->6->7]
 * [8->9->4->5->6->7] Intersection by reference
 * 
 * @author Zabee
 *
 */
public class IntersectingLinkedList {

	public static void main(String[] args) {
		MyLinkedList myLinkedList1 = new MyLinkedList();
		myLinkedList1.add(1);
		myLinkedList1.add(2);
		myLinkedList1.add(3);
		myLinkedList1.add(4);
		myLinkedList1.add(5);
		myLinkedList1.add(6);
		myLinkedList1.add(7);
		
		MyLinkedList myLinkedList2 = new MyLinkedList();
		myLinkedList2.add(8);
		myLinkedList2.add(9);
		myLinkedList2.add(myLinkedList1.getNthNode(3));
		
		System.out.println(getIntersectingNode(myLinkedList1.getHead(), myLinkedList2.getHead()));
		
	}

	public static Node getIntersectingNode(Node s1, Node s2) {
		Result r1 = getEndNodeWithLength(s1);
		Result r2 = getEndNodeWithLength(s2);
		// According to problem definition the end nodes are not same then no
		// intersection
		if (r1.endNode != r2.endNode) {
			return null;
		}

		Node longer = r1.length > r2.length ? s1 : s2;
		Node shorter = r1.length > r2.length ? s2 : s1;
		longer = getKthNode(longer, Math.abs(r1.length - r2.length));

		//So both lists lenght are equal now so have to find the node which collides and get away with this 
		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}

		return longer;
	}

	private static Result getEndNodeWithLength(Node s1) {
		int len = 0;
		while (s1.next != null) {
			s1 = s1.next;
			len++;
		}
		return new Result(s1, len);
	}

	private static class Result {
		private Result(final Node argEnd, final int len) {
			endNode = argEnd;
			length = len;
		}

		private Node endNode;
		private int length;
	}

	private static Node getKthNode(Node argHead, int x) {
		while (argHead != null && x > 0) {
			argHead = argHead.next;
			x--;
			
		}
		return argHead;
	}
}
