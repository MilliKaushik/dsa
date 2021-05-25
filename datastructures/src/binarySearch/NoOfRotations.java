package binarySearch;

//https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7
public class NoOfRotations {

	public int findNoOfRotations(int[] arr) {
		// no of rotations = index of minimum element
		int n = arr.length;
		int low = 0, high = n - 1;
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;
			if (arr[mid] < arr[prev] && arr[mid] < arr[next])
				break;
			else if (arr[low] <= arr[mid])
				low = mid + 1;
			else if (arr[mid] <= arr[high])
				high = mid - 1;
		}
		return mid;
	}
}
