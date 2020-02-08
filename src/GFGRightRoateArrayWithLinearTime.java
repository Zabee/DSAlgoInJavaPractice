class GFGRightRoateArrayWithLinearTime {

	private static void rightRoate(int[] arr, int s, int e) {
		while (s < e) {
			int t = arr[s];
			arr[s] = arr[e];
			arr[e] = t;
			s++;
			e--;
		}
	}

	private static void rotate(int[] arr, int r) {
		rightRoate(arr, 0, arr.length - 1);
		rightRoate(arr, 0, r - 1);
		rightRoate(arr, r, arr.length - 1);
	}
	


	private static void printArray(int[] arr) {
		for (int x : arr) {
			System.out.print("|" + x + "|");
		}
	}

	public static void main(String[] args) {
		int[] leftArray = { 1, 2, 3, 4, 5, 6 };
		int[] rightArray = { 1, 2, 3, 4, 5 };
		int rotate = 2;
		System.out.println("Original array : ");
		printArray(leftArray);
		System.out.println("\nLeft rotated by 2 times");
		rotate(leftArray, rotate);
		printArray(leftArray);
		System.out.println("\nRight rotated by 2 times ");
		printArray(rightArray);
	}
}
