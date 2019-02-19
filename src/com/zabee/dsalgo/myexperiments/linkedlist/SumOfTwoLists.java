package com.zabee.dsalgo.myexperiments.linkedlist;

import java.util.List;
import java.util.Stack;

public class SumOfTwoLists {

	public static MyLinkedList sumTwoReversedLists(MyLinkedList list1, MyLinkedList list2) {
		MyLinkedList resultList = new MyLinkedList();
		Node result = null, tempResult = null;
		int value = 0, resultDigit, carry = 0, resultNodeCnt = 0;
		if (list1.getLength() > list2.getLength()) {
			padList(list2, list1.getLength() - list2.getLength(), true);
		} else if (list1.getLength() < list2.getLength()) {
			padList(list1, list2.getLength() - list1.getLength(), true);
		}
		Node temp1 = list1.head, temp2 = list2.head;
		while (temp1 != null) {
			value = (int) temp1.value + (int) temp2.value + carry;
			if (value >= 10) {
				carry = value / 10;
				resultDigit = value % 10;
			} else {
				carry = 0;
				resultDigit = value;
			}

			Node newNode = new Node(resultDigit);
			if (resultNodeCnt == 0) {
				result = tempResult = newNode;
				resultNodeCnt++;
			}
			tempResult.next = newNode;
			tempResult = tempResult.next;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		if (value >= 10) {
			// handle last digit of process
			value = value % 10;
			tempResult = new Node(value);
		}
		resultList.setHead(result);
		return resultList;
	}

	private static void padList(MyLinkedList list, int length, boolean isReversed) {
		if (isReversed) {
			for (int i = 0; i < length; i++) {
				list.insertLast(0);
			}
		} else {
			for (int i = 0; i < length; i++) {
				list.insertLast(0);
			}
		}
	}

	private static MyLinkedList createList(int[] arr) {
		MyLinkedList list = new MyLinkedList();
		for (int i = 0; i < arr.length; i++) {
			list.insertLast(arr[i]);
		}
		return list;
	}

	public Node sumTwoLists(Node head1, Node head2) {
		Stack<Node> aStack = new Stack<Node>();
		Node newNode = null, temp = head1;
		MyLinkedList resultList = new MyLinkedList();

		while (temp != null) {
			aStack.push(head1);
			aStack.push(head2);
			temp = temp.next;
			head1 = head1.next;
			head2 = head2.next;
		}
		Node node1, node2;
		int i = 0, value = 0, resultDigit, carry = 0;
		while (!aStack.isEmpty()) {
			node1 = aStack.pop();
			node2 = aStack.pop();
			value = (int) node1.value + (int) node2.value + carry;
			resultDigit = value % 10;
			carry = value / 10;
			newNode = new Node(resultDigit);
			resultList.insertFirst(newNode);
		}
		if (value >= 10) {
			newNode = new Node(carry);
			resultList.insertFirst(newNode);
		}
		return resultList.head;
	}

	public static void main(String... args) {
		int[] array1 = { 7, 1, 6 }, array2 = { 2, 9, 5 };
		// Result should be 2, 1, 9
		MyLinkedList list1 = createList(array1), list2 = createList(array2);
		MyLinkedList result = sumTwoReversedLists(list1, list2);
		result.printEntireList();

		array1 = new int[] { 7, 1, 6 };
		array2 = new int[] { 5, 0, 0 };
		list1 = createList(array1);
		list2 = createList(array2);

		if (list1.getLength() > list2.getLength()) {
			padList(list2, list2.getLength() - list1.getLength(), false);
		} else if (list1.getLength() < list2.getLength()) {
			padList(list1, list1.getLength() - list2.getLength(), false);
		}
		SumOfTwoLists sumOfTwoLists = new SumOfTwoLists();
		Node resultNode = sumOfTwoLists.sumTwoLists(list1.head, list2.head);
		result.setHead(resultNode);
		result.printEntireList();
	}
}