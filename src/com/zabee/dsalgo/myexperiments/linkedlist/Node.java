package com.zabee.dsalgo.myexperiments.linkedlist;

public class Node<T> implements Cloneable {
	// Letting you free a little but don't think you're free in the wild
	Node next;
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

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

	@Override
	public Object clone()  {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
