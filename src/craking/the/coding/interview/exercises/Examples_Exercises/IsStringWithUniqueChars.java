package craking.the.coding.interview.exercises.Examples_Exercises;

import java.util.HashSet;
import java.util.Set;

public class IsStringWithUniqueChars {

	private char[] string;

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
