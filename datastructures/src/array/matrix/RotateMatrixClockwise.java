package array.matrix;

//https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/202/
//https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
public class RotateMatrixClockwise {

	// An N x N matrix will have floor(N/2) square cycles. For example, a 3 X 3
	// matrix will have 1 cycle. The cycle is formed by its 1st row, last column,
	// last row, and 1st column. For each square cycle, we swap the elements
	// involved with the corresponding cell in the matrix in the clockwise
	// direction. We just need a temporary variable for this.
	public void rotate(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = a[i][j];
				// so just choose the indices based on whether you want your row-index to be
				// fixed or not and whether you want your column index to be fixed or not in
				// this iteration
				// if you want your row index to be fixed, then choose i as the variable(i or n
				// - 1 i)
				// similarly, if you want your column index to be fixed, then choose i as the
				// variable(i or n - 1 i)
				// if you want your row index to be varying/moving, then choose j as the
				// variable(j or n
				// - 1 - j)
				// similarly, if you want your column index to be varying/moving, then choose j
				// as the
				// variable(j or n - 1 - j)
				// at each of the below steps, write down - row fixed, col moving, or row moving
				// col fixed
				// and then use i if the row/col is fixed - use wither i or n - 1 -i
				// or use j if row/col is moving - either j or n - 1 - j
				a[i][j] = a[n - 1 - j][i];
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = temp;
			}
		}
	}
}
