package com.zabee.dsalgo.myexperiments.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Test;

import com.zabee.dsalgo.myexperiments.specificalgos.StringCompression;

public class StringCompressionTest {

	char[] result1 = null;
	String tempStr = null;
	char[] trimmedResult = null;
	StringCompression StringCompression = new StringCompression();
	
	@After
	public void resetDS() {
		result1 = null;
		tempStr = null;
		trimmedResult = null;
	}

	@Test
	public void test1() {
		result1 = StringCompression.compressString("aabcccccaaa".toCharArray());
		assertHere("a2b1c5a3".toCharArray());
		
		result1 = StringCompression.compressString("aaaaaaaaaaa".toCharArray());
		assertHere("a11".toCharArray());
		
		result1 = StringCompression.compressString("abcdefghijk".toCharArray());
		assertHere("abcdefghijk".toCharArray());
		
		result1 = StringCompression.compressString("zabeeulla".toCharArray());
		assertHere("z1a1b1e2u1l2a1".toCharArray());
	}

	@Test
	public void test2() {
		result1 = StringCompression.compressStringSolution1("aabcccccaaa".toCharArray());
		assertHere("a2b1c5a3".toCharArray());
		
		result1 = StringCompression.compressStringSolution1("aaaaaaaaaaa".toCharArray());
		assertHere("a11".toCharArray());
		
		result1 = StringCompression.compressStringSolution1("abcdefghijk".toCharArray());
		assertHere("abcdefghijk".toCharArray());
		
		result1 = StringCompression.compressStringSolution1("zabeeulla".toCharArray());
		assertHere("z1a1b1e2u1l2a1".toCharArray());
	}

	private void assertHere(char[] expected) {
		// This circus is necessary
		tempStr = String.valueOf(result1);
		trimmedResult = tempStr.trim().toCharArray();
		assertArrayEquals(expected, trimmedResult);
	}
}
