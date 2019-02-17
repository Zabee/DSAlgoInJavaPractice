package com.zabee.just.java.practice;

import java.util.*;

public class QueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> theIntList = new ArrayList<>();
		int stackPointer = 0;
		theIntList.add(stackPointer++, 10);
		theIntList.add(stackPointer++, 20);
		theIntList.add(stackPointer++, 30);
		theIntList.add(stackPointer++, 40);
		System.out.println(theIntList);
		theIntList.remove(--stackPointer);
		System.out.println(theIntList);
		System.exit(-1);
		
		Queue<String> theQueue = new LinkedList<>();
		theQueue.add("Vaseem");
		theQueue.add("Zabee");
		theQueue.add("Nadeem");
		theQueue.add("Younus");
		theQueue.add("Umar");

		System.out.println(theQueue);

		System.out.println(theQueue.remove("Younus"));
		System.out.println(theQueue);

		Stack<String> theStack = new Stack();
		theStack.push("Vaseem");
		theStack.push("Zabee");
		theStack.push("Nadeem");
		theStack.push("Younus");
		theStack.push("Umar");

		System.out.println(theStack);

		System.out.println(theStack.pop());

		System.out.println(theStack);
	}

}