package com.zabee.dsalgo.trees;

public class Min {
	public static void main(String[] args) {
		int[] num = { 10, 20, 30, 40, 50, 5, 7 };
		System.out.println("The smaller number is : " + findMin(num));
	}

	private static int findMin(int[] a) {
		return binSearchMin(a, a.length, 0, a.length-1, Integer.MAX_VALUE);
	}

	private static int binSearchMin(int[] a, int size, int l, int h, int min) {
		if (l > h) {
			return a[0];
		}
		if (l == h) {
			return a[l];
		}

		int mid = l + (h - l) / 2;
		if ((mid < h) && a[mid] > a[mid + 1]) {
			return a[mid + 1];
		}
		if (mid > l && a[mid] < a[mid - 1]) {
			return a[mid];
		}
		if (a[h] > a[mid]) {
			return binSearchMin(a, size, l, mid - 1, min);
		}
		return binSearchMin(a, size, mid, h, min);
	}
}