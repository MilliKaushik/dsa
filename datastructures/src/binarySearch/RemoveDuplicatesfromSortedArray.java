package binarySearch;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
public class RemoveDuplicatesfromSortedArray {

	// https://www.geeksforgeeks.org/remove-duplicates-sorted-array/
	// O(n)
	public int removeDuplicates1(int[] arr) {
		int index = 0;
		int n = arr.length;
		if (n == 0 || n == 1)
			return n;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1])
				arr[index++] = arr[i];
		}
		arr[index++] = arr[n - 1];
		return index;
	}

	// O(nlogn)
	public int removeDuplicates(int[] arr) {
		int n = arr.length;
		int index = 0;
		int length = 0;
		int i = 0;
		while (i < n) {
			arr[index] = arr[i];
			int currLastOccurrence = findLastOccurrence(arr, i, n - 1, arr[i]);
			length++;
			index++;
			i = currLastOccurrence + 1;
		}
		return length;
	}

	private int findLastOccurrence(int[] arr, int low, int high, int k) {
		int result = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k) {
				result = mid;
				low = mid + 1;
			} else if (arr[mid] > k)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return result;
	}
}
