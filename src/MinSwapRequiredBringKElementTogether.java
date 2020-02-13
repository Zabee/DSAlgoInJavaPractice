
/**
 * Input: arr[] = {2, 1, 5, 6, 3}, k = 3 Output: 1
 * 
 * Explanation: To bring elements 2, 1, 3 together, swap element '5' with '3'
 * such that final array will be- arr[] = {2, 1, 3, 6, 5}
 * 
 * Input: arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5 Output: 2
 * 
 * @author Zabee
 *
 */
public class MinSwapRequiredBringKElementTogether {

	public static void main(String[] args) {
//		int[] a = { 2, 1, 3, 6, 7 };
//		int k = 3;
		int[] a = { 2, 7, 9, 5, 8, 7, 4 };
		int k = 5;
		int minSwapsRequired = findMinSwapsRequired(a, k);
		System.out.println("Minimum swap/s needed is/are : " + minSwapsRequired);
	}

	private static int findMinSwapsRequired(int[] a, int k) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int minSwapsRequired = 0;
		int n = a.length;

		int minValues = 0;
		// Find out how many values are less than or equal to the given k
		for (int i = 0; i < n; i++) {
			if (a[i] <= k) {
				minValues++;
			}
		}
		// Calculated value will constitute the window size as all those elements
		// together is the actually length after swap that we need
		int windowSize = minValues;

		// Sliding window initialization. Calculate how many swaps needed in first
		// window
		for (int i = 0; i < windowSize; i++) {
			if (a[i] > k) {
				minSwapsRequired++;
			}
		}

		// Have a running swap for remaining windows.
		int runningSwapsRequired = minSwapsRequired;
		// For every remaining windows
		for (int i = 0, j = windowSize; j < n; i++, j++) {
			// If outgoing or leaving from current window element is greater than k then
			// good news, decrement running swap as for the current window we don't want to
			// count outgoing, of course!!
			// Outgoing from current window. For e.g. a[0] is already calculated in the
			// above loop. So, this idea gets carried over here
			if (a[i] > k) {
				runningSwapsRequired--;
			}
			// If incoming element to the current window is greater than k then bad news,
			// increment running swap as
			// for the current window we want to count incoming
			if (a[j] > k) {
				runningSwapsRequired++;
			}
			// Find smaller among the previous window and current window
			minSwapsRequired = Math.min(runningSwapsRequired, minSwapsRequired);
		}

		return minSwapsRequired;
	}

}
