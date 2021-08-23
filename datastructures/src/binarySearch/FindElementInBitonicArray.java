package binarySearch;

//https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19
//https://www.geeksforgeeks.org/find-element-bitonic-array/
//https://www.interviewbit.com/problems/search-in-bitonic-array/
public class FindElementInBitonicArray {

	public int findElement(int[] arr, int key) {
		int n = arr.length;
		int maxIndex = findMaxIndexInBitonicArray(arr);
		int leftIndex = ascendingBinarySearch(arr, 0, maxIndex, key);
		if (leftIndex != -1)
			return leftIndex;
		// the second part of array is sorted in decreasing order
		return descendingBinarySearch(arr, maxIndex + 1, n - 1, key);
	}

	private int ascendingBinarySearch(int[] arr, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	private int descendingBinarySearch(int[] arr, int low, int high, int key) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	private int findMaxIndexInBitonicArray(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < n - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
					return mid;
				else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
					low = mid + 1;
				else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1])
					high = mid - 1;
			} else if (mid == 0) {
				if (arr[0] > arr[1])
					return 0;
				else
					return 1;
			} else if (mid == n - 1) {
				if (arr[n - 1] > arr[n - 2])
					return n - 1;
				else
					return n - 2;
			}
		}
		return -1;
	}
}
