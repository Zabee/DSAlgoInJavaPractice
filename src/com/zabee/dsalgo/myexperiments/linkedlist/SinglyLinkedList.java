package com.zabee.dsalgo.myexperiments.linkedlist;

import java.util.Scanner;

/**
 * Modifying list like Insert, Update, Delete or any other operation on
 * LinkedList is O(n)
 * 
 * @author zulla
 *
 */
public class SinglyLinkedList {

	private static Scanner scanner;

	public static void main(String[] args) {
		new SinglyLinkedList();
		scanner = new Scanner(System.in);
		String command = null;
		String subCmds[] = null;
		while (true) {
			System.out.println("1. Insert First");
			System.out.println("2. Insert At");
			System.out.println("3. Insert Last");
			System.out.println("4. Remove First");
			System.out.println("5. Remove Last");
			System.out.println("6. Remove At");
			System.out.println("7. Update First");
			System.out.println("8. Update At");
			System.out.println("9. Update Last");
			System.out.print("Your command goes here:");
			command = scanner.nextLine();
			subCmds = command.split("\\s");
			switch (Integer.valueOf(subCmds[0])) {
			case 1:
				LinkedList.insertFirst(subCmds[1]);
				break;
			case 2:
				LinkedList.insertAt(Integer.valueOf(subCmds[1]), subCmds[2]);
				break;
			case 3:
				LinkedList.insertLast(subCmds[1]);
				break;
			case 4:
				LinkedList.removeFirst();
				break;
			case 5:
				LinkedList.removeLast();
				break;
			case 6:
				LinkedList.removeAt(Integer.valueOf(subCmds[1]));
				break;
			case 7:
				LinkedList.updateFirst(subCmds[1]);
				break;
			case 8:
				LinkedList.updateAt(Integer.valueOf(subCmds[1]), subCmds[2]);
				break;
			case 9:
				LinkedList.updateLast(subCmds[1]);
				break;
			}
		}
	}
}

class Node<T> {
	// Letting it little but don't think you're free in the wild
	Node next;
	T value;

	public Node(T argNodeValue) {
		this.value = argNodeValue;
		next = null;
	}

	@Override
	public String toString() {
		return "[" + value + "|" + next + "]";
	}
}

class LinkedList {
	protected static Node head, tail;
	private static Node temp;
	private static int listLength;

	private LinkedList() {

	}
	public static void destroyList() {
		// tail is never used through
		head = temp = tail = null;
		listLength = 0;
	}

	/**
	 * O(n^2)
	 * 
	 * @return
	 */
	public static boolean isListUnique() {
		temp = head;
		Node temp2 = null;
		while (temp != null) {
			// Although the list is generic for time being let's assume it's a interger list
			int value = (int) temp.value;
			temp2 = temp.next;
			while (temp2 != null) {
				if (value == (int) temp2.value)
					return false;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		return true;
	}

	/**
	 * O(n)
	 * 
	 * @return
	 */
	public static boolean isListUniqueFasterApproach() {
		temp = head;
		int value = 0, x = 0, xt = 0;
		while (temp != null) {
			// Although the list is generic for time being let's assume it's a interger list
			value = (int) temp.value;
			xt = 1 << value;
			if ((xt & x) > 0)
				return false;
			x = x | xt;
//			System.out.println("For value:" + value + "\tx" + "->" + x);
			temp = temp.next;
		}
		return true;
	}

	private Node newNode;

	public static <T> void add(final T argValue) {
		Node<T> newNode = new Node<T>(argValue);
		if (head == null) {
			head = newNode;
			return;
		}
		temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		listLength++;
	}
	
	public static <T> void insertFirst(final T argValue) {
//		System.out.println("Inserting at first");
		Node<T> newNode = new Node<T>(argValue);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		listLength++;
		// printEntireList();
	}

	public static <T> void insertLast(final T argValue) {
//		System.out.println("Inserting at last");
		Node<T> newNode = new Node<T>(argValue);
		if (head == null) {
			head = newNode;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		listLength++;
		// printEntireList();

	}

	public static Node getNodeByValue(final int argNodeValue) {
		temp = head;
		while (temp != null && (int) temp.value != argNodeValue) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Node does not exists");
		}
		return temp;

	}

	private static void checkIndex(final int index) {
		if (index > listLength) {
			System.out.println("Index doesn't exists");
			// This results in stack overflow if program runs for good amount of time. In
			// production or in real world application this setup (calling main() method
			// from a method that main() has called in a infinite loop.
			// But for now this is fine :D
			SinglyLinkedList.main(null);
		}
	}

	public static <T> void insertAt(final int index, final T argValue) {
//		System.out.println("Inserting at " + index);
		checkIndex(index);
		temp = head;
		// i > index - 1 because I have stop before the position to adjust the links
		for (int i = 0; i < index - 2 /* && temp.next != null */; i++, temp = temp.next) {
//			System.out.println(i + "" + temp);
		}
		Node<T> newNode = new Node<T>(argValue);
		newNode.next = temp.next;
		temp.next = newNode;

		listLength++;
		// printEntireList();
	}

	public static void isListEmpty() {
		if (head == null) {
			SinglyLinkedList.main(null);
		}
	}

	public static void removeFirst() {
		System.out.println("Removing from first");
		isListEmpty();
		// Remove first code
		head = head.next;
		listLength--;
		// printEntireList();
	}

	public static void removeLast() {
		System.out.println("Removing from last");
		isListEmpty();
		temp = head;
		Node previous = temp;
		if (listLength == 1) {
			removeFirst();
		}
		// Remove last code
		while (temp.next != null) {
			previous = temp;
			temp = temp.next;
		}
		previous.next = null;

		listLength--;
		// printEntireList();
	}

	/**
	 * O(n)
	 * 
	 * @param argValue
	 */
	public static void deleteByValue(final int argValue) {
		temp = head;
		Node prev = head;
		while (temp != null && argValue != (int) temp.value) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Not found");
			return;
		}
		prev.next = temp.next;
	}

	/**
	 * Upper bound worst case is O(n) This is same as delete by value
	 * 
	 * @param argValue
	 * 
	 */
	public static void deleteFromMiddleUsingAdditionalPointerOrNodeInJavaWorld(final int argValue) {
		temp = head;
		Node prev = head;

		while (temp != null && argValue != (int) temp.value) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Not found");
			return;
		}
		prev.next = temp.next;
	}

