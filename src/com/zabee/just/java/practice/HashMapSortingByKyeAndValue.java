package com.zabee.just.java.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * There are four approaches (1) Using TreeMap (2) Using ArrayList and
 * Collections.sort() (3) TreeSet (4) Using the Stream API
 * 
 * @author Zabee
 *
 */

public class HashMapSortingByKyeAndValue {

	public static void main(String[] args) {
		Supplier<Map<Integer, String>> suplier = HashMap<Integer, String>::new;
		Map<Integer, String> empNoNameMap = suplier.get();
		empNoNameMap.put(11,  "Zabee");
		empNoNameMap.put(2,  "Bee");
		empNoNameMap.put(3,  "Abee");
		empNoNameMap.put(14,  "Ee");
		empNoNameMap.put(1,  "Zabee");
		empNoNameMap.put(0,  "Abhi");
		empNoNameMap.put(7,  "John");
		empNoNameMap.put(20,  "Johnson");
		
//		TreeMap<Integer, String> sortedEmpHashMap = new TreeMap<Integer, String>(empNoNameMap);
//		sortedEmpHashMap.forEach((key, value)-> System.out.println(key + ":" + value));
		
//		TreeSet<String> sortedName = new TreeSet<String>(empNoNameMap.values());
//		sortedName.stream().forEach(System.out::println);
		System.out.println("===========================================================================");
		empNoNameMap.entrySet().stream().sorted((Map.Entry.comparingByKey())).forEach(System.out::println);
		System.out.println("===========================================================================");
//		empNoNameMap.entrySet().stream().forEach(System.out::println);
		
		LinkedHashMap<Integer, String> sortedEmpNoNameMap = empNoNameMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors
							.toMap(
									Map.Entry::getKey, 
									Map.Entry::getValue, 
									(oldKey, newKey) -> newKey, 
									LinkedHashMap::new
								)
						);
		
		System.out.println("===========================================================================");		
		sortedEmpNoNameMap.entrySet().forEach(System.out::println);
	}

}
