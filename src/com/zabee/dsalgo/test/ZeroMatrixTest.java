package com.zabee.dsalgo.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import craking.the.coding.interview.exercises.Examples_Exercises.ZeroMatrix;

public class ZeroMatrixTest {

	@Test
	public void testZeroMatrix1() {
		final int[][] matrix = { { 1, 2 }, { 0, 4 } };
		final int[][] expected = { { 0, 2 }, { 0, 0 } };
		int[][] result = ZeroMatrix.driver(matrix);
		assertArrayEquals(expected, result);
	}
	@Test
	public void testZeroMatrix2() {
		final int[][] matrix = { { 1, 2, 3}, { 4, 5, 6 } };
		final int[][] expected = { { 1, 2, 3}, { 4, 5, 6 } };
		int[][] result = ZeroMatrix.driver(matrix);
		assertArrayEquals(expected, result);
	}
	@Test
	public void testZeroMatrix3() {
		final int[][] matrix = { { 1, 2, 3}, { 4, 5, 0 } };
		final int[][] expected = { { 1, 2, 0}, { 0, 0, 0 } };
		int[][] result = ZeroMatrix.driver(matrix);
		assertArrayEquals(expected, result);
	}
}
