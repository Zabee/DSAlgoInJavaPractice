package com.zabee.dsalgo.myexperiments.stackandqueues;

public class StackWithMinOnPushPop {
	private int[][] values;
	private int top = -1;
	private int minTop = -1;
	private int size;

	public StackWithMinOnPushPop(int size) {
		this.size = size;
		values = new int[size][2];
//		min = new int[size];
	}

	public void push(int argElement) {
		if (values.length - 1 == top) {
			System.out.println("Stack is full cannot push");
			return;
		}
		int tempTop = top + 1;
		if (top == -1) {
			values[tempTop][1] = argElement;
		} else if (argElement < values[tempTop][1]) {
			values[tempTop][1] = argElement;
		} else {
			values[tempTop][1] = values[top][1];
		}

		values[tempTop][0] = argElement;
		top++;
	}

	public int pop() {
		if (values.length == 0) {
			System.out.println("Cannot pop anything from an empty stack");
			return -1;
		}
		return values[top--][0];
	}

	private int getMinNow() {
		return values[top][1];
	}

	public int peek() {
		return values[top][0];
	}

	public void printEntireStack() {
		System.out.println("**");
		for (int i = top; i >= 0; i--) {
			System.out.println(values[i][0]);
		}
		System.out.println("**");
	}

	public static void main(String[] args) {
		StackWithMinOnPushPop stack = new StackWithMinOnPushPop(10);
		stack.push(1);
		System.out.println("Min is :" + stack.getMinNow());
		stack.push(2);
		System.out.println("Min is :" + stack.getMinNow());
		stack.push(3);
		System.out.println("Min is :" + stack.getMinNow());
		stack.push(-4);
		System.out.println("Min is :" + stack.getMinNow());

		stack.printEntireStack();

		System.out.println(stack.pop());
		System.out.println("Min is :" + stack.getMinNow());
		stack.push(-5);
		System.out.println("Min is :" + stack.getMinNow());
		stack.printEntireStack();
		System.out.println("Min is :" + stack.getMinNow());

		System.out.println(stack.pop());
		System.out.println("Min is :" + stack.getMinNow());

		stack.printEntireStack();

	}

}
