package binarySearch;

//https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17
//https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
//https://leetcode.com/problems/find-peak-element/
//https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/801/
public class PeakElement {

	public int findPeak(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;

		if (n == 1)
			return 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < n - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
					return mid;
				else if (arr[mid] < arr[mid - 1])
					high = mid - 1;
				else
					low = mid + 1;
			} else if (mid == 0) {
				if (arr[0] > arr[1])
					return 0;
				else
					return 1;
			} else if (mid == n - 1) {
				if (arr[n - 1] > arr[n - 2])
					return n - 1;
			}
		}
		return 0;
	}
}
