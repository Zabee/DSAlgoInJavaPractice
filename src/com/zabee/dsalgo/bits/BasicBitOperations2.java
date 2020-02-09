package com.zabee.dsalgo.bits;

public class BasicBitOperations2 {

	public static void main(String[] args) {
		int num = 5;
		System.out.println("setIthBit\tExpected output is 13:\t" + setIthBit(num, 3));
		System.out.println("getIthBit\tExpected output is  0:\t" + getIthBit(num, 0));
		System.out.println("updateIthBit\tExpected output is 13:\t" + updateIthBit(num, 3, true));
		System.out.println("updateIthBit\tExpected output is 1:\t" + updateIthBit(num, 2, false));
		System.out.println("clearIthBit\tExpected output is  4:\t" + clearIthBit(num, 0));
		System.out.println("clearBitsMSBThroughI\tExpected output is 3:" + clearBitsMSBThroughI(15, 2));
		System.out.println("clearBitsMSBThrough0\tExpected output is :" + clearBitsMSBThrough0(15, 3));
	}

	private static int setIthBit(int num, int i) {
		int mask = 1 << i;
		num = num | mask;
		return num;
	}

	private static boolean getIthBit(int num, int i) {
		int mask = 1 << i;
		num = num & mask;
		return num > 0;
	}

	private static int updateIthBit(int num, int i, boolean isBit1) {
		int result = 0;
		int value = isBit1 ? 1 : 0;
		if (isBit1) {
			result = num | (value << i);
		} else {
			int mask = 1 << i;
			mask = ~mask;
			result = num & mask;
		}
		return result;
	}

	private static int clearIthBit(int num, int i) {
		int mask = 1 << i;
		mask = ~mask;
		num = num & mask;
		return num;
	}

	private static int clearBitsMSBThroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}

	private static int clearBitsMSBThrough0(int num, int i) {
		int mask = (1 << (i + 1));
		return num & mask;
	}
}
