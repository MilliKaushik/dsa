package array.binarySearch;

public class CeilingASortedArray {

	public int ceil(int[] arr, int k) {
		int n = arr.length;
		int low = 0, high = n - 1;
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k)
				return mid;
			// a possible candidate hence updating res to this index
			else if (arr[mid] > k) {
				res = mid;
				low = mid + 1;
			} else if (arr[mid] < k)
				high = mid - 1;
		}
		return res;
	}

}
