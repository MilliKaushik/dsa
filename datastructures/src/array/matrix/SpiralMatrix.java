package array.matrix;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/explore/interview/card/microsoft/30/array-and-strings/178/
//https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] a) {
		List<Integer> elements = new ArrayList<>();
		int i = 0, j = 0;
		int m = a.length, n = a[0].length;
		spiralHelper(a, i, j, m, n, elements);
		return elements;
	}

	private void spiralHelper(int[][] a, int i, int j, int m, int n, List<Integer> elements) {
		if (i >= m || j >= n)
			return;
		for (int k = j; k < n; k++)
			elements.add(a[i][k]);
		for (int k = i + 1; k < m; k++)
			elements.add(a[k][n - 1]);
		if (i != m - 1)
			for (int k = n - 2; k >= j; k--)
				elements.add(a[m - 1][k]);
		if (j != n - 1)
			for (int k = m - 2; k > i; k--)
				elements.add(a[k][j]);
		spiralHelper(a, i + 1, j + 1, m - 1, n - 1, elements);
	}
}
