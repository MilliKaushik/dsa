package binarySearch;

public class NoOfTimesRotatedCOPY {

	public int minimumInRotatedSortedArray(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;
			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
				return arr[mid];
			else if (arr[low] <= arr[mid] && arr[0] <= arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return arr[0];
	}

	public int[] missingDuplicate(int[] arr) {
		int n = arr.length;
		int i = 0, j = n - 1;
		while (i < n) {
			while (i < j && arr[i] != i + 1) {
				swap(arr, i, j);
				j--;
			}
			i++;
		}
		int[] result = new int[2];
		for (i = 0; i < n; i++)
			if (arr[i] != (i + 1))
				break;
		result[0] = i + 1;
		result[1] = arr[i];
		return result;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public int minimum(int[] arr) {
		int n = arr.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;
			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next])
				return arr[mid];
			else if (arr[low] <= arr[mid] && arr[0] <= arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return arr[0];
	}
}
