package com.zabee.just.java.practice;

public class StringPalindromTest {

	public static void main(String[] args) {
		String string = "madam";
		if (checkPalindrom(string.toCharArray()))
			System.out.println("Given string is palindrom");
		else
			System.out.println("Given string is not palindrom");
		System.gc();
	}

	private static boolean checkPalindrom(char[] string) {
		for (int i = 0, j = string.length - 1; i < string.length && j >= 0; i++, j--) {
			if(string[i] != string[j])
				return false;
		}
		return true;
	}

}
