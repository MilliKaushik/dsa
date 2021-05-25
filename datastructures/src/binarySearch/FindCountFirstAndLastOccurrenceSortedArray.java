package binarySearch;

public class FindCountFirstAndLastOccurrenceSortedArray {

	public int countOccurrence(int[] arr, int k) {
		int low = 0, high = arr.length;
		int firstIndex = findFirstOccurrence(arr, k);
		// index of first could be used to limit serach of last occurrence
		int lastIndex = findLastOccurrence(arr, k);
		return lastIndex - firstIndex + 1;
	}

	public int findFirstOccurrence(int[] arr, int k) {
		int low = 0, high = arr.length - 1;
		int res = -1;
		while (low <= high) {
			// Take mid this way to avoid integer overflow state when low + high /2
			int mid = low + (high - low) / 2;
			if (arr[mid] == k) {
				// only two line change from normal binary search
				res = mid;
				high = mid - 1;
			} else if (arr[mid] < k)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return res;
	}

	public int findLastOccurrence(int[] arr, int k) {
		int low = 0, high = arr.length - 1;
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k) {
				// only two line change from normal binary search
				res = mid;
				low = mid + 1;
			} else if (arr[mid] < k)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return res;
	}

}
