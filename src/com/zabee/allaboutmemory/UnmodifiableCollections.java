package com.zabee.allaboutmemory;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnmodifiableCollections {

	public static void main(String[] args) {
		MyClass myObject = new MyClass();
//		myObject.getSomeNames().clear();
//		myObject.getSomeNameUnmodifiable()

		myObject.getSomeNames()//
				.stream()//
				.forEach(System.out::println);

	}

}

class MyClass {
	private List<String> someNames = Arrays.asList("Zabee", "John", "Amanda", "Joe", "Lele");
	private Map<Integer, String> rollNoNameMap = new HashMap<Integer, String>();

	// Escaping reference happening here!!
	public List<String> getSomeNames() {
		return someNames;
	}

	public void setSomeNames(List<String> someNames) {
		this.someNames = someNames;
	}

	public List<String> getSomeNameUnmodifiable() {
		return Collections.unmodifiableList(someNames);
	}

	public Map<Integer, String> getRollNoNameMap() {
		return Collections.unmodifiableMap(rollNoNameMap);
	}

	public void setRollNoNameMap(Map<Integer, String> rollNoNameMap) {
		this.rollNoNameMap = rollNoNameMap;
	}
}