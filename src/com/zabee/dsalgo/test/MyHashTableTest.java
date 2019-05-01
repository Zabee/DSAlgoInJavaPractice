package com.zabee.dsalgo.test;

import org.junit.AfterClass;
import org.junit.Test;

import com.zabee.dsalgo.myexperiments.MyHashTable;

public class MyHashTableTest {

	@AfterClass
	public static void afterExecution() {
		System.out.println("Execution done. Bye, bye.");
	}
	
	@Test
	public void testMyHashTable() {
		MyHashTable hashTable = new MyHashTable(10);
		hashTable.put(1, 10);
		hashTable.put(2, 20);
		hashTable.put(3, 30);
		hashTable.put(4, 40);
		hashTable.put(5, 50);
		hashTable.put(6, 60);
		hashTable.put(7, 70);
		hashTable.put(8, 80);
		hashTable.put(9, 90);
		hashTable.put(10, 100);
		hashTable.put(11, 110);
		
		System.out.println(hashTable.get(10));
		System.out.println(hashTable.get(11));
		System.out.println(hashTable.get(11));
		System.out.println(hashTable);
	}
	
	

}
