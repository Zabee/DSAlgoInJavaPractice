package craking.the.coding.interview.exercises.Examples_Exercises;

import java.util.HashSet;
import java.util.Set;

public class StringWithUniqueChars {

	private char[] string;

	public static void main(String[] args) {
		int x = ' ' - 0;
		System.out.println(x);
	}

	/*
	 * O(n)
	 */
	public boolean isUniqueWithBitVector(String str) {
		boolean isUnique = true;
		int finalBitVector = 0;
		int bitVectorForAChar = 0;
		for (int i = 0; i < str.length(); i++) {
			// To make sure it is between 0 to 26 i.e. 'a' to 'z'
			int indexValue = str.charAt(i) - 'a';
			// ASCII value of a space is 32 so it 32 - 97 ends in a negative number so let's
			// assign some customized value beyond a to z i.e. 27
			if (indexValue < 0) {
				indexValue = 27;
			}
			bitVectorForAChar = 1 << indexValue;

			if ((finalBitVector & bitVectorForAChar) > 0) {
				return false;
			}
			finalBitVector = finalBitVector | bitVectorForAChar;
		}
		return isUnique;
	}
	/**
	 * O(n)
	 * @param str
	 * @return
	 */
	public boolean isUniqueWithBooleanArray(String str) {
		if (str.length() > 126) {
			// We are only working with ASCII - this is the assumption. So, reject anything
			// larger than 2^8
			return false;
		}
		boolean[] characters = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			if (characters[str.charAt(i)] == true) {
				return false;
			}
			characters[str.charAt(i)] = true;
		}
		return true;
	}

	/**
	 * O(n^2)
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUniqueWithoutAnyDS(String str) {
		boolean isUnique = true;
		char[] characters = str.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			for (int j = i + 1; j < characters.length; j++) {
				if (characters[i] == characters[j]) {
					isUnique = false;
					return isUnique;
				}

			}
		}
		return isUnique;
	}

	/**
	 * O(n)
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUniqueWithSetDS(String str) {
		string = str.toCharArray();
		boolean isUnique = true;
		Set<Character> hashSet = new HashSet<>();
		for (Character ch : string) {
			if (hashSet.contains(ch)) {
				isUnique = false;
				break;
			} else {
				hashSet.add(ch);
			}
		}
		return isUnique;
	}

	/**
	 * O(n)
	 * 
	 * @param str
	 * @param skipSpace
	 * @return
	 */
	public boolean isUniqueWithSetDS(String str, boolean skipSpace) {
		string = str.toCharArray();
		boolean isUnique = true;
		Set<Character> hashSet = new HashSet<>();
		for (Character ch : string) {
			if (ch == ' ')// Skip space
				continue;
			if (hashSet.contains(ch)) {
				isUnique = false;
				break;
			} else {
				hashSet.add(ch);
			}
		}
		return isUnique;
	}
}
