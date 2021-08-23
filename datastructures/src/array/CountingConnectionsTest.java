package array;

import java.util.List;

//Counting distinct connections in matrix (medium kinda easy)

//Return all distinct connections in a matrix between cells.
//connection can be diagonally, horizontally, vertically. (basically in all 8 directions)
//
//1 -> connection exist between row and column
//0 -> no connection exist between associated row and column
//
//Ex:
//1 0 0 1
//0 1 1 1
//1 0 0 1
//
//output: 8
//
//explanation:
//8 distinct connections below
//(0, 0) -> (1, 1)
//(1,1) -> (1, 2)
//(1,2) -> (1, 3)
//(1,2) -> (0, 3)
//(1,2) -> (2, 3)
//(1,3) -> (0, 3)
//(1,3) -> (2, 3)
//(2, 0) -> (1, 1)
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
