package com.zabee.dsalgo.arrays;

import java.util.Arrays;

public class AlternatePositiveAndNegativeNumbers {

	public static void main(String[] args) {
		int a[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int n = a.length;
		System.out.println("Array before rearranging: ");
		System.out.println(Arrays.toString(a));
		rearrange(a, n);
		System.out.println("Array after rearranging: ");
		System.out.println(Arrays.toString(a));
	}

	private static void rearrange(int[] a, int n) {
		int j = 0, t = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] < 0) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
				j++;
			}
		}
		int neg = j - 1, pos = j;
		for (int i = 0, k = pos; i <= n; i++) {
			if (i % 2 == 0 && a[i] < 0) {
				int temp = a[i];
				a[i] = a[k];
				a[k] = temp;
				k++;
			}
		}
//		System.out.println("Partitioned arry : " + (Arrays.toString(a)));

	}

}
