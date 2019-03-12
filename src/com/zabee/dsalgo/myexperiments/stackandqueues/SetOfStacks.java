package com.zabee.dsalgo.myexperiments.stackandqueues;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {

	private static List<SimpleStack> setOfStacks = new ArrayList<>();
	private static final int STACKSIZE = 3;
	private static SimpleStack last;

	public static void main(String[] args) {
		push(10);
		push(10);
		push(10);
		push(20);
		push(20);
		push(20);
		System.out.println("Pushing ends here!!");

		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}

	public static void push(final int element) {
		last = getLastStack();
		if (last.isStackFull()) {
			last = new SimpleStack(STACKSIZE);
			setOfStacks.add(last);
		}
		last.push(element);
	}

	public static int pop() {
		if (areAllStacksEmpty()) {
			return -1;
		}
		last = getLastStack();
		int value = last.pop();
		if (last.isStackEmpty()) {
			setOfStacks.remove(setOfStacks.size() - 1);
		}
		return value;
	}

	private static boolean areAllStacksEmpty() {
		if (setOfStacks.size() == 0) {
			System.out.println("Stacks are empty!");
			return true;
		}
		return false;
	}

	public static int peek() {
		if (areAllStacksEmpty()) {
			return -1;
		}
		last = getLastStack();
		return last.peek();
	}

	public static SimpleStack getLastStack() {
		if (setOfStacks.size() == 0) {
			setOfStacks.add(new SimpleStack(STACKSIZE));
		}
		// Hence we are referring using index -1
		System.out.println("Operating with Stack # " + (setOfStacks.size() - 1));
		return setOfStacks.get(setOfStacks.size() - 1);
	}

}

class SimpleStack {
	private final int stackSize;
	private int top;
	private int[] values;

	public SimpleStack(int argStackSize) {
		stackSize = argStackSize;
		top = -1;
		values = new int[stackSize];
	}

	public boolean isStackFull() {
		if (top == stackSize - 1) {
			System.out.println("Stack is full");
			return true;
		}
		return false;
	}

	public void push(int argElement) {
		if (isStackFull()) {
			return;
		}
		values[++top] = argElement;
	}

	public boolean isStackEmpty() {
		if (top == -1) {
			System.out.println("Stack is empty!");
			return true;
		}
		return false;
	}

	public int pop() {
		if (isStackEmpty()) {
			return -1;
		}
		return values[top--];
	}

	public int peek() {
		if (top == -1) {
			System.out.println("Stack is empty!");
			return -1;
		}
		return values[top];
	}
}