package com.zabee.dsalgo.myexperiments.stackandqueues;

import java.lang.reflect.Array;

public class MyQueueUsingArray<T> {
	private T[] values;
	private int rear = -1, front = -1;
	private Class thisClass;

	public MyQueueUsingArray(final Class argClass, final int argSize) {
		values = (T[]) Array.newInstance(argClass, argSize);
		thisClass = argClass;
	}

	public void add(T argElement) {
		if (values.length-1 == rear) {
			resize();
		}
		if (front == -1) {
			front = 0;
		}
		values[++rear] = argElement;
	}

	public T delete() {
		return values[front++];
	}

	private void resize() {
		T[] backupValues = (T[]) Array.newInstance(thisClass, values.length);

		int newCapacity = (int) (values.length + values.length * 0.5);
		// This entire things can be done in below one line of code
//		values = Arrays.copyOf(values, newCapacity);

		for (int i = 0; i < values.length; i++) {
			backupValues[i] = values[i];
		}
		values = (T[]) Array.newInstance(thisClass, newCapacity);
		for (int i = 0; i < backupValues.length; i++) {
			values[i] = backupValues[i];
		}
	}

	public void printEntireQueue() {
		for (int i = front; i <= rear; i++) {
			System.out.print(values[i] + "|");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyQueueUsingArray<Integer> queue = new MyQueueUsingArray<>(Integer.class, 5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.printEntireQueue();
		
		queue.delete();
		queue.printEntireQueue();
		
		System.out.println(queue.peek());
		
	}

	public T peek() {
		return values[front];
	}

}
