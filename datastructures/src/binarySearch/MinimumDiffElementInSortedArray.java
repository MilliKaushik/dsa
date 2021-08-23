package binarySearch;

//https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15
public class MinimumDiffElementInSortedArray {

	public int findMinDiff(int[] arr, int key) {
		int n = arr.length;
		if (arr[0] > key)
			return Math.abs(arr[0] - key);
		if (arr[n - 1] < key)
			return Math.abs(arr[n - 1] - key);
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key)
				return arr[mid];
			else if (arr[mid] > key)
				high = mid - 1;
			else
				low = mid + 1;
		}
		// low and high point to the neighbors where the key would be present if it was
		// present in the array
		return Math.min(Math.abs(arr[low] - key), Math.abs(arr[high] - key));
	}
}
