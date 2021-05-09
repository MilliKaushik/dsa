package array.matrix;

//https://leetcode.com/explore/interview/card/top-interview-questions-hard/120/sorting-and-searching/858/
public class KthSmallestElementInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				k--;
				if (k == 0)
					return matrix[i][j];

			}
		}
		return 0;
	}
}
