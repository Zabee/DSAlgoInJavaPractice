import java.util.Arrays;

class Program {

	public static void main(String[] args) {
		int[] a = {1, 2, 0, 4, 3, 0, 5, 0};
		int n = a.length;
		for (int i = 0, j = n - 1; i < j; i++) {
			if (a[i] == 0) {
				int t = a[i];
				if(a[j] == 0) {
					j--;
				}
				a[i] = a[j];
				a[j] = t;
				j--;

			}
		}
		System.out.println(Arrays.toString(a));
	}
}
