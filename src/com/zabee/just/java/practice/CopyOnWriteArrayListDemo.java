package com.zabee.just.java.practice;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> cowArrayList = new CopyOnWriteArrayList<>();
		cowArrayList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		for (Integer x : cowArrayList) {
			if (x == 7) {
				cowArrayList.remove(x);
				cowArrayList.add(--x, 70);
			}
		}
		System.out.println(cowArrayList);
	}

}
