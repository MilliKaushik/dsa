package array;

import java.util.List;

//Goldman test
public class SpecialElementsInMatrix {

	int countSpecialElements(List<List<Integer>> matrix) {
		int m = matrix.size();
		int n = matrix.get(0).size();
		int[] rowMax = new int[m];
		int[] rowMin = new int[m];
		int[] colMax = new int[n];
		int[] colMin = new int[n];

		for (int i = 0; i < m; i++) {
			int rMax = Integer.MIN_VALUE;
			int rMin = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				rMax = Math.max(matrix.get(i).get(j), rMax);
				rMin = Math.min(matrix.get(i).get(j), rMin);
			}
			rowMax[i] = rMax;
			rowMin[i] = rMin;
		}

		for (int j = 0; j < n; j++) {
			int cMax = Integer.MIN_VALUE;
			int cMin = Integer.MAX_VALUE;
			for (int i = 0; i < m; i++) {
				cMax = Math.max(matrix.get(i).get(j), cMax);
				cMin = Math.min(matrix.get(i).get(j), cMin);
			}
			colMax[j] = cMax;
			colMin[j] = cMin;
		}

		// Check for optimal element
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((matrix.get(i).get(j) == rowMax[i]) || (matrix.get(i).get(j) == rowMin[i])
						|| (matrix.get(i).get(j) == colMax[j]) || (matrix.get(i).get(j) == colMin[j])) {
					count++;
				}
			}
		}
		return count;
	}
}
