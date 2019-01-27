package craking.the.coding.interview.exercises.Examples_Exercises;

public class RotateMatrix {

	/**
	 * Input: 1 2 3 4 5 6 7 8 9
	 * 
	 * Output: 3 6 9 2 5 8 1 4 7
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9, 2 }, { 7, 8, 9, 1 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		int numberOfLayers = matrix.length / 2; // Always be
		for (int layer = 0; layer < numberOfLayers; layer++) {
			int first = layer;
			int last = numberOfLayers - first - 1;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// Save top
				int top = matrix[first][i];

				// left to top
				matrix[first][i] = matrix[last - offset][first];

				// bottom to left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right to bottom
				matrix[last][last - offset] = matrix[i][last];

				// Move bottom to left
				matrix[i][last] = top;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
