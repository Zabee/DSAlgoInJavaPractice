package com.zabee.dsalgo.myexperiments.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.zabee.dsalgo.myexperiments.linkedlist.LinkedListPalindrome;
import com.zabee.dsalgo.myexperiments.linkedlist.MyLinkedList;

public class LinkedListPalidromTest {

	MyLinkedList linkedList = new MyLinkedList();

	@Test
	public void testPalindrom() {
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(2);
		linkedList.add(1);
		assertNotNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
		
		clearList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(2);
		linkedList.add(1);
		assertNotNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
		
		clearList();
		linkedList.add(1);
		assertNotNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
		
		clearList();
		linkedList.add('m');
		linkedList.add('a');
		linkedList.add('a');
		linkedList.add('m');
		assertNotNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNotNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
	}

	@Before
	public void clearList() {
		linkedList.destroyList();
	}

	@Test
	public void testNotPalindrom() {
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(4);
		linkedList.add(5);
		assertNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
		
		clearList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(2);
		linkedList.add(5);
		assertNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
		
		clearList();
		linkedList.add('m');
		linkedList.add('a');
		linkedList.add('d');
		linkedList.add('a');
		linkedList.add('m');
		linkedList.add('m');
		assertNull(LinkedListPalindrome.checkIfPalindromeIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNull(LinkedListPalindrome.checkIfPalindromeBetterIterative(linkedList.getHead()/*, linkedList.getHead()*/));
		assertNull(LinkedListPalindrome.checkIfPalindromeRecursive(linkedList.getHead(), linkedList.getHead()));
	}
	
}
