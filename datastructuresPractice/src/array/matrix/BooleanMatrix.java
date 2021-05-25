package array.matrix;

//https://www.geeksforgeeks.org/a-boolean-matrix-question/
public class BooleanMatrix {

	public void booleanMatrix(int[][] matrix) {
		boolean rowFlag = false;
		boolean colFlag = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 && matrix[i][j] == 1)
					rowFlag = true;
				if (j == 0 && matrix[i][j] == 1)
					colFlag = true;
				if (matrix[i][j] == 1) {
					matrix[i][0] = 1;
					matrix[0][j] = 1;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++)
				if (matrix[i][0] == 1 || matrix[0][j] == 1)
					matrix[i][j] = 1;

		if (rowFlag)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 1;

		if (colFlag)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 1;
	}
}
