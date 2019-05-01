package com.zabee.dsalgo.stackandqueues;

import java.lang.reflect.Array;

/**
 * No point in having a queue implemented using linkedlist in circle. So let's
 * try with arrays
 * 
 * @author Zabee
 *
 */
public class MyCircularQueue<T> {
	T[] values;
	int front = -1, rear = -1;
	Class valuesClass;
	final int MAX;

	public MyCircularQueue(Class argClass, int argLen) {
		values = (T[]) Array.newInstance(argClass, argLen);
		valuesClass = argClass;
		MAX = values.length;
	}

	public void add(T argElement) {
		if ((rear + 1) % (MAX) == front) {
			System.out.println("Queue is full ");
			return;
		}
		if (rear == front && rear == -1) {
			front++;
		}
		rear = (rear + 1) % MAX;
		values[rear] = argElement;
	}

	public T delete() {
		front = front + 1 % MAX;
		return values[front - 1];
	}

	public T peek() {
		return values[front];
	}

	public void printEntireQueue() {
		if (front == rear && front == -1) {
			System.out.println("Queue is empty!!");
			return;
		}
		int i = front;
		while (i != rear) {
			System.out.print(values[i] + "|");
			i = (i + 1) % MAX;
		} // Last element at 0. After circle it should print
		System.out.print(values[i] + "|");
		

		System.out.println();
	}

	public static void main(String[] args) {
		MyCircularQueue<Integer> circularQueue = new MyCircularQueue<>(Integer.class, 5);
		circularQueue.add(1);
		circularQueue.add(2);
		circularQueue.add(3);
		circularQueue.add(4);
		circularQueue.add(5);
		circularQueue.add(6);

		System.out.println("Deleted :" + circularQueue.delete());
		System.out.println("Deleted :" + circularQueue.delete());
		System.out.println("Deleted :" + circularQueue.delete());
		circularQueue.add(6);
		circularQueue.add(7);
		circularQueue.add(8);

		circularQueue.printEntireQueue();
	}

}
