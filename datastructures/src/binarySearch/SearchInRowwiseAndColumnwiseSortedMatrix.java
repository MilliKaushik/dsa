package binarySearch;

//https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
//https://leetcode.com/problems/search-a-2d-matrix/submissions/
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/806/
public class SearchInRowwiseAndColumnwiseSortedMatrix {

	// pair can be returned too
	public int[] findInSortedMatrix(int[][] arr, int key) {
		// row
		int m = arr.length;
		// column
		int n = arr[0].length;

		int i = 0;
		int j = n - 1;

		int[] result = new int[2];
		while (i >= 0 && i < m && j >= 0 && j < n) {
			if (arr[i][j] == key) {
				result[0] = i;
				result[1] = j;
				return result;
			} else if (arr[i][j] > key)
				j--;
			else if (arr[i][j] < key)
				i++;
		}
		result[0] = -1;
		result[1] = -1;
		return result;
	}
}
