package com.zabee.dsalgo.myexperiments.linkedlist;

public class Node<T> {
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

	// hashcode() and equals(obj) are used only in loop detection.
	// All the remaining time they are commented
	@Override
	public int hashCode() {
		int ascii = 0;
		char character = (char) value;
		ascii = (int) character;
		return ascii;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else
			return false;
	}

}
