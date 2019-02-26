package com.zabee.dsalgo.myexperiments.linkedlist;

/**
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5] Output: 3 -> 1 -> 2 ->
 * 10 -> 5 -> 5 -> 8
 * 
 * @author Zabee
 *
 */
public class PartitionSinglyLinkedList {

	public static void partition(Node startNode, int x) {
		if (startNode == null) {
			return;
		}
		Node firstPart = null, secondPart = null, firstTemp = null, secondTemp = null, anotherTemp = null;
		Node temp = startNode;
		while (temp != null) {
			anotherTemp = temp;
			temp = temp.next;
			anotherTemp.next = null;

			if ((int) anotherTemp.value < x) {
				if (firstPart == null) {
					firstPart = firstTemp = anotherTemp;

				} else {
					firstTemp.next = anotherTemp;
					firstTemp = firstTemp.next;
				}
			} else {
				if (secondPart == null) {
					secondPart = secondTemp = anotherTemp;
				} else {
					secondTemp.next = anotherTemp;
					secondTemp = secondTemp.next;
				}
			}

		}
		firstTemp.next = secondPart;
		linkedList.head = firstPart;
	}

	public static void partitionBetter(Node startNode, int x) {

	}

	private static MyLinkedList linkedList = new MyLinkedList();

	public static void main(String[] args) {

		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(8);
		linkedList.add(5);
		linkedList.add(10);
		linkedList.add(2);
		linkedList.add(1);
		System.out.println("Before partition");
		linkedList.printEntireList();

		partition(linkedList.head, 5);
		linkedList.printEntireList();

//		partitionBetter(linkedList.head, 5);
//		linkedList.printEntireList();
	}
}