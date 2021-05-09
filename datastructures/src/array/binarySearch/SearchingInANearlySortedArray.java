	package array.binarySearch;

//https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
public class SearchingInANearlySortedArray {

	public int search(int[] arr, int k) {
		int n = arr.length;
		int low = 0, high = n - 1;
		int mid = -1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == k)
				return mid;
			if (mid - 1 >= 0 && arr[mid - 1] == k)
				return mid - 1;
			if (mid + 1 < n && arr[mid + 1] == k)
				return mid + 1;
			else if (k < arr[mid])
				high = mid - 2;
			else
				low = mid + 2;
		}
		return -1;
	}

	// based on above concept
	// https://leetcode.com/problems/single-element-in-a-sorted-array/
	public int singleNonDuplicate(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		int res = -1;
		boolean left, right;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			left = false;
			right = false;
			if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
				left = true;
				if ((mid - 1) % 2 != 0)
					high = mid - 2;
				else
					low = mid + 1;
			} else if (mid + 1 < n && arr[mid + 1] == arr[mid]) {
				right = true;
				if ((mid + 1) % 2 != 0)
					low = mid + 2;
				else
					high = mid - 1;
			}
			if (!left && !right)
				return arr[mid];
			// removing that half where no of elements is even
		}
		return res;
	}
}
