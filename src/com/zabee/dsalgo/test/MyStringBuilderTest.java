package com.zabee.dsalgo.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import com.zabee.dsalgo.myexperiments.MyStringBuilder;

public class MyStringBuilderTest {

	static MyStringBuilder myStringBuilder = new MyStringBuilder();

	@After
	public void printIndividual() {
		System.out.println("Result:" + myStringBuilder.toString());
	}
	
	@AfterClass
	public static void printAll() {
		System.out.println("All Result:" + myStringBuilder.toString());
	}

	@Test
	public void testBoolean() {
		myStringBuilder.append(true);
		myStringBuilder.append(false);
		myStringBuilder.append(true);
		myStringBuilder.append(false);
		myStringBuilder.append(true);
		myStringBuilder.append(false);
		myStringBuilder.append(true);
		myStringBuilder.append(false);
	}

	@Test
	public void testCharacter() {
		myStringBuilder.append('a');
		myStringBuilder.append('a');
		myStringBuilder.append('a');
		myStringBuilder.append('a');
		myStringBuilder.append('a');
		myStringBuilder.append('a');
		myStringBuilder.append('a');
		myStringBuilder.append('a');
	}

	@Test
	public void testInteger() {
		myStringBuilder.append(10);
		myStringBuilder.append(20);
		myStringBuilder.append(10);
		myStringBuilder.append(20);
		myStringBuilder.append(10);
		myStringBuilder.append(20);
		myStringBuilder.append(10);
		myStringBuilder.append(20);
	}

	@Test
	public void testFloat() {
		myStringBuilder.append(2.12f);
		myStringBuilder.append(2.12f);
		myStringBuilder.append(2.12f);
		myStringBuilder.append(2.12f);
	}

	@Test
	public void testLong() {
		myStringBuilder.append(2147483647);
	}

	@Test
	public void testDouble() {
		myStringBuilder.append(2147483647.34);
		myStringBuilder.append(2147483647.34);
		myStringBuilder.append(2147483647.34);
		myStringBuilder.append(2147483647.34);
		myStringBuilder.append(2147483647.34);
		myStringBuilder.append(2147483647.34);
	}

	@Test
	public void testString() {
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
		myStringBuilder.append("This is me ");
	}

}
