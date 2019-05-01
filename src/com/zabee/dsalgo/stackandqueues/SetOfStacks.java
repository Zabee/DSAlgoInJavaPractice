package com.zabee.dsalgo.stackandqueues;

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
		push(30);
		push(30);
		push(30);
		System.out.println("Pushing ends here!!");
		popAtIndex(2);
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
		if (last.isEmpty()) {
			setOfStacks.remove(setOfStacks.size() - 1);
		}
		return value;
	}

	/**
	 * It takes to implement SimpleStack with LinkedList instead of Arrays
	 * 
	 * @param index
	 * @param removeTop
	 * @return
	 */
//	public static int popAtIndexRecursively(int index, boolean removeTop) {
//		int removedItem;
//		SimpleStack stack = setOfStacks.get(index);
//		if (removeTop) {
//			removedItem = stack.pop();
//		} else {
//			removedItem = stack.removeBottom();
//		}
//		if (stack.isEmpty()) {
//			setOfStacks.remove(index);
//		} else if (setOfStacks.size() > index + 1) {
//			int v = popAtIndexRecursively(index + 1, false);
//			stack.push(v);
//		}
//		return removedItem;
//	}

	public static int popAtIndex(int index) {
		// Index is starting from zero
		index--;
		int returnValue = -1;
		try {
			if (index > setOfStacks.size()) {
				throw new ArrayIndexOutOfBoundsException();
			}
			// index is already decremented by 1
			last = setOfStacks.get(index);
			returnValue = last.pop();
			if (last.isEmpty()) {
				setOfStacks.remove(index);
			} else {
				leftShift(index);
			}

		} catch (ArrayIndexOutOfBoundsException ioE) {
			System.out.println("Index of out of array stack bound");
		}
		return returnValue;
	}

	private static void leftShift(int index) {
		SimpleStack curr, next;
		for (int i = index; i < setOfStacks.size() - 1; i++) {
			curr = setOfStacks.get(i);
			next = setOfStacks.get(i + 1);
			curr.push(next.pop());
		}
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

	public boolean isEmpty() {
		if (top == -1) {
			System.out.println("Stack is empty!");
			return true;
		}
		return false;
	}

	public int pop() {
		if (isEmpty()) {
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