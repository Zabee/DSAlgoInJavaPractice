package com.zabee.dsalgo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import craking.the.coding.interview.exercises.Examples_Exercises.StringWithUniqueChars;

public class StringWithUniqueCharsTest {

	StringWithUniqueChars isUniqueChecker = new StringWithUniqueChars(); 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeClass	setUpBeforeClass()");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass	tearDownAfterClass()");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before starting a test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After a test");
	}

	
	public void testSkippingSpace() {
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented", true));
		assertTrue(isUniqueChecker.isUniqueWithSetDS("Time has xyz", true));
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented", true));
		assertTrue(isUniqueChecker.isUniqueWithSetDS("Abcdef gh ijklmn", true));
	}
	
	
	public void testNotSkippingspace() {
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented"));
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Time has xyz"));
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented"));
		assertTrue(isUniqueChecker.isUniqueWithSetDS("Abcdefgh ijklmn"));
	}
	
	
	public void testWithoutAnyDS() {
		assertFalse(isUniqueChecker.isUniqueWithoutAnyDS("Not yet implemented"));
		assertFalse(isUniqueChecker.isUniqueWithoutAnyDS("Time has xyz"));
		assertFalse(isUniqueChecker.isUniqueWithoutAnyDS("Not yet implemented"));
		assertTrue(isUniqueChecker.isUniqueWithoutAnyDS("Abcdefgh ijklmn"));
	}
	
	/**
	 * Space sensitive i.e. space is a character needs to be checked if unique
	 */
	public void testWithBitVector() {
		//Works only for lower case letters
		assertFalse(isUniqueChecker.isUniqueWithBitVector("not yet implemented"));
		assertFalse(isUniqueChecker.isUniqueWithBitVector("time has xyz"));
		assertFalse(isUniqueChecker.isUniqueWithBitVector("not yet implemented"));
		assertTrue(isUniqueChecker.isUniqueWithBitVector("abcdefgh ijklmn"));
	}
	@Test
	public void testWithBooleanArray() {
		assertFalse(isUniqueChecker.isUniqueWithBooleanArray("not yet implemented"));
		assertFalse(isUniqueChecker.isUniqueWithBooleanArray("time has xyz"));
		assertFalse(isUniqueChecker.isUniqueWithBooleanArray("not yet implemented"));
		assertTrue(isUniqueChecker.isUniqueWithBooleanArray("abcdefgh ijklmn"));
	}
}
