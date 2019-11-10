package com.zabee.just.java.practice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapAndNullDemo {

	public static void main(String[] args) {
		Map<Integer, String> rollNoNameMap = new HashMap<>();
		rollNoNameMap.put(null, null);
		rollNoNameMap.put(2, null);
		System.out.println("Successfuly inserted the null key and null value to a normal HashMap");
		
		Map<Integer, String> rollNoNameSynchedMap = Collections.synchronizedMap(new HashMap<Integer, String>());
		rollNoNameSynchedMap.put(null, null);
		
		ConcurrentHashMap<Integer, String> rollNoNameConcurrentMap = new ConcurrentHashMap<>();
		rollNoNameConcurrentMap.put(1, "");
		System.out.println("Successfuly inserted the null key and null value to a normal ConcurrentHashMap");
	}

}
 