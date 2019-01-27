package craking.the.coding.interview.exercises.Examples_Exercises;

public class ZeroMatrix {
	private static int[][] matrix = null;
	private static boolean[] zeroRows;
	private static boolean[] zeroCols;

	public static int[][] driver(final int[][] argMatrix) {
		ZeroMatrix.matrix = argMatrix;
		zeroRows = new boolean[matrix.length];
		zeroCols = new boolean[matrix[0].length];
		printMatrix("Before setting zero");
		findZeros();
		for (int i = 0; i < zeroRows.length; i++) {
			if (zeroRows[i] == true) {
				setRowToZero(i);
//				System.out.println(i + " row is zero");
			}
		}
		for (int j = 0; j < zeroCols.length; j++) {
			if (zeroCols[j] == true) {
				setColumnToZero(j);
//			System.out.println(j + " column is zero");
			}
		}
		printMatrix("After setting zero");
		return matrix;
	}

	private static final void findZeros() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					zeroRows[i] = true;
					zeroCols[j] = true;
				}

			}
		}
	}

	private static final void setRowToZero(int row) {
		for (int i = row, j = 0; j < matrix[0].length; j++) {
			matrix[i][j] = 0;
		}
	}

	private static final void setColumnToZero(int col) {
		for (int i = 0, j = col; i < matrix.length; i++) {
			matrix[i][j] = 0;
		}
	}

	private static final void printMatrix(final String argMsg) {
		System.out.println(argMsg);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
