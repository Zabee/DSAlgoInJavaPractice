package com.zabee.dsalgo.myexperiments.linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {

	/**
	 * Upper bound worst case runtime is O(n)
	 * 
	 * @param start
	 * @param temp
	 * @return
	 */
	public static Node checkIfPalindromeRecursive(Node start, Node temp) {
		if (temp == null) {
			return start;
		}
		Node strt = checkIfPalindromeRecursive(start, temp.next);
		if (strt == null) {
			return null;
		}
		if (temp.value == strt.value) {
			return strt.next == null ? strt : strt.next;
		} else if (temp.value != strt.value) {
			return null;
		}
		return strt;
	}

	public static Node checkIfPalindromeIterative(Node start) {
		Stack<Node> aStack = new Stack<Node>();
		int len = 0;
		Node tempNode = start, temp = start;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		boolean isLenOdd = len % 2 != 0;
		temp = start;
		for (int i = 0; i < len / 2; i++) {
			aStack.push(temp);
			temp = temp.next;
		}
		for (int i = 0; i < len / 2; i++) {
			if (isLenOdd) {
				temp = temp.next;
				isLenOdd = false;
				i--;
				continue;
			}
			tempNode = aStack.pop();
			if (tempNode.value != temp.value) {
				return null;
			}
			temp = temp.next;
		}
		return start;
	}

	public static Node checkIfPalindromeBetterIterative(Node start) {
		Stack<Node> aStack = new Stack<Node>();
		int len = 0;
		Node slow = start, fast = start;
		while (fast != null && fast.next != null) {
			aStack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		Node poppedNode = null;
		while (slow != null) {
			poppedNode = aStack.pop();
			if (poppedNode.value != slow.value) {
				return null; // Indicating it's not palindrome
			}
			slow = slow.next;
		}
		return start;
	}
}
