package com.zabee.dsalgo.myexperiments.linkedlist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void checkForDuplicates() {
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
	public void resetJVMLoadedLinkedList() {
		LinkedList.destroyList();
	}
	
	@Test
	public void checkForDuplicatesFaster() {
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
	
}
