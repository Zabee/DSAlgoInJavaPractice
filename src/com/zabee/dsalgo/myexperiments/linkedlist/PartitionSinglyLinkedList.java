package com.zabee.dsalgo.myexperiments.linkedlist;

/**
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5] 
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * 
 * @author zulla
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
		LinkedList.head = firstPart;
	}

	public static void partitionBetter(Node startNode, int x) {

	}

	public static void main(String[] args) {
		LinkedList.add(3);
		LinkedList.add(5);
		LinkedList.add(8);
		LinkedList.add(5);
		LinkedList.add(10);
		LinkedList.add(2);
		LinkedList.add(1);
		System.out.println("Before partition");
		LinkedList.printEntireList();

		partition(LinkedList.head, 5);
		LinkedList.printEntireList();

//		partitionBetter(LinkedList.head, 5);
//		LinkedList.printEntireList();
	}
}