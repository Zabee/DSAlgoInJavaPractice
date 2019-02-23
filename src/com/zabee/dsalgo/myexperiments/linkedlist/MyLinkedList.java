package com.zabee.dsalgo.myexperiments.linkedlist;


public class MyLinkedList {
	protected Node head, tail;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	private Node temp;
	private int listLength;

	public int getLength() {
		return listLength;
	}

	public MyLinkedList() {

	}

	public void destroyList() {
		// tail is never used though
		head = temp = tail = null;
		listLength = 0;
	}

	/**
	 * O(n^2)
	 * 
	 * @return
	 */
	public boolean isListUnique() {
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
	public boolean isListUniqueFasterApproach() {
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

	public <T> void add(final T argValue) {
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

	public <T> void insertFirst(final T argValue) {
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

	public <T> void insertLast(final T argValue) {
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

	public Node getNodeByValue(final int argNodeValue) {
		temp = head;
		while (temp != null && (int) temp.value != argNodeValue) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Node does not exists");
		}
		return temp;

	}

	private void checkIndex(final int index) {
		if (index > listLength) {
			System.out.println("Index doesn't exists");
			// This results in stack overflow if program runs for good amount of time. In
			// production or in real world application this setup (calling main() method
			// from a method that main() has called in a infinite loop.
			// But for now this is fine :D
			SinglyLinkedList.main(null);
		}
	}

	public <T> void insertAt(final int index, final T argValue) {
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

	public void isListEmpty() {
		if (head == null) {
			SinglyLinkedList.main(null);
		}
	}

	public void removeFirst() {
		System.out.println("Removing from first");
		isListEmpty();
		// Remove first code
		head = head.next;
		listLength--;
		// printEntireList();
	}

	public void removeLast() {
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
	public void deleteByValue(final int argValue) {
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
	public void deleteFromMiddleUsingAdditionalPointerOrNodeInJavaWorld(final int argValue) {
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
	public void deleteFromMiddleOnly(final Node argNode) {
		if (argNode == null || argNode.next == null) {
			return; // Last node? Ignore.
		}
		Node nextNode = argNode.next;
		argNode.value = nextNode.value;
		argNode.next = nextNode.next;
	}

	public void removeAt(final int index) {
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

	public <T> void updateAt(final int index, final T argValue) {
//		System.out.println("Updating at " + index);
		checkIndex(index);
		temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.value = argValue;
		// printEntireList();
	}

	public <T> void updateFirst(final T argValue) {
		System.out.println("Updating at first");
		if (head != null) {
			head.value = argValue;
		}
		// printEntireList();
	}

	public <T> void updateLast(final T argValue) {
		System.out.println("Updating at last");
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.value = argValue;
		// printEntireList();
	}

	public void printEntireList() {
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
	public void removeDuplicate() {
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
	public int printKthElementFromLast(final Node argHead, int argIndexK) {
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
	public Node returnKthFromLast(final Node argHead, int argIndexK) {
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

	public Node returnKthFromLastIterative(Node argHead, int argIndexK) {
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
