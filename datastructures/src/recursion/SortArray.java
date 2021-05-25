package recursion;

//https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6
//https://leetcode.com/problems/sort-an-array/ - TLE in one case
public class SortArray {

	public int[] sort(int[] arr) {
		return sortHelper(arr, arr.length);
	}

	private int[] sortHelper(int[] arr, int n) {
		if (n == 1)
			return arr;
		sortHelper(arr, n - 1);
		insert(arr, n - 1, n - 1);
		return arr;
	}

	private void insert(int[] arr, int size, int elementIndex) {
		if(size <= 0)
			return;
		if (size == 1) {
			if (arr[size - 1] <= arr[elementIndex])
				return;
			else
				swap(arr, size - 1, elementIndex);
		}
		insert(arr, size - 1, elementIndex);
		if (arr[size - 1] >= arr[elementIndex])
			swap(arr, size - 1, elementIndex);
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
