package com.zabee.just.java.practice;

import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> conMap = new ConcurrentHashMap<>(/* 1, 1, 1 */);
		for(int i=0; i<10; i++) {
			conMap.put(i, i);
			if(i==7) {
				conMap.remove(i);	
			}
			if(i==8) {
				conMap.put(i-1, i-1);
			}
		}
		System.out.println(conMap);
//		for(Entry<Integer, Integer> entrySet : conMap.entrySet()) {
		Set<Entry<Integer, Integer>> entrySet = conMap.entrySet();
		for(Entry<Integer, Integer> entry : entrySet) {
			System.out.print(entry + "\t");
		}
			
//		}
		System.out.println();
		for(Integer integer : conMap.values()) {
			System.out.print(integer + "\t");
		}
		System.out.println();
		for(Integer integer : conMap.keySet()) {
			System.out.print(integer + "\t");
		}
	}

}
