package com.zabee.dsalgo.myexperiments.stackandqueues;

import com.zabee.dsalgo.myexperiments.linkedlist.Node;

public class MyQueueUsingLinkedList<T> {

	Node<T> front, rear, temp;

	public MyQueueUsingLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public void add(T argElement) {
		Node aNode = new Node<T>(argElement);
		if (front == null) {
			front = rear = aNode;
		} else {
			rear.setNext(aNode);
			rear = aNode;
		}
	}

	public Node delete() {
		temp = front;
		front = front.getNext();
		temp.setNext(null);
		return temp;
	}

	public Node peek() {
		temp = (Node<T>) front.clone();
		temp.setNext(null);
		return temp;
	}

	public void printEntireQueue() {
		temp = front;
		while (temp != null) {
			System.out.print(temp.getValue() + "|");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MyQueueUsingLinkedList<Integer> queue = new MyQueueUsingLinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.printEntireQueue();
		
		queue.delete();
		queue.printEntireQueue();	
		
		System.out.println(queue.peek());
		queue.printEntireQueue();	
	}

}
