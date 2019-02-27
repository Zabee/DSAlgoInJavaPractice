package com.zabee.dsalgo.myexperiments.stackandqueues;

public class FixedMultiStack {
	private int values[];
	private int pointers[];
	private int numberOfStacks = 3;
	private int stackCapacity;

	public FixedMultiStack(final int fixedSizeForAllStacks) {
		stackCapacity = fixedSizeForAllStacks;
		values = new int[fixedSizeForAllStacks * numberOfStacks];
		pointers = new int[numberOfStacks];
	}

	public void push(int stackNum, int value) throws MyStackOverFlow {
		if (isFull(stackNum)) {
			throw new MyStackOverFlow("Stack " + stackNum + " is full!");
		}
		pointers[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = pointers[stackNum];
		return size + offset - 1;
	}

	private boolean isFull(int stackNum) {
		return pointers[stackNum] == stackCapacity;
	}

	public int pop(int stackNum) throws MyStackOverFlow {
		if (isEmpty(stackNum)) {
			throw new MyStackOverFlow("Stack " + stackNum + " is empty");
		}
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex];
		values[topIndex] = -1;
		pointers[stackNum]--;
		return value;
	}

	private boolean isEmpty(int stackNum) {
		return pointers[stackNum] == 0;
	}

	public static void main(String[] args) throws MyStackOverFlow {
		FixedMultiStack stack = new FixedMultiStack(2);
		stack.push(0, 1);
		stack.push(0, 2);

		stack.push(1, 1);
		stack.push(1, 2);

		stack.push(2, 1);
		stack.push(2, 2);

		stack.printEntireStacks();
		stack.pop(0);
		stack.pop(0);
		stack.printEntireStacks();
		stack.pop(1);
		stack.pop(1);
		stack.printEntireStacks();
		stack.pop(2);
		stack.pop(2);
		stack.printEntireStacks();

	}

	private void printEntireStacks() {
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + "\t");
		}
		System.out.println();
	}

}

class MyStackOverFlow extends Exception {
	public MyStackOverFlow(String errMsg) {
		super(errMsg);
	}
}