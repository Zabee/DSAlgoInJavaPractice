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

	public static void main(String[] args) {
		final int[][] matrix = { { 1, 2 }, { 0, 4 } };
		OptimizedZeroMatrix.setZeros(matrix);
	}

	private static class OptimizedZeroMatrix {
		// I have no idea what's going on here. Okay, let demo inner classes at least :D
		private static void setZeros(int[][] matrix) {
			boolean rowHasZero = false;
			boolean colHasZero = false;

			// Check if first row has zero anywhere
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0) {
					rowHasZero = true;
					break;
				}
			}
			// Check if first column has zero anywhere
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][0] == 0) {
					colHasZero = true;
					break;
				}
			}

			// Check if anywhere in the array has zero
			for (int i = 1; i < matrix.length; i++) {
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			}

			// Nullify rows based on value in first column
			for (int i = 1; i < matrix.length; i++) {
				if (matrix[i][0] == 0) {
					nullifyRow(matrix, i);
				}
			}

			// Nullify cols based on value in first row
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0) {
					nullifyColumn(matrix, j);
				}
			}

			// Nullify first row
			if (rowHasZero) {
				nullifyRow(matrix, 0);
			}

			// Nullify first column
			if (colHasZero) {
				nullifyRow(matrix, 0);
			}

		}

		private static void nullifyColumn(int[][] matrix, int argJ) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][argJ] = 0;
			}

		}

		private static void nullifyRow(int[][] matrix, int argI) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[argI][j] = 0;
			}
		}
	}
}
