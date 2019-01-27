package com.zabee.dsalgo.myexperiments;

public class MatrixOperations {

	private static final int matrix1[][] = { { 1, 2, 3 }, { 4, 5, 6}, {7, 8, 9} };
	private static final int matrix2[][] = { { 1, 2 }, { 3, 4 } };
	private static final int matrix1Len = matrix1.length;
	private static final int matrix2Len = matrix2.length;
	private static int result[][] = new int[3][2];

	public static void main(String[] args) {
		System.out.println("Sum of two matrices");
		matrixAddition();

		System.out.println("Mutiplication of two matrices");
		matrixMultiplicaiton();

		System.out.println("Tranpose of first matrix");
		transposeMatrix();
		
		System.out.println("Inverse of second matrices");
	}

	private static void printMatrix(int[][] argMatrix) {
		for (int i = 0; i < argMatrix.length; i++) {
			for (int j = 0; j < argMatrix[0].length; j++) {
				System.out.print(argMatrix[i][j]);
			}
			System.out.println();
		}
	}

	private static void matrixAddition() {
		if (matrix1Len != matrix2[0].length) {
			System.out.println("Matrices are not addition compatible");
			return;
		}
		for (int i = 0; i < matrix1Len; i++) {
			for (int j = 0; j < 2; j++) {
				result[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		printMatrix(result);
	}

	private static void matrixMultiplicaiton() {
		// Check for multiplication compatibility
		if (matrix1Len != matrix2Len) {
			System.out.println("Matrices are not mutliplication compatible");
			return;
		}
		for (int i = 0; i < matrix1Len; i++) {
			int sum = 0;
			for (int j = 0; j < 2; j++) {
				sum = 0;
				for (int k = 0; k < matrix2Len; k++) {
					sum = sum + matrix1[i][k] * matrix2[k][j];
				}
				System.out.println(sum);
			}
		}

	}

	private static void transposeMatrix() {
		if(matrix1Len != matrix1[0].length) {
			System.out.println("Matrices are not transpose compatible");
			return;
		}
		int temp=0;
 		for (int i = 0; i <= matrix1Len/2; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				if(i==j) 
					continue;
				temp = matrix1[i][j];
				matrix1[i][j] = matrix1[j][i];
				matrix1[j][i] = temp;
			}
		}
		printMatrix(matrix1);
	}
}
