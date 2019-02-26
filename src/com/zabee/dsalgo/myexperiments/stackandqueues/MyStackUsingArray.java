package com.zabee.dsalgo.myexperiments.stackandqueues;

import java.lang.reflect.Array;

public class MyStackUsingArray<T> {

	private T[] values;
	private int top = -1;
	private Class thisClass;

	public MyStackUsingArray(Class<T> c, int size) {
//		@Suppr	essWarnings("unchecked")
		values = (T[]) Array.newInstance(c, size);
		thisClass = c;
	}

	public void push(T argElement) {
		if (top + 1 == values.length) {
			resize();
		}
		values[++top] = argElement;
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

	public T pop() {
		if(values.length == 0) {
			System.out.println("Cannot pop anything from an empty stack");
			return null;
		}
			
		return values[top--];
	}

	public T peek() {
		return values[top];
	}

	public void printEntireStack() {
		System.out.println("**");
		for (int i = top; i >= 0; i--) {
			System.out.println(values[i]);
		}
		System.out.println("**");
	}

	public static void main(String[] args) {
		MyStackUsingArray<Integer> stack = new MyStackUsingArray<>(Integer.class, 2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.printEntireStack();
		
		System.out.println(stack.pop());
		stack.push(5);
		stack.printEntireStack();

		System.out.println(stack.pop());

		stack.printEntireStack();

	}

}