	/**
	 * Assuming head of linked list is unknown
	 * 
	 * @param argNode
	 */
	public static void deleteFromMiddleOnly(final Node argNode) {
		if (argNode == null || argNode.next == null) {
			return; // Last node? Ignore.
		}
		Node nextNode = argNode.next;
		argNode.value = nextNode.value;
		argNode.next = nextNode.next;
	}

	public static void removeAt(final int index) {
		System.out.println("Removing from " + index);
		checkIndex(index);
		if (listLength == 1 && index == 1) {
			removeFirst();
		}
		isListEmpty();

		// Remove at code
		temp = head;
		int i = 0;
		Node prev = temp;
		while (temp.next != null && i < index - 1 /** Pointing to the indexed node **/
		) {
			i++;
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		listLength--;
		// printEntireList();
	}

	public static <T> void updateAt(final int index, final T argValue) {
//		System.out.println("Updating at " + index);
		checkIndex(index);
		temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.value = argValue;
		// printEntireList();
	}

	public static <T> void updateFirst(final T argValue) {
		System.out.println("Updating at first");
		if (head != null) {
			head.value = argValue;
		}
		// printEntireList();
	}

	public static <T> void updateLast(final T argValue) {
		System.out.println("Updating at last");
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.value = argValue;
		// printEntireList();
	}

	public static void printEntireList() {
		temp = head;
		if (temp != null) {
			while (temp.next != null) {
				System.out.print("[" + temp.value + "]->");
				temp = temp.next;
			}
			System.out.print("[" + temp.value + "]-||\n");
		} else {
			System.out.println("List is empty");
		}
	}

	/**
	 * Upper bound worst case is O(n^2) Space complexity is O(1)
	 */
	public static void removeDuplicate() {
		temp = head;
		Node runner;
		int value;
		while (temp != null) {
			value = (int) temp.value;
			runner = temp;
			while (runner.next != null) {
				if (value == (int) runner.next.value) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			temp = temp.next;
		}
	}

	/**
	 * Return kth from last Assuming length of the linked list is not known
	 * 
	 * A trivial solution would be find the length then return n-k element Time and
	 * Space complexity is O(n)
	 * 
	 * @param index
	 * @return
	 */
	public static int printKthElementFromLast(final Node argHead, int argIndexK) {
		if (argHead == null || argIndexK == 0) {
			return 0;
		}
//		System.out.println("Pusing: " + argHead.value);
		int index = 0;
		index = printKthElementFromLast(argHead.next, argIndexK);
//		System.out.println("Popping: " + argHead.value);
		if (index == argIndexK - 1) {
			System.out.println("Value at kth location " + argHead.value);
		}

		return ++index;
	}

	/**
	 * Assuming 'x' will always be passed as ZERO Upper Bound, Worst Case Time and
	 * space complexity is O(n) Due to recursive calls space complexity is O(n)
	 * 
	 * @param argHead
	 * @param argIndexK
	 * @param x
	 * @return
	 */
	public static Node returnKthFromLast(final Node argHead, int argIndexK) {
		if (argHead == null || argIndexK == 0) {
			return null;
		}
		Node theNode = returnKthFromLast(argHead.next, argIndexK);
		if (argIndexK == ++Index.x) {
			return argHead;
		}
		return theNode;
	}

	/**
	 * A wrapper class to keep/track the 'x' value same throughout all the recursive
	 * calls
	 * 
	 * @author zulla
	 *
	 */
	private static class Index {
		public static int x = 0;
	}

	/**
	 * O(n-k) + O(k) ==> O(n)
	 * 
	 * @param argHead
	 * @param argIndexK
	 * @return
	 */

	public static Node returnKthFromLastIterative(Node argHead, int argIndexK) {
		if (argHead == null || argIndexK == 0) {
			return null;
		}
		Node previous = argHead;
		int x = argIndexK;
		while (argHead != null && x > 0) {
			argHead = argHead.next;
			x--;
		}
		while (argHead != null) {
			argHead = argHead.next;
			previous = previous.next;
		}
		return previous;
	}

}