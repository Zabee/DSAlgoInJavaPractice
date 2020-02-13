class PushZero {

	static void moveZerosToEnd(int arr[], int n) {
		// Count of non-zero elements
		int j = 0;
		int temp;

		// Traverse the array. If arr[i] is
		// non-zero, then swap the element at
		// index 'count' with the element at
		// index 'i'
		for (int i = 0; i < n; i++) {
			if ((arr[i] != 0)) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j = j + 1;
			}
		}
	}

	// function to print the array elements
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver program to test above
	public static void main(String args[]) {
		int arr[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
		int n = arr.length;

		System.out.print("Original array: ");
		printArray(arr, n);

		moveZerosToEnd(arr, n);

		System.out.print("\nModified array: ");
		printArray(arr, n);
	}
}