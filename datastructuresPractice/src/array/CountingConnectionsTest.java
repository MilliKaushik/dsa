package array;

import java.util.List;

//Goldman test
public class CountingConnectionsTest {

	int countConnections(List<List<Integer>> matrix) {
		int count = 0;
		int m = matrix.size();
		int n = matrix.get(0).size();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix.get(i).get(j) == 1)
					if (i - 1 >= 0 && j - 1 >= 0 && matrix.get(i - 1).get(j - 1) == 1) {
						count = count + 1;

					}
				if (i - 1 >= 0 && matrix.get(i - 1).get(j) == 1) {
					count = count + 1;
				}
				if (i - 1 >= 0 && j + 1 < n && matrix.get(i - 1).get(j + 1) == 1) {
					count = count + 1;
				}
				if (j + 1 < n && matrix.get(i).get(j + 1) == 1) {
					count = count + 1;

				}
			}
		}
		return count;
	}
}
