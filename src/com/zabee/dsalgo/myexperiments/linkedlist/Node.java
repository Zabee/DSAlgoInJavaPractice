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
}
