package com.zabee.dsalgo.myexperiments.test;

import org.junit.Test;

import com.zabee.dsalgo.myexperiments.linkedlist.MyLinkedList;
import com.zabee.dsalgo.myexperiments.linkedlist.Node;

/** Don't be lazy. Go and check console and validate the output manually */
public class ReverseLinkedListTest {

	@Test
	public void testRecurseReversal() {
		MyLinkedList myLinkedList1 = new MyLinkedList();
		// 1 -> 2 -> 3 -> 4 -> 5 -> 6
		myLinkedList1.add(1);
		myLinkedList1.add(2);
		myLinkedList1.add(3);
		myLinkedList1.add(4);
		myLinkedList1.add(5);
		myLinkedList1.add(6);
		Node n = myLinkedList1.reverseListRecursively(myLinkedList1.getHead());
		myLinkedList1.setHead(n);
		myLinkedList1.printEntireList();
	}

	@Test
	public void testRecurseIterative() {
		MyLinkedList myLinkedList1 = new MyLinkedList();
		// 1 -> 2 -> 3 -> 4 -> 5 -> 6
		myLinkedList1.add(1);
		myLinkedList1.add(2);
		myLinkedList1.add(3);
		myLinkedList1.add(4);
		myLinkedList1.add(5);
		myLinkedList1.add(6);
		Node n = myLinkedList1.reverseListIteratively(myLinkedList1.getHead());
		myLinkedList1.setHead(n);
		myLinkedList1.printEntireList();

	}
}
