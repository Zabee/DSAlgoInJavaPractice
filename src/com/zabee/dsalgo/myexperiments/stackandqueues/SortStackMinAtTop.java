package com.zabee.dsalgo.myexperiments.stackandqueues;

public class SortStackMinAtTop {
	private static MyStackUsingArray<Integer> oStack = new MyStackUsingArray<>(Integer.class, 10);
	private static MyStackUsingArray<Integer> tStack = new MyStackUsingArray<>(Integer.class, 10);

	public static void main(String[] args) {
		oStack.push(1);
		oStack.push(2);
		oStack.push(3);
		oStack.push(4);
		oStack.push(5);
		oStack.push(6);
		oStack.printEntireStack();
		oStack = new MyStackUsingArray<>(Integer.class, 10);
		System.out.println("*******************************");
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		push(6);

		oStack.printEntireStack();
	}

	private static void push(int element) {
		while (oStack.getTop() != -1 && oStack.peek() < element) {
			tStack.push(oStack.pop());
		}
		oStack.push(element);

		while (!tStack.isEmpty()) {
			oStack.push(tStack.pop());
		}
	}
}
