package com.zabee.dsalgo.bits;

public class BasicBitOperations {

	public static void main(String[] args) {
		int a = -2, b = 1;
		int arithmeticLeftShiftResult = a << 2;
		int arithmeticRightShiftResult = a >> 2;
		int logicalShiftOrLogicalRightShiftResult = a >>> 1;
		int logicalShiftOrLogicalRightShiftPveResult = b >>> 1;

		System.out.println("arithmeticLeftShiftResult : " + arithmeticLeftShiftResult);
		System.out.println("arithmeticRightShiftResult : " + arithmeticRightShiftResult);
		System.out.println(
				"logicalShiftOrLogicalRightShiftResult negative number: " + logicalShiftOrLogicalRightShiftResult);
		System.out.println(
				"logicalShiftOrLogicalRightShiftResult negative number: " + logicalShiftOrLogicalRightShiftPveResult);
		System.out.println("repeatedArithmeticShift: " + repeatedArithmeticShift(-93242, 40));
		System.out.println("repeatedLogicalShift: " + repeatedLogicalShift(-93242, 40));
	}

	private static int repeatedArithmeticShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>= 1; // Arithmetic shift by 1
		}
		return x;
	}

	private static int repeatedLogicalShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>>= 1; // Logical shift by 1
		}
		return x;
	}
}
