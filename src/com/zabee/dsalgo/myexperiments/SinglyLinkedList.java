package com.zabee.dsalgo.myexperiments;

import java.util.Scanner;

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
	private static Node head, tail;
	private static Node temp;
	private static int listLength;

	private LinkedList() {

	}

	Node newNode;

	public static <T> void insertFirst(final T argValue) {
		System.out.println("Inserting at first");
		Node<T> newNode = new Node<T>(argValue);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		listLength++;
		printEntireList();
	}

	public static <T> void insertLast(final T argValue) {
		System.out.println("Inserting at last");
		Node<T> newNode = new Node<T>(argValue);
		temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;

		listLength++;
		printEntireList();

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
		System.out.println("Inserting at " + index);
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
		printEntireList();
	}

	public static void removeFirst() {
		System.out.println("Removing from first");

		listLength--;
		printEntireList();
	}

	public static void removeLast() {
		System.out.println("Removing from last");

		listLength--;
		printEntireList();
	}

	public static void removeAt(final int index) {
		System.out.println("Removing from " + index);
		checkIndex(index);

		listLength--;
		printEntireList();
	}

	public static <T> void updateAt(final int index, final T argValue) {
		System.out.println("Updating at " + index);
		checkIndex(index);
		printEntireList();
	}

	public static <T> void updateFirst(final T argValue) {
		System.out.println("Updating at first");
		printEntireList();
	}

	public static <T> void updateLast(final T argValue) {
		System.out.println("Updating at last");
		printEntireList();
	}

	public static void printEntireList() {
		temp = head;
		if (temp != null) {
			while (temp.next != null) {
				System.out.print("[" + temp.value + "]->");
				temp = temp.next;
			}
			System.out.print("[" + temp.value + "]-||\n");
		}
	}
}
