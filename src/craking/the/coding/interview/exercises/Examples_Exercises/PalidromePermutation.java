package craking.the.coding.interview.exercises.Examples_Exercises;

import java.nio.file.attribute.AclEntry.Builder;

public class PalidromePermutation {

	private static boolean isPermutationOfPalidrome(String argStr) {
		int[] charFreqTable = buildCharFrequencyTable(argStr);
		boolean foundOdd = false;
		for (int i = 0; i < charFreqTable.length; i++) {
			if (charFreqTable[i] % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	private static int[] buildCharFrequencyTable(String argStr) {
		// Getting space for 26 alpahabets
		int[] charFreqTable = new int['z' - 'a' + 1];
		for (int i = 0; i < argStr.length(); i++) {
			if (argStr.charAt(i) == ' ')
				continue;
			// Making sure index always falls between 0 to 25
			charFreqTable[argStr.charAt(i) - 'a']++;
		}
		return charFreqTable;
	}

	private static boolean isPermutationOfPalidromeUsingBitManipulation() {
		return false;
	}

	private static int createBitVector(String argStr) {
		return 0;
	}

	private static int toggle(int bitVector, int index) {
		int bitMask = 1 << index;
		if((bitVector & bitMask) != 0) {
			bitVector = bitVector & ~bitMask;
		}else {
			bitVector = bitVector | bitMask;
		}
			
		
		return bitVector;
	}

	public static void main(String[] args) {
		String str = "tact coa";
		System.out.println(isPermutationOfPalidrome(str) ? "Yes" : "No");
	}
}
