package com.zabee.allaboutmemory;

public class StackAndHeapMemoryAllocationExample {

	public static void main(String[] args) {
		int age = 25;
		String name = "Joe";
		StackAndHeapMemoryAllocationExample stackAndHeapMemoryAllocationExample = new StackAndHeapMemoryAllocationExample();
		Person p = stackAndHeapMemoryAllocationExample.new Person(age, name);
	}

	private class Person {
		private int pAge;
		private String pName;

		public Person(final int pAge, final String pName) {
			this.pAge = pAge;
			setPersonName(pName);
		}

		public void setPersonName(final String argName) {
			this.pName = argName;
		}
	}
}
