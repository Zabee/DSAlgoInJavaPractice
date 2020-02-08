package com.zabee.just.java.practice;

public class StringPalindromTest {
	private static class Cat {
		String name = "Xing";
		int legs = 4;
		int[] ints = { 1, 2, 3, 4 };
	}

	public static void main(String[] args) {
		changeMe(new Cat());
		String name = "Zabee";
		name += "Ulla";
		name = name.replace('Z', 'X');
		System.out.println(name);
//		System.exit(0);

		String string = "madam";
		if (checkPalindrom(string.toCharArray()))
			System.out.println("Given string is palindrom");
		else
			System.out.println("Given string is not palindrom");
		System.gc();
	}

	private static boolean checkPalindrom(char[] string) {
		for (int i = 0, j = string.length - 1; i < string.length && j >= 0; i++, j--) {
			if (string[i] != string[j])
				return false;
		}
		return true;
	}

	private static void changeMe(Cat cat) {
		int[] ints = cat.ints;
		ints[0] = 99;
		java.util.stream.Stream.iterate(0, i -> ++i)//
				.limit(cat.ints.length)//
				.forEach(i -> System.out.println(cat.ints[i]));
	}
}
