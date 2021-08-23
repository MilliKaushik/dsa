package binarySearch;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/
public class MinimumInRotatedSortedArrayDuplicate {

	public static int findMin(int[] arr) {
		int low = 0, high = arr.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < arr[high])
				high = mid;
			else if (arr[mid] > arr[high])
				low = mid + 1;
			else 
				high -= 1;
		}
		return arr[low];
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 1, 1, 1, 2, 2, 2, 2, 2 }));
		System.out.println(findMin(new int[] { 0, 1, 1, 2, 2, 2, 2 }));
		System.out.println(findMin(new int[] { 1, 1, 1, 2, 2, 2, 0, 0, 0 }));
	}
}
