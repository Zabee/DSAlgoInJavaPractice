package com.zabee.dsalgo.myexperiments.specificalgos;

public class StringCompression {

	/**
	 * Upper bound worst case runtime is O(n) neglecting converting integer to
	 * character actually we cannot but let's neglect it as it is not part of actual
	 * logic
	 * 
	 * @param argChars
	 * @return
	 */
	public char[] compressString(char[] argChars) {
		char[] newChars = new char[argChars.length * 2];
		boolean areAllUnique = true;
		int count = 0;
		for (int i = 0, k = 0; i < argChars.length; i++) {
			count++;
			if (i + 1 >= argChars.length || argChars[i] != argChars[i + 1]) {
				newChars[k++] = argChars[i];
				String tempStr = Integer.toString(count);
				if (areAllUnique) {
					areAllUnique = count > 1 ? false : true;
				}
				for (int l = 0; l < tempStr.length(); l++)
					newChars[k++] = tempStr.charAt(l);
				count = 0;
			}
		}
		return areAllUnique ? argChars : newChars;
	}

	/**
	 * O(n)
	 * 
	 * @param argChars
	 * @return
	 */
	public char[] compressStringSolution1(char[] argChars) {
		char[] compressedChars = new char[argChars.length * 2], intChars = null;
		int count = 0, compIndex = 0;
		boolean isStringUnique = true;
		for (int i = 0; i < argChars.length; i++) {
			count++;
			if (i + 1 >= argChars.length || argChars[i] != argChars[i + 1]) {
				compressedChars[compIndex++] = argChars[i];
				intChars = String.valueOf(count).toCharArray();
				if (count > 1 && isStringUnique) {
					isStringUnique = false;
				}
				for (int x = 0; x < intChars.length; x++) {
					compressedChars[compIndex++] = intChars[x];
				}
				count = 0;
			}
		}
		return isStringUnique ? argChars : compressedChars;
	}

	public static void main(String[] args) {
		System.out.println(compress("zabeeulla"));
		System.out.println(compressUsingStrBuilder("zabeeulla"));
		System.out.println(compressUsingLazyInitOfStrBuilder("zabeeulla"));
	}

	/**
	 * Runtime is O(n+k^2) where n is the length of character array and k^2 is the
	 * number of character sequence
	 * 
	 * @param str
	 * @return
	 */
	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;

			/* If next character is different than current, append this char to result. */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}

	public static String compressUsingStrBuilder(String argStr) {
		StringBuilder strBuilder = new StringBuilder();
		int charCount = 0;
		boolean isStrWithUnique = true;
		for (int i = 0; i < argStr.length(); i++) {
			charCount++;
			if (i + 1 >= argStr.length() || argStr.charAt(i) != argStr.charAt(i + 1)) {
				strBuilder.append(argStr.charAt(i));
				strBuilder.append(charCount);
				if (charCount > 1 && isStrWithUnique) {
					isStrWithUnique = false;
				}
				charCount = 0;
			}
		}

		return isStrWithUnique ? argStr : strBuilder.toString();
	}

	public static String compressUsingLazyInitOfStrBuilder(String argStr) {
		int charCount = 0;
		boolean isStrWithUnique = true;

		StringBuilder strBuilder = new StringBuilder(countUnique(argStr));
		for (int i = 0; i < argStr.length(); i++) {
			charCount++;
			if (i + 1 >= argStr.length() || argStr.charAt(i) != argStr.charAt(i + 1)) {
				strBuilder.append(argStr.charAt(i));
				strBuilder.append(charCount);
				if (charCount > 1 && isStrWithUnique) {
					isStrWithUnique = false;
				}
				charCount = 0;
			}
		}
		return isStrWithUnique ? argStr : strBuilder.toString();
	}

	private static int countUnique(String argStr) {
		int compressLength = 0, count = 0;
		for (int i = 0; i < argStr.length(); i++) {
			count++;
			if (i + 1 >= argStr.length() || argStr.charAt(i) != argStr.charAt(i + 1)) {
				compressLength += String.valueOf(count).length() + 1;
				count = 0;
			}
		}
		return compressLength;
	}
}
