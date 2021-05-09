package array;

public class RotateImage {

	public void rotate(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		rotateHelper(matrix, m, n);
	}

	private void rotateHelper(int[][] matrix, int m, int n) {
		if (m <= 0 && n <= 0)
			return;
		// putting corner elements in correct place
		swapElement(matrix, 0, 0, 0, m - 1);
		swapElement(matrix, 0, n - 1, m - 1, n - 1);
		swapElement(matrix, 0, n - 1, m - 1, 0);

		swapLine(matrix, m - 1, n - 2, m - 2, 0);
		swapLine(matrix, 0, n - 2, m - 2, 0);
		rotateHelper(matrix, m - 1, n - 1);
	}

	private void swapLine(int[][] matrix, int i, int toDecrementRow, int toDecrementCol, int l) {
		int m = toDecrementRow;
		int n = toDecrementCol;
		while (m > 0 && n > 0) {
			int temp = matrix[i][m];
			matrix[i][m] = matrix[n][l];
			matrix[n][l] = temp;
			m--;
			n--;
		}
	}

	private void swapElement(int[][] matrix, int i, int j, int k, int l) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[k][l];
		matrix[k][l] = temp;
	}
}