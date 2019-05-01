package com.zabee.dsalgo.trees;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrieTest {
	private static Trie trie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This is very beginning of starting test");
		trie = new Trie();
		trie.insert("apple");
		trie.insert("amazon");
		trie.insert("amazing");
		trie.insert("ball");
		trie.insert("bat");
		trie.insert("cat");
		trie.insert("car");
		trie.insert("corridor");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This is very end of test");
		System.gc();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before in between calling the tests");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After in between calling the tests");
		System.gc();
	}

	@Test
	public void testSearch() {
		assertTrue(trie.search("apple"));
		assertTrue(trie.search("amazon"));
		assertTrue(trie.search("amazing"));
		assertTrue(trie.search("ball"));
		assertTrue(trie.search("bat"));
		assertTrue(trie.search("cat"));
		assertTrue(trie.search("car"));
		assertTrue(trie.search("corridor"));
		
		assertFalse(trie.search("appl"));
		assertFalse(trie.search("amaon"));
		assertFalse(trie.search("mazing"));
		assertFalse(trie.search("all"));
		assertFalse(trie.search("zat"));
		assertFalse(trie.search("fat"));
		assertFalse(trie.search("dar"));
		assertFalse(trie.search("coridor"));
	}

	@Test
	public void testPrefix() {
		assertTrue(trie.prefix("apple"));
		assertTrue(trie.prefix("amazo"));
		assertTrue(trie.prefix("amazin"));
		assertTrue(trie.prefix("ball"));
		assertTrue(trie.prefix("ba"));
		assertTrue(trie.prefix("cat"));
		assertTrue(trie.prefix("car"));
		assertTrue(trie.prefix("corrido"));
		
		assertFalse(trie.prefix("applee"));
		assertFalse(trie.prefix("amaon"));
		assertFalse(trie.prefix("mazing"));
		assertFalse(trie.prefix("all"));
		assertFalse(trie.prefix("zat"));
		assertFalse(trie.prefix("fat"));
		assertFalse(trie.prefix("dar"));
		assertFalse(trie.prefix("coridor"));
	}

}
