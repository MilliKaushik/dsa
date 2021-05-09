package array.binarySearch;

//https://www.youtube.com/watch?v=8x6dmO6XW8k&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=14
public class PosOneInfiniteBinarySortedArray {

	public int findPos(int[] arr) {
		if (arr[0] == 1)
			return 0;
		int low = 0;
		int high = arr.length - 1;
		while (arr[high] == 0) {
			low = high;
			high *= 2;
		}
		return binarySearch(arr, low, high);
	}

	private int binarySearch(int[] arr, int low, int high) {
		int res = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == 1) {
				res = mid;
				high = mid - 1;
			} else if (arr[mid] == 0)
				low = mid + 1;
		}
		return res;
	}

}
