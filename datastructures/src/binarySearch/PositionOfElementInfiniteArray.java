package binarySearch;

//https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13
public class PositionOfElementInfiniteArray {

	public long findPosition(int[] arr, int k) {
		int low = 0, high = 1;
		while (arr[high] < k) {
			low = high;
			high *= 2;
		}
		// now the element is in the bounded array
		return binarySearch(arr, low, high, k);
	}

	private long binarySearch(int[] arr, int low, int high, int k) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k)
				return mid;
			else if (arr[mid] > k)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
}
