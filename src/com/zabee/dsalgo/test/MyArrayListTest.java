package com.zabee.dsalgo.test;

import org.junit.Test;

import com.zabee.dsalgo.myexperiments.MyArrayList;

public class MyArrayListTest {

	@Test
	public void testMyArrayList() {
		MyArrayList myArrayList = new MyArrayList();
		for (int i = 0; i < 10; i++)
			myArrayList.add(i);
		System.out.println(myArrayList);
	}

	@Test
	public void testMyArrayListForCapacityLimit() {
		MyArrayList myArrayList = new MyArrayList();
		for (int i = 0; i < 10; i++)
			myArrayList.add(i);
		System.out.println("Older Capacity: " + myArrayList.capacity);
		myArrayList.add(11);
		System.out.println("Newer Capacity: " + myArrayList.capacity);
		System.out.println(myArrayList);
	}
}
