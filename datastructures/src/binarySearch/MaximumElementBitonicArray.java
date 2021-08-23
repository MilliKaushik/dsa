package binarySearch;

//https://www.youtube.com/watch?v=BrrZL1RDMwc&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=18
//This is equivalent to finding a peak element in an array in which elements 
//are monotonically increasing and then monotonically decreasing
public class MaximumElementBitonicArray {

	public int findMax(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < n - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
					return mid;
				else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])
					low = mid + 1;
				else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1])
					high = mid - 1;
			} else if (mid == 0) {
				if (arr[0] > arr[1])
					return 0;
				else
					return 1;
			} else if (mid == n - 1) {
				if (arr[n - 2] > arr[n - 1])
					return n - 2;
				else
					return n - 1;
			}
		}
		return 0;
	}
}
