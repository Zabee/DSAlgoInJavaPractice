package craking.the.coding.interview.exercises.Examples_Exercises;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Cracking the Coding Interview - Sixth edition
 * 
 * @author Zabee
 *
 */

public class BigOExample1to16 {

	public static void main(String[] args) {
//		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
//		int[] arrayA = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
//		int[] arrayB = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] stringArray = { "this", "is", "what", "we", "are", "sorting", "now", "characterbycharacter" };
//		foo(array);
//		sumOfnNumbers(4);
//		printPairs(array);
//		printUnorderedPairs(array);
//		printUnorderedPairs(arrayA, arrayB);
//		reverse(array);
//		sortStringArrayAndItsStrings(stringArray);
//		isPrime(7);
//		System.out.println("Factorial of 3 is : " + factorial(4));
//		permutation("abc");
//		System.out.println("Fib of 6 is " + fibonocci(6));
//		fibAll(6);
//		allCachedFib(10);
		powersOf2(16);
	}

	/**
	 * Example 16
	 * For e.g. if n=16 then it should print 2, 4, 8, 16
	 * Log 16 = 4 (assuming log base is 2)
	 * Assuming n always be n % 2 == 0 for iterative method (for loop) runtime is O(n)
	 * 
	 * 
	 *  
	 * @param n
	 */
	private static int powersOf2(int n) {
//		for(int i=2; i<=n; System.out.println(i),i=i*2);
		if (n < 1)
			return 1;
		else if (n == 1) {
			System.out.println(1);
			return 1;
		} else {
			int seqNum = powersOf2(n / 2);
			int powerOf2Serires = seqNum * 2;
			System.out.println(powerOf2Serires);
			return powerOf2Serires;
		}
	}
	
	/**
	 * 
	 * @param n
	 */
	private static void allCachedFib(int n) {
		int cachedMem[] = new int [n];
		for(int i=0; i<n; i++) {
			System.out.println("Fib of " + i + " is: " + fibonocci(i, cachedMem));
		}
	}
	
	private static int fibonocci(int n, int []cachedMem) {
		//(1) Iterative
//		if(n<=1)
//			return n;
//		else if(cachedMem[n] > 0) {
//			System.out.println("Returned from CACHE");
//			return cachedMem[n];
//		}
//		int prev=0, current=1, series=0;
//		for(int i=1; i<n; i++) {
//			series = prev + current;
//			prev = current;
//			current = series;
//		}
//		cachedMem[n] = series;
//		return series;
		
		//(2) Recursive
		if(n <= 1)
			return n;
		else if (cachedMem[n] > 0) {
			System.out.println("Returned from CACHE " + cachedMem[n]);
			return cachedMem[n];
		}
		else
			cachedMem[n] = fibonocci(n-1, cachedMem) + fibonocci(n-2, cachedMem);
		return cachedMem[n];
	}
	/**
	 * Example 14
	 * O(2^n)
	 * 
	 * The runtime would have been O(n * 2^n) if the call would have been as below,
	 * System.out.println("Fib of " + i + " is :" + fibonocci(n));
	 * @param n
	 */
	private static void fibAll(int n) {
		for (int i = 0; i <= n; i++) {
			System.out.println("Fib of " + i + " is :" + fibonocci(i));
		}
	}

	/**
	 * Example 13 O(2^n) O(branches^depth) of call tree 0, 1, 1, 2, 3,
	 */
	private static int fibonocci(int n) {
//		if(n<=1)
//			return n;
//		
//		int current = 0, next = 1, series = 0;
//
//		for (int i = 1; i <n; i++) {
//			series = current + next;
//			current = next;
//			next = series;
//		}
//		return series;

		if (n <= 1)
			return n;
		else
			return fibonocci(n - 1) + fibonocci(n - 2);
	}

	/**
	 * Example 12
	 * O (n^2 * 2!)
	 * @param str
	 */
	private static void permutation(String str) {
		permutation(str, "");
	}

