package com.zabee.dsalgo.myexperiments;

public class MyExperiments {

	public static void main(String[] args) {
//		printPowerOfSome(2, 11);
		
		String [] words = {"This", "That", "What", "When", "Here"};
		String sentence = joinWords(words);
		System.out.println(sentence);
		
		char [][] charWords = {{'T','h','i','s'},{'T','h','i','s'},{'T','h','i','s'},{'T','h','i','s'}};
		sentence = joinWords(charWords);
		System.out.println(sentence);
	}

	/**
	 * O(n)
	 * @param base
	 * @param power
	 */
	private static void printPowerOfSome(int base, int power) {
		long result = 1;
		for (int i = 1; i <= power; i++) {
			result = result * base;
		}
		System.out.println("Power of base " + base + " power " + power + " is : " + result);
	}
	
	/**
	 * O(n)
	 * @param argWords
	 * @return
	 */
	private static String joinWords(String []argWords) {
		String sentence = "";
		for(String word : argWords) {
			sentence = sentence + word; 
		}
		return sentence;
	}
	
	private static String joinWords(char [][]argWords) {
		char[] sentence = new char[1024];
		for(int i=0, k=0; i<argWords.length; i++) {
			char[] word = argWords[i];
			for(int j=0; j<word.length; j++, k++) {
				sentence[k] = word[j]; 
			}
		}
		return String.valueOf(sentence);
	}
}
