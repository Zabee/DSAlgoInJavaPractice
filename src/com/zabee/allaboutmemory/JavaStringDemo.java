package com.zabee.allaboutmemory;

public class JavaStringDemo {

	public static void main(String[] args) {
		String myName = "Zabee";
		String yourName = "Zabee";
		if (myName == yourName) {
			System.out.println("You gave this from String pool which is logical part of Heap space now");
		}
		String hisName = new String("Zabee");
		if (myName == hisName) {
			System.out.println("The new has gave hisName from string pool");
		} else {
			System.out.println("The new has created the hisName string object inside heap memory");
		}

		String someName = new String("SomeName");
		String herName = "SomeName";

		if (someName == herName) {
			System.out.println("You created on heap and then also put the object in string pool");
		} else {
			System.out.println("when you new a string object it doesn't have anything to do with string pool");
		}

		String otherOtherName = new String("SomeOne'sName");
		otherOtherName.intern(); // Throw the string literal "SomeOne'sName" into string pool
		String someOtherName = "SomeOne'sName";
		String otherName = "SomeOne'sName";
		if (otherName == someOtherName) {
			System.out.println(
					"intern() has added the new'ed object value - string literal into string pool in addition to having it in heap space. Now enjoy");
		} else {
			System.out.println("intern() has nothing to do with string pool");
		}

	}

}
