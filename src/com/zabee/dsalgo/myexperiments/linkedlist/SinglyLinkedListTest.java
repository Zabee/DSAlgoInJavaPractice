package com.zabee.dsalgo.myexperiments.linkedlist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.print.Printable;

import org.junit.After;
import org.junit.Test;

public class SinglyLinkedListTest {

	
	public void testCheckForDuplicates() {
		LinkedList.insertLast(90);
		LinkedList.insertLast(80);
		LinkedList.insertLast(70);
		LinkedList.insertLast(60);
		LinkedList.insertLast(40);
		LinkedList.insertLast(40);
		LinkedList.insertLast(30);
		LinkedList.insertLast(20);
		LinkedList.insertLast(10);
		LinkedList.insertLast(0);
		assertFalse(LinkedList.isListUnique());

		LinkedList.updateAt(5, 50);
		assertTrue(LinkedList.isListUnique());
	}

	@After
	public void testResetJVMLoadedLinkedList() {
		LinkedList.destroyList();
	}

	
	public void testCheckForDuplicatesFaster() {
		LinkedList.insertLast(90);
		LinkedList.insertLast(80);
		LinkedList.insertLast(70);
		LinkedList.insertLast(60);
		LinkedList.insertLast(40);
		LinkedList.insertLast(40);
		LinkedList.insertLast(30);
		LinkedList.insertLast(20);
		LinkedList.insertLast(10);
		LinkedList.insertLast(0);
		assertFalse(LinkedList.isListUniqueFasterApproach());

		LinkedList.updateAt(5, 50);
		assertTrue(LinkedList.isListUniqueFasterApproach());
	}

	
	public void testRemoveDulicates() {
		LinkedList.insertLast(90);
		LinkedList.insertLast(80);
		LinkedList.insertLast(70);
		LinkedList.insertLast(60);
		LinkedList.insertLast(40);
		LinkedList.insertLast(40);
		LinkedList.insertLast(30);
		LinkedList.insertLast(20);
		LinkedList.insertLast(10);
		LinkedList.insertLast(0);
		LinkedList.printEntireList();
		LinkedList.removeDuplicate();
		LinkedList.printEntireList();
		assertTrue(LinkedList.isListUnique());
		assertTrue(LinkedList.isListUniqueFasterApproach());
	}
	
//	@Test
	 public void testReturnKthElement() {
		LinkedList.insertLast(90);
		LinkedList.insertLast(80);
		LinkedList.insertLast(70);
		LinkedList.insertLast(60);
		LinkedList.insertLast(50);
		LinkedList.insertLast(40);
		LinkedList.insertLast(30);
		LinkedList.insertLast(20);
		LinkedList.insertLast(10);
		LinkedList.insertLast(0);
		LinkedList.insertLast("Some generics here");
		LinkedList.printEntireList();
		/*assertEquals(80, */LinkedList.printKthElementFromLast(LinkedList.head, 4)/*);*/;
		Node<?> theNode = LinkedList.returnKthFromLast(LinkedList.head, 4);
		System.out.println("RECURSIVE: The node is " + (theNode != null ? theNode.value : theNode));
		theNode = LinkedList.returnKthFromLastIterative(LinkedList.head, 4);
		System.out.println("ITERATIVE: The node is " + (theNode != null ? theNode.value : theNode));
	}
	
	public void testDeleteByValue() {
		LinkedList.insertLast(90);
		LinkedList.insertLast(80);
		LinkedList.insertLast(70);
		LinkedList.insertLast(60);
		LinkedList.insertLast(50);
		LinkedList.insertLast(40);
		LinkedList.insertLast(30);
		LinkedList.insertLast(20);
		LinkedList.insertLast(10);
		LinkedList.insertLast(0);
		
		LinkedList.deleteByValue(50);
		LinkedList.printEntireList();
		
		LinkedList.deleteByValue(2);
		LinkedList.printEntireList();
		
		LinkedList.deleteByValue(20);
		LinkedList.printEntireList();
		
		LinkedList.deleteByValue(10);
		LinkedList.printEntireList();
	}
	
	@Test
	public void deleteFromMiddle() {
		LinkedList.insertLast(90);
		LinkedList.insertLast(80);
		LinkedList.insertLast(70);
		LinkedList.insertLast(60);
		LinkedList.insertLast(50);
		LinkedList.insertLast(40);
		LinkedList.insertLast(30);
		LinkedList.insertLast(20);
		LinkedList.insertLast(10);
		LinkedList.insertLast(0);
		LinkedList.printEntireList();
		
		LinkedList.deleteFromMiddleUsingAdditionalPointerOrNodeInJavaWorld(0);
		LinkedList.printEntireList();
		
		LinkedList.deleteFromMiddleOnly(LinkedList.getNodeByValue(30));
		LinkedList.printEntireList();
	}
	
}
