package practice.concepts;

import java.util.*;

/**
 *
 *
 * @author Zabee
 * @created August 14, 2018
 */
public class QueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
