package com.zabee.dsalgo.stackandqueues;

import java.lang.reflect.Array;

import com.zabee.dsalgo.linkedlist.Node;

public class MyStackUsingLinkedList<T> {

	private Node<T> top, temp;

	public void push(T argNode) {
		Node<T> aNode = new Node<T>(argNode);
		if (top == null) {
			top = aNode;
			return;
		}
		aNode.setNext(top);
		top = aNode;
	}

	public T pop() {
		if (top == null) {
			System.out.println("Cannot pop anything from an empty stack");
			return null;
		}
		temp = top;
		top = top.getNext();
		temp.setNext(null);
		return (T) temp;
	}

	public T peek() {
		return (T) temp;
	}

	public void printEntireStack() {
		temp = top;
		System.out.println("**");
		while (temp != null) {
			System.out.println(temp.getValue());
			temp = temp.getNext();
		}
		System.out.println("**");
	}

	public static void main(String[] args) {
		MyStackUsingLinkedList<Integer> stack = new MyStackUsingLinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printEntireStack(); // 4 3 2 1

		System.out.println(stack.pop());
		stack.push(5); // 5 3 2 1
		stack.printEntireStack(); // 5 3 2 1

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		

		stack.printEntireStack(); // 3 2 1

	}

}
