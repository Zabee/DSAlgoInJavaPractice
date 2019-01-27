package craking.the.coding.interview.exercises.Examples_Exercises;

public class URLify {

	/**
	 * O(n)
	 * 
	 * @param argStr
	 * @return
	 */
	public static String URLifyWithNewCharArray(String argStr) {
		char[] urlified = null, sourceChars = argStr.toCharArray();

		int spaceCount = 0;
		for (Character chara : sourceChars) {
			if (chara == ' ') {
				spaceCount++;
			}
		}
		urlified = new char[(argStr.length()) + spaceCount * 2];
		int i = 0;
		for (Character chara : sourceChars) {
			if (chara == ' ') {
				urlified[i++] = '%';
				urlified[i++] = '2';
				urlified[i++] = '0';
				continue;
			}
			urlified[i++] = chara;
		}
		return String.valueOf(urlified);
	}

	/**
	 * O(n)
	 * 
	 * @param argStr
	 * @param charsLength
	 * @return
	 */
	private static String replaceWithinSourceString(String argStr, int charsLength) {
		char[] sourceChars = argStr.toCharArray();
		int spaceCount = 0, totalLength = 0;
		// 1. Count spaces
		for (int i = 0; i < charsLength; i++) {
			if (sourceChars[i] == ' ') {
				spaceCount++;
			}
		}

		totalLength = charsLength + spaceCount * 2 - 1;
		for (int i = charsLength - 1; i >= 0; i--) {
			if (sourceChars[i] == ' ') {
				sourceChars[totalLength--] = '0';
				sourceChars[totalLength--] = '2';
				sourceChars[totalLength--] = '%';
				continue;
			}
			sourceChars[totalLength--] = sourceChars[i];
		}
		return new String(sourceChars);
	}

	public static void main(String... args) {
		System.out.println(URLifyWithNewCharArray("Mr John Smith"));
		System.out.println(replaceWithinSourceString("Mr John Smith    ", 13));
	}
	
}
