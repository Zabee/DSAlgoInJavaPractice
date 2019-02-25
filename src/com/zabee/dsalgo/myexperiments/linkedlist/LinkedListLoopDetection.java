package com.zabee.dsalgo.myexperiments.linkedlist;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedListLoopDetection {

	public static void main(String[] args) {
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add('a');
		myLinkedList.add('b');
		myLinkedList.add('c');
		myLinkedList.add('d');
		myLinkedList.add('e');
		myLinkedList.add(myLinkedList.getNthNode(2));

		Node<Character> result = null;
		if ((result = hasLoopWithoutExternalDS(myLinkedList.getHead())) == null) {
			System.out.println("Has no loop");
		} else {
			System.out.println("Has loop at value " + result.value);
		}
	}

	public static Node hasLoop(Node start) {
		Set<Node> nodeSet = new LinkedHashSet<>();
		Node temp = start;
		while (temp != null) {
			if (nodeSet.contains(temp)) {
				return temp;
			}
			nodeSet.add(temp);
			temp = temp.next;
		}
		return null;
	}

	public static Node hasLoopWithoutExternalDS(Node start) {
		Node slow = start, fast = start;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break; // collide
			}
		}

		if (fast == null || fast.next == null) {
			return null; // Slow and Fast never at the same point at given time
		}

		// If you're here then it has a loop. Let's find starting point of circle and
		// get away with this problem
		slow = start;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;

	}
}
