package com.zabee.dsalgo.bits;

public class IncludingMbitsNBits {

	public static void main(String[] args) {
		System.out.println(includeMbitsInNbits(2048, 16, 2, 6));
	}

	private static int includeMbitsInNbits(int n, int m, int i, int j) {
		int result = 0;
		int allOnes = ~0;
		
		int left = allOnes << (j + 1);
		int right = ((1 << i) - 1);
		
		int mask = left | right;
		int n_cleared = n & mask;
		int m_shifted = m << i;
		result = n_cleared | m_shifted;
		return result;
	}
}
