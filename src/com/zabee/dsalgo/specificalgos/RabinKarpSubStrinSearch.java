package com.zabee.dsalgo.specificalgos;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RabinKarpSubStrinSearch {

	private static char[] text, pattern;
	private static boolean found;
	private static int index = -1, patternLength, textLength, primeNumber = 3;
	private static double patternHash;
	private static Logger logger = LogManager.getLogger(RabinKarpSubStrinSearch.class);

	private RabinKarpSubStrinSearch(String argText, String argPattern) {
		text = argText.toCharArray();
		pattern = argPattern.toCharArray();
		patternLength = pattern.length;
		textLength = argText.length();
//		logger.info("Logger initialized..");
		logger.info(calculateHash(text, textLength));
		patternHash = calculateHash(pattern, patternLength);
	}

	/**
	 * Same string has same hash value but converse is not true Different string can
	 * have same hash and this depends on the efficiency of the hashing algorithm
	 * 
	 * @return
	 */
	private static boolean compare(char[] argText, int startIndex) {
		int textIndex = 0;
		for (int i = 0; i < patternLength; i++) {
			textIndex = startIndex + i;
			logger.info("i: " + i + "textIndex:" + textIndex);
			if (pattern[i] != argText[textIndex])

				return false;
		}
		return true;
	}

	private static double calculateHash(char[] argStr, int argPattLen) {
		double hashValue = 0;
		for (int i = 0; i < argPattLen; i++) {
			hashValue = hashValue + argStr[i] * Math.pow(primeNumber, i);
		}
		return hashValue;
	}

	private static double calculateHash(char[] argStr, int argPattLen, int argRemoveIndex, int argAddindex,
			double argOldHash) {
		double newHash = argOldHash - argStr[argRemoveIndex];
		newHash = newHash / primeNumber;
		newHash = newHash + (argStr[argAddindex] * Math.pow(primeNumber, patternLength - 1));
		return newHash;
	}

	/**
	 * Upper bound worst case time complexy is O(n+m) but in really worst case O(nm)
	 * 
	 * @return
	 */
	private static int search() {
		int index = -1;
		double txtRollingHash = 0;
		for (int i = 0; i < textLength - (patternLength - 1); i++) {
			if (i == 0) {
				txtRollingHash = calculateHash(text, patternLength);
			} else {
				// Remove previous char and add current char
				txtRollingHash = calculateHash(text, textLength, i - 1, i + (patternLength - 1), txtRollingHash);
			}
			logger.info("At index: " + i + "\t\tRolling Hash:" + txtRollingHash + "\t\tPattern Hash: " + patternHash);
			if (patternHash == txtRollingHash && compare(text, i)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a long string:");
		String text = scanner.nextLine();
		System.out.print("Enter a pattern to find:");
		String pattern = scanner.nextLine();
		RabinKarpSubStrinSearch robinKarp = new RabinKarpSubStrinSearch(text, pattern);
		int index = robinKarp.search();
		if (index == -1)
			System.out.println("Not a substring");
		else
			System.out.println("Substring found at starting index " + index);
	}
}