	private static void permutation(String str, String prefix) {
		if (str.length() == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				permutation(rem, prefix + str.charAt(i));
			}
		}
	}

	/**
	 * O(n)
	 * 
	 * @param n
	 * @return
	 */

	private static int factorial(int n) {
		int factorial = 1;
		if (n == 1)
			return factorial;
		else {
			return n * factorial(n - 1);
		}
//		int fact =1;
//		for(int i=1; i<=n; i++) {
//			fact = fact * i;
//		}
//		return fact;
	}

	/**
	 * Example 10 O (\/n) (Big O of Square Root of 'n')
	 * 
	 * @param n
	 */
	private static void isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println("Given number " + n + " is not a prime");
				return;
			}
		}
		System.out.println("Given number " + n + " is prime");
	}

	/**
	 * Example 9 is adding all the nodes in a balanced binary search tree So, as we
	 * are visiting all the nodes once and doing a constant operation the run time
	 * will be O(n)
	 */
	/**
	 * Example 8
	 * 
	 * @param argStringArray
	 */
	private static void sortStringArrayAndItsStrings(String[] argStringArray) {
		for (int i = 0; i < argStringArray.length; i++) {
			char[] charArrayofStr = argStringArray[i].toCharArray();
			for (int j = 0; j < charArrayofStr.length; j++) {
				// Let's sort character by character
				// Assume it is using merge sort that is gonna be log n for let's take as s log
				// s for the length of the string so,
				// a*s log s
			}
			// Suppose I wrote an algorithm that takes the entire list and sort every string
			// and take character by character
			// consideration then it would be again a*s log s
		}

		for (int i = 0; i < argStringArray.length; i++) {
			char[] charArrayofStr = argStringArray[i].toCharArray();
			for (int j = 0; j < charArrayofStr.length; j++) {
				// Suppose I wrote an algorithm that takes the entire list and sort every string
				// and take character by character
				// consideration then it would be again a*s log s
				// Let's sort character by character
				// Assume it is using merge sort that is gonna be log n for let's take as s log
				// s for the length of the string so,
				// a*s log s
			}
			//
		}

		for (String str : argStringArray) {
			System.out.println(str);
		}

		// The runtime will be a*s log s + a*s log a ==> a*s (log a + log s)
	}

	/**
	 * Example 7 is just a theoretical part
	 * 
	 */

	/**
	 * Example 6 Upper bound worst case is O(n/2) --> O(n*(1/2)) --> Drop the
	 * constant ==> O(n)
	 * 
	 * @param array
	 */
	private static void reverse(int[] array) {
		int temp;
		for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		System.out.println("Reversed array is: ");
		for (int element : array)
			System.out.print(element + ",");
	}

	/**
	 * Upper limit worst cast runtime is O(n) + O(n) => O(2n) i.e. drop the
	 * constants finally O(n)
	 * 
	 * @param array
	 */
	private static void foo(int[] array) {
		int sum = 0;
		long multiplied = 1;
		for (int arrayElement : array) {
			sum = sum + arrayElement;
		}

		for (int arrayElement : array) {
			multiplied = multiplied * arrayElement;
		}

		System.out.println("Sum of given array " + sum);
		System.out.println("Multiplication of given array " + multiplied);
	}

	/**
	 * n*(n+1)/2
	 * 
	 * @param n This is my own method not in the e-book Upper limit worst case
	 *          runtime is O(1)
	 */
	private static void sumOfnNumbers(int n) {
		int sum = n * (n + 1) / 2;
		System.out.println("Sum of given array " + sum);
	}

	/**
	 * Upper bound worst case runtime is O(n^2)
	 * 
	 * @param array
	 */
	private static void printPairs(int[] array) {
		for (int i = 0; i < Array.getLength(array); i++) {
			for (int j = 0; j < Array.getLength(array); j++) {
				System.out.println(array[i] + "," + array[j]);
			}
		}
	}

	/**
	 * Upper bound worst case runtime is, O(n) * (n-1+n-2+n-3+.... +3+2+1)-->
	 * n(n+1)/2 -->O(n) => O(n^2)
	 * 
	 * @param array
	 */

	private static void printUnorderedPairs(int[] array) {
		for (int i = 0; i < Array.getLength(array); i++) {
			for (int j = i + 1; j < Array.getLength(array); j++) {
				System.out.println(array[i] + "," + array[j]);
			}
		}
	}

	/**
	 * Upper bound worst case runtime is O(n*m) Even if the commented innermost for
	 * loop in action it will be O(n*m) as just drop the constant O(n*m*10000)
	 * 
	 * O(n*m)
	 * 
	 * @param arrayA
	 * @param arrayB
	 */
	private static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
		int i, j, k;
		for (i = 0; i < arrayA.length; i++) {
			for (j = 0; j < arrayB.length; j++) {
//				for(k=0; k<10000; k++) 
				System.out.println(arrayA[i] + "," + arrayB[j]);
			}
		}
	}
}
