package binarySearch;

//https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=10

public class FloorInASortedArray {

	// https://leetcode.com/problems/search-insert-position/
	public int findTargetIndex(int[] arr, int k) {
		int n = arr.length;
		int low = 0, high = n - 1;
		if (arr[low] > k)
			return 0;
		if (arr[high] < k)
			return high + 1;
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k)
				return mid;
			else if (k > arr[mid]) {
				// difference with next implementation as correct index and not floor is the
				// value that is asked for
				res = mid + 1;
				low = mid + 1;
			} else if (k < arr[mid])
				high = mid - 1;
		}
		return res;
	}

	// https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1#
	public int findFloor(int[] arr, int k) {
		int n = arr.length;
		int low = 0, high = n - 1;
		int mid = -1;
		int res = -1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == k)
				return mid;
			else if (k > arr[mid]) {
				res = mid;
				low = mid + 1;
			} else if (k < arr[mid])
				high = mid - 1;
		}
		return res;
	}
}
