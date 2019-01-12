package com.zabee.dsalgo.myexperiments.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import craking.the.coding.interview.exercises.Examples_Exercises.IsStringWithUniqueChars;

public class IsStringWithUniqueCharsTest {

	IsStringWithUniqueChars isUniqueChecker = new IsStringWithUniqueChars(); 
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

	@Test
	public void testSkippingSpace() {
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented", true));
		assertTrue(isUniqueChecker.isUniqueWithSetDS("Time has xyz", true));
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented", true));
		assertTrue(isUniqueChecker.isUniqueWithSetDS("Abcdef gh ijklmn", true));
	}
	
	@Test
	public void testNotSkippingspace() {
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented"));
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Time has xyz"));
		assertFalse(isUniqueChecker.isUniqueWithSetDS("Not yet implemented"));
		assertTrue(isUniqueChecker.isUniqueWithSetDS("Abcdefgh ijklmn"));
	}
	
	@Test
	public void testWithoutAnyDS() {
		assertFalse(isUniqueChecker.isUniqueWithoutAnyDS("Not yet implemented"));
		assertFalse(isUniqueChecker.isUniqueWithoutAnyDS("Time has xyz"));
		assertFalse(isUniqueChecker.isUniqueWithoutAnyDS("Not yet implemented"));
		assertTrue(isUniqueChecker.isUniqueWithoutAnyDS("Abcdefgh ijklmn"));
	}

}
