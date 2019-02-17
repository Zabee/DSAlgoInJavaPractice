package com.zabee.just.java.practice;
public class SubConstCallOverrideMethod {

	public static void main(String[] args) {

		// Will work fine
		A a = new A();
		a.somePolyMorphicMethod();

		// Null - pointer exception
		B b = new B();
		b.somePolyMorphicMethod();

	}
}

class A {
	String aString = null;

	A() {
		somePolyMorphicMethod();
		aString = "class A string";
	}

	void somePolyMorphicMethod() {
		System.out.println("In A's somePolymorphicMethod");

	}

}

class B extends A {
	int posOfLetterA = 0;

	B() {
		somePolyMorphicMethod();
	}

	@Override
	void somePolyMorphicMethod() { // overriden

		posOfLetterA = aString.indexOf("A"); // throws null pointer exception,
		// aString NOT created yet!!
	}
}
