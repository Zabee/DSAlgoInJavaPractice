package com.zabee.dsalgo.linkedlist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.print.Printable;

import org.junit.After;
import org.junit.Test;

public class SinglyLinkedListTest {

	MyLinkedList linkedList = new MyLinkedList();
	
	@Test
	public void testCheckForDuplicates() {
		linkedList.insertLast(90);
		linkedList.insertLast(80);
		linkedList.insertLast(70);
		linkedList.insertLast(60);
		linkedList.insertLast(40);
		linkedList.insertLast(40);
		linkedList.insertLast(30);
		linkedList.insertLast(20);
		linkedList.insertLast(10);
		linkedList.insertLast(0);
		assertFalse(linkedList.isListUnique());

		linkedList.updateAt(5, 50);
		assertTrue(linkedList.isListUnique());
	}

	@After
	public void testResetJVMLoadedLinkedList() {
		linkedList.destroyList();
	}

	
	public void testCheckForDuplicatesFaster() {
		linkedList.insertLast(90);
		linkedList.insertLast(80);
		linkedList.insertLast(70);
		linkedList.insertLast(60);
		linkedList.insertLast(40);
		linkedList.insertLast(40);
		linkedList.insertLast(30);
		linkedList.insertLast(20);
		linkedList.insertLast(10);
		linkedList.insertLast(0);
		assertFalse(linkedList.isListUniqueFasterApproach());

		linkedList.updateAt(5, 50);
		assertTrue(linkedList.isListUniqueFasterApproach());
	}

	
	public void testRemoveDulicates() {
		linkedList.insertLast(90);
		linkedList.insertLast(80);
		linkedList.insertLast(70);
		linkedList.insertLast(60);
		linkedList.insertLast(40);
		linkedList.insertLast(40);
		linkedList.insertLast(30);
		linkedList.insertLast(20);
		linkedList.insertLast(10);
		linkedList.insertLast(0);
		linkedList.printEntireList();
		linkedList.removeDuplicate();
		linkedList.printEntireList();
		assertTrue(linkedList.isListUnique());
		assertTrue(linkedList.isListUniqueFasterApproach());
	}
	
//	@Test
	 public void testReturnKthElement() {
		linkedList.insertLast(90);
		linkedList.insertLast(80);
		linkedList.insertLast(70);
		linkedList.insertLast(60);
		linkedList.insertLast(50);
		linkedList.insertLast(40);
		linkedList.insertLast(30);
		linkedList.insertLast(20);
		linkedList.insertLast(10);
		linkedList.insertLast(0);
		linkedList.insertLast("Some generics here");
		linkedList.printEntireList();
		/*assertEquals(80, */linkedList.printKthElementFromLast(linkedList.head, 4)/*);*/;
		Node<?> theNode = linkedList.returnKthFromLast(linkedList.head, 4);
		System.out.println("RECURSIVE: The node is " + (theNode != null ? theNode.value : theNode));
		theNode = linkedList.returnKthFromLastIterative(linkedList.head, 4);
		System.out.println("ITERATIVE: The node is " + (theNode != null ? theNode.value : theNode));
	}
	
	public void testDeleteByValue() {
		linkedList.insertLast(90);
		linkedList.insertLast(80);
		linkedList.insertLast(70);
		linkedList.insertLast(60);
		linkedList.insertLast(50);
		linkedList.insertLast(40);
		linkedList.insertLast(30);
		linkedList.insertLast(20);
		linkedList.insertLast(10);
		linkedList.insertLast(0);
		
		linkedList.deleteByValue(50);
		linkedList.printEntireList();
		
		linkedList.deleteByValue(2);
		linkedList.printEntireList();
		
		linkedList.deleteByValue(20);
		linkedList.printEntireList();
		
		linkedList.deleteByValue(10);
		linkedList.printEntireList();
	}
	
	@Test
	public void deleteFromMiddle() {
		linkedList.insertLast(90);
		linkedList.insertLast(80);
		linkedList.insertLast(70);
		linkedList.insertLast(60);
		linkedList.insertLast(50);
		linkedList.insertLast(40);
		linkedList.insertLast(30);
		linkedList.insertLast(20);
		linkedList.insertLast(10);
		linkedList.insertLast(0);
		linkedList.printEntireList();
		
		linkedList.deleteFromMiddleUsingAdditionalPointerOrNodeInJavaWorld(0);
		linkedList.printEntireList();
		
		linkedList.deleteFromMiddleOnly(linkedList.getNodeByValue(30));
		linkedList.printEntireList();
	}
	
}
