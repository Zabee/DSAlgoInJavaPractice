package com.zabee.dsalgo.myexperiments.stackandqueues;

public class QueueUsingStacks {
	private MyStackUsingArray<Integer> newStack = new MyStackUsingArray<>(Integer.class, 10);
	private MyStackUsingArray<Integer> olderStack = new MyStackUsingArray<>(Integer.class, 10);

	public void add(int ele) {
		newStack.push(ele);
	}

	public int delete() {
		shiftStacks();
		return olderStack.isEmpty() ? -1 : olderStack.pop();
	}

	public int peek() {
		shiftStacks();
		return olderStack.isEmpty() ? -1 : olderStack.peek();
	}

	private void shiftStacks() {
		while (!newStack.isEmpty()) {
			olderStack.push(newStack.pop());
		}
	}

	public static void main(String[] args) {
		QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
		queueUsingStacks.add(0);
		queueUsingStacks.add(1);
		queueUsingStacks.add(2);
		queueUsingStacks.add(3);
		queueUsingStacks.add(4);
		queueUsingStacks.add(5);
		queueUsingStacks.add(6);
		queueUsingStacks.add(7);
		queueUsingStacks.add(8);
		for(int i=0; i<9; i++) {
			System.out.println(queueUsingStacks.delete());	
		}
		
		
		
	}

}
