class GFG {
	private static int findIndex(int ele, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (ele == arr[i] && ele != -1) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] != i) {
				int index = findIndex(i, arr);
				if (index != -1) {
					int t = arr[index];
					arr[index] = arr[i];
					arr[i] = t;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}