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
			MyLinkedList list = new MyLinkedList();
			switch (Integer.valueOf(subCmds[0])) {
			case 1:
				list.insertFirst(subCmds[1]);
				break;
			case 2:
				list.insertAt(Integer.valueOf(subCmds[1]), subCmds[2]);
				break;
			case 3:
				list.insertLast(subCmds[1]);
				break;
			case 4:
				list.removeFirst();
				break;
			case 5:
				list.removeLast();
				break;
			case 6:
				list.removeAt(Integer.valueOf(subCmds[1]));
				break;
			case 7:
				list.updateFirst(subCmds[1]);
				break;
			case 8:
				list.updateAt(Integer.valueOf(subCmds[1]), subCmds[2]);
				break;
			case 9:
				list.updateLast(subCmds[1]);
				break;
			}
		}
	}
}

class Node<T> {
	// Letting you free a little but don't think you're free in the wild
	Node next;
	T value;
	// This is to handle lists summary

	public Node(T argNodeValue) {
		this.value = argNodeValue;
		next = null;
	}

	@Override
	public String toString() {
		return "[" + value + "|" + next + "]";
	}
}
