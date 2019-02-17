package com.zabee.just.java.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorVSForEach {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			intList.add(i);
		}
		System.out.println(intList);
		for (Integer x : intList) {
			x = 0;
		}
		System.out.println(intList);
		int x =2;
		ListIterator<Integer> listIterator = null;
		for (listIterator = intList.listIterator(); x >0; listIterator.next(), x--);			
		listIterator.remove();
		listIterator.next();
		listIterator.add(1);
		System.out.println(intList);
	}

}
